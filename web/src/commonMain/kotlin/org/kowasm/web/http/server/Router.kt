package org.kowasm.web.http.server

/**
 * Provides access to route functions and builder.
 */
object Router {

    /**
     * Create a [Router.Builder] to define routes.
     */
    fun route(): Builder {
        return RouterBuilder()
    }

    /**
     * Create a [RouterHandler] invoking the specified [ExchangeHandler] when the specified [RequestPredicate] matches.
     */
    fun route(predicate: RequestPredicate, handlerFunction: ExchangeHandler): RouterHandler {
        return DefaultRouterHandler(predicate, handlerFunction)
    }

    /**
     * Builder for defining routes.
     */
    interface Builder {

        /**
         * Define a route for GET requests with the specified path pattern.
         */
        fun GET(pattern: String, handler: ExchangeHandler): Builder

        /**
         * Define a route for POST requests with the specified path pattern.
         */
        fun HEAD(pattern: String, handler: ExchangeHandler): Builder

        /**
         * Define a route for POST requests with the specified path pattern.
         */
        fun POST(pattern: String, handler: ExchangeHandler): Builder

        /**
         * Define a route for PUT requests with the specified path pattern.
         */
        fun PUT(pattern: String, handler: ExchangeHandler): Builder

        /**
         * Define a route for PATCH requests with the specified path pattern.
         */
        fun PATCH(pattern: String, handler: ExchangeHandler): Builder

        /**
         * Define a route for DELETE requests with the specified path pattern.
         */
        fun DELETE(pattern: String, handler: ExchangeHandler): Builder

        /**
         * Define a route for OPTIONS requests with the specified path pattern.
         */
        fun OPTIONS(pattern: String, handler: ExchangeHandler): Builder

        /**
         * Add the specified [RouterHandler] to the routes.
         */
        fun add(routerHandler: RouterHandler): Builder

        /**
         * Build the [Router] from the defined routes.
         */
        fun build(): RouterHandler
    }

    private class DefaultRouterHandler(private val predicate: RequestPredicate, private val handler: ExchangeHandler) : RouterHandler {

        override fun invoke(request: ServerRequest): ExchangeHandler? {
            return if (predicate.test(request)) {
                handler
            } else {
                null
            }
        }

    }
}

internal class RouterBuilder : Router.Builder {

    private val routerFunctions: MutableList<RouterHandler> = ArrayList()

    override fun add(routerHandler: RouterHandler): Router.Builder {
        routerFunctions.add(routerHandler)
        return this
    }

    private fun add(
        predicate: RequestPredicate,
        handler: ExchangeHandler
    ): Router.Builder {
        routerFunctions.add(Router.route(predicate, handler))
        return this
    }

    override fun GET(pattern: String, handler: ExchangeHandler): Router.Builder {
        return add(RequestPredicates.GET(pattern), handler)
    }

    override fun HEAD(pattern: String, handler: ExchangeHandler): Router.Builder {
        return add(RequestPredicates.HEAD(pattern), handler)
    }

    override fun POST(pattern: String, handler: ExchangeHandler): Router.Builder {
        return add(RequestPredicates.POST(pattern), handler)
    }

    override fun PUT(pattern: String, handler: ExchangeHandler): Router.Builder {
        return add(RequestPredicates.PUT(pattern), handler)
    }

    override fun PATCH(pattern: String, handler: ExchangeHandler): Router.Builder {
        return add(RequestPredicates.PATCH(pattern), handler)
    }

    override fun DELETE(pattern: String, handler: ExchangeHandler): Router.Builder {
        return add(RequestPredicates.DELETE(pattern), handler)
    }

    override fun OPTIONS(pattern: String, handler: ExchangeHandler): Router.Builder {
        return add(RequestPredicates.OPTIONS(pattern), handler)
    }

    override fun build(): RouterHandler {
        check(routerFunctions.isNotEmpty()) { "No routes registered. Register a route with GET(), POST(), etc." }
        return RouterFunctions(routerFunctions)

    }

    private class RouterFunctions(private val routerFunctions: List<RouterHandler>) : RouterHandler {

        override fun invoke(request: ServerRequest): ExchangeHandler? {
            for (routerFunction in routerFunctions) {
                val result = routerFunction.invoke(request)
                if (result != null) {
                    return result
                }
            }
            return null
        }
    }
}

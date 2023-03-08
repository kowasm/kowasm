package org.kowasm.web.server

import org.kowasm.web.HttpMethod

object WebRouter {

    fun route(): Builder {
        return WebRouterBuilder()
    }

    fun route(predicate: RequestPredicate, handlerFunction: ServerHandler): RouterHandler {
        return DefaultRouterHandler(predicate, handlerFunction)
    }

    interface Builder {

        fun GET(handler: ServerHandler): Builder

        fun GET(pattern: String, handler: ServerHandler): Builder

        fun HEAD(handler: ServerHandler): Builder

        fun HEAD(pattern: String, handler: ServerHandler): Builder

        fun POST(handler: ServerHandler): Builder

        fun POST(pattern: String, handler: ServerHandler): Builder

        fun PUT(handler: ServerHandler): Builder

        fun PUT(pattern: String, handler: ServerHandler): Builder

        fun PATCH(handler: ServerHandler): Builder

        fun PATCH(pattern: String, handler: ServerHandler): Builder

        fun DELETE(handler: ServerHandler): Builder

        fun DELETE(pattern: String, handler: ServerHandler): Builder

        fun OPTIONS(handler: ServerHandler): Builder

        fun OPTIONS(pattern: String, handler: ServerHandler): Builder

        fun add(routerHandler: RouterHandler): Builder

        fun build(): RouterHandler
    }

    private class DefaultRouterHandler(private val predicate: RequestPredicate, private val handler: ServerHandler) :
        RouterHandler {

        override fun invoke(request: ServerRequest): ServerHandler? {
            return if (predicate.test(request)) {
                handler
            } else {
                null
            }
        }

    }
}

internal class WebRouterBuilder  : WebRouter.Builder {

    private val routerFunctions: MutableList<RouterHandler> = ArrayList()

    override fun add(routerHandler: RouterHandler): WebRouter.Builder {
        routerFunctions.add(routerHandler)
        return this
    }

    private fun add(
        predicate: RequestPredicate,
        handler: ServerHandler
    ): WebRouter.Builder {
        routerFunctions.add(WebRouter.route(predicate, handler))
        return this
    }

    override fun GET(handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.method(HttpMethod.GET), handler)
    }

    override fun GET(pattern: String, handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.GET(pattern), handler)
    }

    override fun HEAD(handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.method(HttpMethod.HEAD), handler)
    }

    override fun HEAD(pattern: String, handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.HEAD(pattern), handler)
    }

    override fun POST(pattern: String, handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.POST(pattern), handler)
    }

    override fun POST(handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.method(HttpMethod.POST), handler)
    }

    override fun PUT(pattern: String, handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.PUT(pattern), handler)
    }

    override fun PUT(handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.method(HttpMethod.PUT), handler)
    }

    override fun PATCH(pattern: String, handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.PATCH(pattern), handler)
    }

    override fun PATCH(handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.method(HttpMethod.PATCH), handler)
    }

    override fun DELETE(pattern: String, handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.DELETE(pattern), handler)
    }

    override fun DELETE(handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.method(HttpMethod.DELETE), handler)
    }

    override fun OPTIONS(pattern: String, handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.OPTIONS(pattern), handler)
    }

    override fun OPTIONS(handler: ServerHandler): WebRouter.Builder {
        return add(RequestPredicates.method(HttpMethod.OPTIONS), handler)
    }

    override fun build(): RouterHandler {
        check(routerFunctions.isNotEmpty()) { "No routes registered. Register a route with GET(), POST(), etc." }
        return BuiltRouterFunction(routerFunctions)

    }

    private class BuiltRouterFunction(private val routerFunctions: List<RouterHandler>) : RouterHandler {

        override fun invoke(request: ServerRequest): ServerHandler? {
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

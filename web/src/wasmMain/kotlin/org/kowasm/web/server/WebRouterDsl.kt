package org.kowasm.web.server

import org.kowasm.web.HttpStatus

class WebRouterDsl internal constructor (private val dsl: (WebRouterDsl.() -> Unit)) {

    @PublishedApi
    internal val builder = WebRouter.route()

    fun GET(f: ServerHandler) {
        builder.GET(f)
    }

    fun GET(pattern: String, f: ServerHandler) {
        builder.GET(pattern, f)
    }

    fun HEAD(f: ServerHandler) {
        builder.HEAD(f)
    }

    fun HEAD(pattern: String, f: ServerHandler) {
        builder.HEAD(pattern, f)
    }

    fun POST(f: ServerHandler) {
        builder.POST(f)
    }

    fun POST(pattern: String, f: ServerHandler) {
        builder.POST(pattern, f)
    }

    fun PUT(f: ServerHandler) {
        builder.PUT(f)
    }

    fun PUT(pattern: String, f: ServerHandler) {
        builder.PUT(pattern, f)
    }

    fun PATCH(f: ServerHandler) {
        builder.PATCH(f)
    }

    fun PATCH(pattern: String, f: ServerHandler) {
        builder.PATCH(pattern, f)
    }

    fun DELETE(f: ServerHandler) {
        builder.DELETE(f)
    }

    fun DELETE(pattern: String, f: ServerHandler) {
        builder.DELETE(pattern, f)
    }

    fun OPTIONS(f: ServerHandler) {
        builder.OPTIONS(f)
    }

    fun OPTIONS(pattern: String, f: ServerHandler) {
        builder.OPTIONS(pattern, f)
    }


    /**
     * Return a composed routing function created from all the registered routes.
     */
    internal fun build(): RouterHandler {
        dsl()
        return builder.build()
    }

    /**
     * @see ServerResponse.ok
     */
    fun ok() = ServerResponse.ok()

    /**
     * @see ServerResponse.noContent
     */
    fun noContent() = ServerResponse.noContent()

    /**
     * @see ServerResponse.accepted
     */
    fun accepted() = ServerResponse.accepted()

    /**
     * @see ServerResponse.badRequest
     */
    fun badRequest() = ServerResponse.badRequest()

    /**
     * @see ServerResponse.notFound
     */
    fun notFound() = ServerResponse.notFound()

    /**
     * @see ServerResponse.status
     */
    fun status(status: HttpStatus) = ServerResponse.status(status)

}

package org.kowasm.web.http.server

import org.kowasm.core.Dsl
import org.kowasm.web.http.*

/**
 * Dsl for configuring a router.
 */
@Dsl
class RouterDsl internal constructor (private val dsl: (RouterDsl.() -> Unit)) {

    @PublishedApi
    internal val builder = Router.route()

    infix fun RequestPredicate.and(other: String): RequestPredicate = this.and(path(other))

    infix fun RequestPredicate.or(other: String): RequestPredicate = this.or(path(other))

    infix fun String.and(other: RequestPredicate): RequestPredicate = path(this).and(other)

    infix fun String.or(other: RequestPredicate): RequestPredicate = path(this).or(other)

    infix fun RequestPredicate.and(other: RequestPredicate): RequestPredicate = this.and(other)

    infix fun RequestPredicate.or(other: RequestPredicate): RequestPredicate = this.or(other)

    operator fun RequestPredicate.not(): RequestPredicate = this.negate()

    operator fun RequestPredicate.invoke(f: (ServerRequest) -> ServerResponse) {
        builder.add(Router.route(this, f))
    }

    fun GET(f: ServerHandler) {
        builder.GET(f)
    }

    fun GET(pattern: String, f: ServerHandler) {
        builder.GET(pattern, f)
    }

    fun GET(pattern: String): RequestPredicate = RequestPredicates.GET(pattern)

    fun HEAD(f: ServerHandler) {
        builder.HEAD(f)
    }

    fun HEAD(pattern: String, f: ServerHandler) {
        builder.HEAD(pattern, f)
    }

    fun HEAD(pattern: String): RequestPredicate = RequestPredicates.HEAD(pattern)

    fun POST(f: ServerHandler) {
        builder.POST(f)
    }

    fun POST(pattern: String, f: ServerHandler) {
        builder.POST(pattern, f)
    }

    fun POST(pattern: String): RequestPredicate = RequestPredicates.POST(pattern)

    fun PUT(f: ServerHandler) {
        builder.PUT(f)
    }

    fun PUT(pattern: String, f: ServerHandler) {
        builder.PUT(pattern, f)
    }

    fun PUT(pattern: String): RequestPredicate = RequestPredicates.PUT(pattern)

    fun PATCH(f: ServerHandler) {
        builder.PATCH(f)
    }

    fun PATCH(pattern: String, f: ServerHandler) {
        builder.PATCH(pattern, f)
    }

    fun PATCH(pattern: String): RequestPredicate = RequestPredicates.PATCH(pattern)


    fun DELETE(f: ServerHandler) {
        builder.DELETE(f)
    }

    fun DELETE(pattern: String, f: ServerHandler) {
        builder.DELETE(pattern, f)
    }

    fun DELETE(pattern: String): RequestPredicate = RequestPredicates.DELETE(pattern)


    fun OPTIONS(f: ServerHandler) {
        builder.OPTIONS(f)
    }

    fun OPTIONS(pattern: String, f: ServerHandler) {
        builder.OPTIONS(pattern, f)
    }

    fun OPTIONS(pattern: String): RequestPredicate = RequestPredicates.OPTIONS(pattern)

    fun headers(headersPredicate: (RequestHeaders) -> Boolean): RequestPredicate =
        RequestPredicates.headers(headersPredicate)

    // TODO Implement real media type matching
    fun accept(mediaType: MediaType): RequestPredicate =
        RequestPredicates.headers { it[RequestHeaderName.ACCEPT]?.any { value -> value.contains(mediaType.toString()) } ?: false }

    fun method(method: Method): RequestPredicate = RequestPredicates.method(method)

    fun path(pattern: String): RequestPredicate = RequestPredicates.path(pattern)

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
    fun status(status: StatusCode) = ServerResponse.status(status)

}

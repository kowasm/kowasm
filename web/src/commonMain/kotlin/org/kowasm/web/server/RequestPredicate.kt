package org.kowasm.web.server

import org.kowasm.web.HttpHeaders
import org.kowasm.web.Method

fun interface RequestPredicate {

    fun test(request: ServerRequest): Boolean

    fun and(other: RequestPredicate): RequestPredicate {
        return RequestPredicates.AndRequestPredicate(this, other)
    }

    fun negate(): RequestPredicate {
        return RequestPredicates.NegateRequestPredicate(this)
    }

    fun or(other: RequestPredicate): RequestPredicate {
        return RequestPredicates.OrRequestPredicate(this, other)
    }

    fun nest(request: ServerRequest): ServerRequest? {
        return if (test(request)) request else null
    }
}

object RequestPredicates {

    fun all() = RequestPredicate { true }

    fun method(method: Method): RequestPredicate {
        return HttpMethodPredicate(method)
    }

    @Suppress("NAME_SHADOWING")
    fun path(path: String): RequestPredicate {
        var path = path
        if (path.isNotEmpty() && !path.startsWith("/")) {
            path = "/$path"
        }
        return PathPredicate(path)
    }

    fun headers(headersPredicate: (HttpHeaders) -> Boolean): RequestPredicate {
        return HeadersPredicate(headersPredicate)
    }

    fun GET(pattern: String): RequestPredicate {
        return method(Method.GET).and(path(pattern))
    }

    fun HEAD(pattern: String): RequestPredicate {
        return method(Method.HEAD).and(path(pattern))
    }

    fun POST(pattern: String): RequestPredicate {
        return method(Method.POST).and(path(pattern))
    }

    fun PUT(pattern: String): RequestPredicate {
        return method(Method.PUT).and(path(pattern))
    }

    fun PATCH(pattern: String): RequestPredicate {
        return method(Method.PATCH).and(path(pattern))
    }

    fun DELETE(pattern: String): RequestPredicate {
        return method(Method.DELETE).and(path(pattern))
    }

    fun OPTIONS(pattern: String): RequestPredicate {
        return method(Method.OPTIONS).and(path(pattern))
    }

    private class HttpMethodPredicate : RequestPredicate {
        private val methods: Set<Method>

        constructor(method: Method) {
            methods = setOf(method)
        }

        constructor(vararg methods: Method) {
            this.methods = setOf(*methods)
        }

        override fun test(request: ServerRequest): Boolean {
            return methods.contains(request.method)
        }

    }

    private class PathPredicate(private val path: String) : RequestPredicate {
        override fun test(request: ServerRequest): Boolean {
            // TODO refine
            return request.path == path
        }
    }

    private class HeadersPredicate(private val headersPredicate: (HttpHeaders) -> Boolean) : RequestPredicate {
        override fun test(request: ServerRequest) = headersPredicate.invoke(request.headers)
    }

    internal class AndRequestPredicate(private val left: RequestPredicate, private val right: RequestPredicate) :
        RequestPredicate {
        override fun test(request: ServerRequest): Boolean {
            return left.test(request) && right.test(request)
        }
    }

    internal class NegateRequestPredicate(private val delegate: RequestPredicate) : RequestPredicate {
        override fun test(request: ServerRequest): Boolean {
            return !delegate.test(request)
        }
    }

    internal class OrRequestPredicate(private val left: RequestPredicate, private val right: RequestPredicate) :
        RequestPredicate {
        override fun test(request: ServerRequest): Boolean {
            if (left.test(request)) {
                return true
            } else {
                if (right.test(request)) {
                    return true
                }
            }
            return false
        }
    }
}

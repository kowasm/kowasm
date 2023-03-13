/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.http.server

import org.kowasm.web.http.Method
import org.kowasm.web.http.RequestHeaders

/**
 * Represents a function that evaluates on a given [ServerRequest].
 *
 * Instances of this function that evaluate on common request properties
 * can be found in [RequestPredicates].
 *
 * Inspired by Spring `org.springframework.web.servlet.function.RequestPredicate`.
 */
fun interface RequestPredicate {

    /**
     * Evaluate this predicate on the given request.
     * @param request the request to match against
     * @return `true` if the request matches the predicate, `false` otherwise
     */
    fun test(request: ServerRequest): Boolean

    /**
     * Return a composed request predicate that tests against both this predicate AND
     * the `other` predicate. When evaluating the composed predicate, if this
     * predicate is `false`, then the `other` predicate is not evaluated.
     * @param other a predicate that will be logically-ANDed with this predicate
     * @return a predicate composed of this predicate AND the `other` predicate
     */
    fun and(other: RequestPredicate): RequestPredicate {
        return RequestPredicates.AndRequestPredicate(this, other)
    }

    /**
     * Return a predicate that represents the logical negation of this predicate.
     * @return a predicate that represents the logical negation of this predicate
     */
    fun negate(): RequestPredicate {
        return RequestPredicates.NegateRequestPredicate(this)
    }

    /**
     * Return a composed request predicate that tests against both this predicate OR
     * the `other` predicate. When evaluating the composed predicate, if this
     * predicate is `true`, then the `other` predicate is not evaluated.
     * @param other a predicate that will be logically-ORed with this predicate
     * @return a predicate composed of this predicate OR the `other` predicate
     */
    fun or(other: RequestPredicate): RequestPredicate {
        return RequestPredicates.OrRequestPredicate(this, other)
    }
}

/**
 * Implementations of [RequestPredicate] that implement various useful
 * request matching operations, such as matching based on path, HTTP method, etc.
 *
 * Inspired by Spring `org.springframework.web.servlet.function.RequestPredicates`.
 */
object RequestPredicates {

    /**
     * Return a [RequestPredicate] that always matches.
     * @return a predicate that always matches
     */
    fun all() = RequestPredicate { true }

    /**
     * Return a [RequestPredicate] that matches if the request's
     * HTTP method is equal to the given method.
     * @param method the HTTP method to match against
     * @return a predicate that tests against the given HTTP method
     */
    fun method(method: Method): RequestPredicate {
        return HttpMethodPredicate(method)
    }

    /**
     * Return a [RequestPredicate] that matches if the request's
     * HTTP method is equal to the given methods.
     * @param methods the HTTP methods   to match against
     * @return a predicate that tests against the given HTTP methods
     */
    fun methods(vararg methods: Method): RequestPredicate {
        return HttpMethodPredicate(*methods)
    }

    /**
     * Return a [RequestPredicate] that tests the request path
     * against the given path pattern.
     * TODO support path pattern
     * @param pattern the path pattern to match to
     * @return a predicate that tests against the given path pattern
     */
    @Suppress("NAME_SHADOWING")
    fun path(pattern: String): RequestPredicate {
        var pattern = pattern
        if (pattern.isNotEmpty() && !pattern.startsWith("/")) {
            pattern = "/$pattern"
        }
        return PathPredicate(pattern)
    }

    /**
     * Return a [RequestPredicate] that tests the request's headers
     * against the given headers predicate.
     * @param headersPredicate a predicate that tests against the request headers
     * @return a predicate that tests against the given header predicate
     */
    fun headers(headersPredicate: (RequestHeaders) -> Boolean): RequestPredicate {
        return HeadersPredicate(headersPredicate)
    }

    /**
     * Return a [RequestPredicate] that matches if request's HTTP method is GET
     * and the given `pattern` matches against the request path.
     * @param pattern the path pattern to match against
     * @return a predicate that matches if the request method is GET and if the given pattern
     * matches against the request path
     */
    fun GET(pattern: String): RequestPredicate {
        return method(Method.GET).and(path(pattern))
    }

    /**
     * Return a [RequestPredicate] that matches if request's HTTP method is HEAD
     * and the given `pattern` matches against the request path.
     * @param pattern the path pattern to match against
     * @return a predicate that matches if the request method is HEAD and if the given pattern
     * matches against the request path
     */
    fun HEAD(pattern: String): RequestPredicate {
        return method(Method.HEAD).and(path(pattern))
    }

    /**
     * Return a [RequestPredicate] that matches if request's HTTP method is POST
     * and the given `pattern` matches against the request path.
     * @param pattern the path pattern to match against
     * @return a predicate that matches if the request method is POST and if the given pattern
     * matches against the request path
     */
    fun POST(pattern: String): RequestPredicate {
        return method(Method.POST).and(path(pattern))
    }

    /**
     * Return a [RequestPredicate] that matches if request's HTTP method is PUT
     * and the given `pattern` matches against the request path.
     * @param pattern the path pattern to match against
     * @return a predicate that matches if the request method is PUT and if the given pattern
     * matches against the request path
     */
    fun PUT(pattern: String): RequestPredicate {
        return method(Method.PUT).and(path(pattern))
    }

    /**
     * Return a [RequestPredicate] that matches if request's HTTP method is PATCH
     * and the given `pattern` matches against the request path.
     * @param pattern the path pattern to match against
     * @return a predicate that matches if the request method is PATCH and if the given pattern
     * matches against the request path
     */
    fun PATCH(pattern: String): RequestPredicate {
        return method(Method.PATCH).and(path(pattern))
    }

    /**
     * Return a [RequestPredicate] that matches if request's HTTP method is DELETE
     * and the given `pattern` matches against the request path.
     * @param pattern the path pattern to match against
     * @return a predicate that matches if the request method is DELETE and if the given pattern
     * matches against the request path
     */
    fun DELETE(pattern: String): RequestPredicate {
        return method(Method.DELETE).and(path(pattern))
    }

    /**
     * Return a [RequestPredicate] that matches if request's HTTP method is OPTIONS
     * and the given `pattern` matches against the request path.
     * @param pattern the path pattern to match against
     * @return a predicate that matches if the request method is OPTIONS and if the given pattern
     * matches against the request path
     */
    fun OPTIONS(pattern: String): RequestPredicate {
        return method(Method.OPTIONS).and(path(pattern))
    }

    private class HttpMethodPredicate : RequestPredicate {
        private val methods: Set<Method>

        constructor(vararg methods: Method) {
            this.methods = setOf(*methods)
        }

        override fun test(request: ServerRequest): Boolean {
            return methods.contains(request.method)
        }

    }

    private class PathPredicate(private val pattern: String) : RequestPredicate {
        override fun test(request: ServerRequest): Boolean {
            // TODO support path pattern
            return request.path == pattern
        }
    }

    private class HeadersPredicate(private val headersPredicate: (RequestHeaders) -> Boolean) : RequestPredicate {
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

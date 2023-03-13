/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.http

/**
 * A request HTTP header, as defined in the [RFC 7231](https://www.rfc-editor.org/rfc/rfc7231#section-5).
 */
sealed class RequestHeaderName(name: String) : HeaderName(name) {

    /**
     * The HTTP [`Accept`](https://www.rfc-editor.org/rfc/rfc7231#section-5.3.2) header field name.
     */
    object ACCEPT : RequestHeaderName("Accept")

    /**
     * The HTTP [`Accept-Charset`](https://www.rfc-editor.org/rfc/rfc7231#section-5.3.3) header field name.
     */
    object ACCEPT_CHARSET : RequestHeaderName("Accept-Charset")

    /**
     * The HTTP [`Accept-Encoding`](https://www.rfc-editor.org/rfc/rfc7231#section-5.3.4) header field name.
     */
    object ACCEPT_ENCODING : RequestHeaderName("Accept-Encoding")

    /**
     * The HTTP [`Accept-Language`](https://www.rfc-editor.org/rfc/rfc7231#section-5.3.5) header field name.
     */
    object ACCEPT_LANGUAGE : RequestHeaderName("Accept-Language")

    /**
     * The HTTP [`Authorization`](https://www.rfc-editor.org/rfc/rfc7231#section-5.4) header field name.
     */
    object AUTHORIZATION : RequestHeaderName("Authorization")

    /**
     * The HTTP [`Cache-Control`](https://www.rfc-editor.org/rfc/rfc7234#section-5.2) header field name.
     */
    object CACHE_CONTROL : RequestHeaderName("Cache-Control")

    /**
     * The HTTP [`Cookie`](https://www.rfc-editor.org/rfc/rfc2109#section-4.3.4) header field name.
     */
    object COOKIE : RequestHeaderName("Cookie")

    /**
     * The HTTP [`Connection`](https://www.rfc-editor.org/rfc/rfc7230#section-6.1) header field name.
     */
    object CONNECTION : RequestHeaderName("Connection")

    /**
     * The HTTP [`Expect`](https://www.rfc-editor.org/rfc/rfc7231#section-5.1.1) header field name.
     */
    object EXPECT : RequestHeaderName("Expect")

    /**
     * The HTTP [`From`](https://www.rfc-editor.org/rfc/rfc7231#section-5.5.1) header field name.
     */
    object FROM : RequestHeaderName("From")

    /**
     * The HTTP [`Host`](https://www.rfc-editor.org/rfc/rfc7230#section-5.4) header field name.
     */
    object HOST : RequestHeaderName("Host")

    /**
     * The HTTP [`If-Match`](https://www.rfc-editor.org/rfc/rfc7232#section-3.1) header field name.
     */
    object IF_MATCH : RequestHeaderName("If-Match")

    /**
     * The HTTP [`If-Modified-Since`](https://www.rfc-editor.org/rfc/rfc7232#section-3.3) header field name.
     */
    object IF_MODIFIED_SINCE : RequestHeaderName("If-Modified-Since")

    /**
     * The HTTP [`If-None-Match`](https://www.rfc-editor.org/rfc/rfc7232#section-3.2) header field name.
     */
    object IF_NONE_MATCH : RequestHeaderName("If-None-Match")

    /**
     * The HTTP [`If-Unmodified-Since`](https://www.rfc-editor.org/rfc/rfc7232#section-3.4) header field name.
     */
    object IF_UNMODIFIED_SINCE : RequestHeaderName("If-Unmodified-Since")

    /**
     * The HTTP [`If-Range`](https://www.rfc-editor.org/rfc/rfc7233#section-3.2) header field name.
     */
    object IF_RANGE : RequestHeaderName("If-Range")

    /**
     * The HTTP [`Max-Forwards`](https://www.rfc-editor.org/rfc/rfc7231#section-5.1.2) header field name.
     */
    object MAX_FORWARDS : RequestHeaderName("Max-Forwards")

    /**
     * The HTTP [`Origin`](https://www.rfc-editor.org/rfc/rfc6454) header field name.
     */
    object ORIGIN : RequestHeaderName("Origin")

    /**
     * The HTTP [`Pragma`](https://www.rfc-editor.org/rfc/rfc7234#section-5.4) header field name.
     */
    object PRAGMA : RequestHeaderName("Pragma")

    /**
     * The HTTP [`Proxy-Authorization`](https://www.rfc-editor.org/rfc/rfc7231#section-5.4) header field name.
     */
    object PROXY_AUTHORIZATION : RequestHeaderName("Proxy-Authorization")

    /**
     * The HTTP [`Range`](https://www.rfc-editor.org/rfc/rfc7233#section-3.1) header field name.
     */
    object RANGE : RequestHeaderName("Range")

    /**
     * The HTTP [`Referer`](https://www.rfc-editor.org/rfc/rfc7231#section-5.5.2) header field name.
     */
    object REFERER : RequestHeaderName("Referer")

    /**
     * The HTTP [`TE`](https://www.rfc-editor.org/rfc/rfc7230#section-4.3) header field name.
     */
    object TE : RequestHeaderName("TE")

    /**
     * The HTTP [`User-Agent`](https://www.rfc-editor.org/rfc/rfc7231#section-5.5.3) header field name.
     */
    object USER_AGENT : RequestHeaderName("User-Agent")

    /**
     * A custom request header name.
     *
     * @param name The name of the header.
     */
    class Custom(name: String) : RequestHeaderName(name)

}

/**
 * Create a [RequestHeaderName] from a [String].
 *
 * @receiver The name of the header.
 */
fun String.toRequestHeaderName() = when (this) {
    RequestHeaderName.ACCEPT.name -> RequestHeaderName.ACCEPT
    RequestHeaderName.ACCEPT_CHARSET.name -> RequestHeaderName.ACCEPT_CHARSET
    RequestHeaderName.ACCEPT_ENCODING.name -> RequestHeaderName.ACCEPT_ENCODING
    RequestHeaderName.ACCEPT_LANGUAGE.name -> RequestHeaderName.ACCEPT_LANGUAGE
    RequestHeaderName.AUTHORIZATION.name -> RequestHeaderName.AUTHORIZATION
    RequestHeaderName.CACHE_CONTROL.name -> RequestHeaderName.CACHE_CONTROL
    RequestHeaderName.COOKIE.name -> RequestHeaderName.COOKIE
    RequestHeaderName.CONNECTION.name -> RequestHeaderName.CONNECTION
    RequestHeaderName.EXPECT.name -> RequestHeaderName.EXPECT
    RequestHeaderName.FROM.name -> RequestHeaderName.FROM
    RequestHeaderName.HOST.name -> RequestHeaderName.HOST
    RequestHeaderName.IF_MATCH.name -> RequestHeaderName.IF_MATCH
    RequestHeaderName.IF_MODIFIED_SINCE.name -> RequestHeaderName.IF_MODIFIED_SINCE
    RequestHeaderName.IF_NONE_MATCH.name -> RequestHeaderName.IF_NONE_MATCH
    RequestHeaderName.IF_UNMODIFIED_SINCE.name -> RequestHeaderName.IF_UNMODIFIED_SINCE
    RequestHeaderName.IF_RANGE.name -> RequestHeaderName.IF_RANGE
    RequestHeaderName.MAX_FORWARDS.name -> RequestHeaderName.MAX_FORWARDS
    RequestHeaderName.ORIGIN.name -> RequestHeaderName.ORIGIN
    RequestHeaderName.PRAGMA.name -> RequestHeaderName.PRAGMA
    RequestHeaderName.PROXY_AUTHORIZATION.name -> RequestHeaderName.PROXY_AUTHORIZATION
    RequestHeaderName.RANGE.name -> RequestHeaderName.RANGE
    RequestHeaderName.REFERER.name -> RequestHeaderName.REFERER
    RequestHeaderName.TE.name -> RequestHeaderName.TE
    RequestHeaderName.USER_AGENT.name -> RequestHeaderName.USER_AGENT
    else -> RequestHeaderName.Custom(this)
}
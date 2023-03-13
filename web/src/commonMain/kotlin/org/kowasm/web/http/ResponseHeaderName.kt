/*
 * Copyright 2023 the original author or authors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
 */

package org.kowasm.web.http

/**
 * A response HTTP header, as defined in the [RFC 7231](https://www.rfc-editor.org/rfc/rfc7231#section-7).
 */
sealed class ResponseHeaderName(name: String) : HeaderName(name) {

    /**
     * The HTTP [`Accept-Ranges`](https://www.rfc-editor.org/rfc/rfc7233#section-2.3) header field name.
     */
    object ACCEPT_RANGES : ResponseHeaderName("Accept-Ranges")

    /**
     * The HTTP [`Age`](https://www.rfc-editor.org/rfc/rfc7234#section-5.1) header field name.
     */
    object AGE : ResponseHeaderName("Age")

    /**
     * The HTTP [`Allow`](https://www.rfc-editor.org/rfc/rfc7231#section-7.4.1) header field name.
     */
    object ALLOW : ResponseHeaderName("Allow")

    /**
     * The HTTP [`Cache-Control`](https://www.rfc-editor.org/rfc/rfc7234#section-5.2) header field name.
     */
    object CACHE_CONTROL : ResponseHeaderName("Cache-Control")

    /**
     * The HTTP [`Connection`](https://www.rfc-editor.org/rfc/rfc7230#section-6.1) header field name.
     */
    object CONNECTION : ResponseHeaderName("Connection")

    /**
     * The HTTP ['Content-Type'](https://www.rfc-editor.org/rfc/rfc1049) header field name.
     */
    object CONTENT_TYPE : ResponseHeaderName("Content-Type")

    /**
     * The HTTP [`Date`](https://www.rfc-editor.org/rfc/rfc7231#section-7.1.1.2) header field name.
     */
    object DATE : ResponseHeaderName("Date")

    /**
     * The HTTP [`ETag`](https://www.rfc-editor.org/rfc/rfc7232#section-2.3) header field name.
     */
    object ETAG : ResponseHeaderName("ETag")

    /**
     * The HTTP [`Expires`](https://www.rfc-editor.org/rfc/rfc7234#section-5.3) header field name.
     */
    object EXPIRES : ResponseHeaderName("Expires")

    /**
     * The HTTP [`Last-Modified`](https://www.rfc-editor.org/rfc/rfc7232#section-2.2) header field name.
     */
    object LAST_MODIFIED : ResponseHeaderName("Last-Modified")

    /**
     * The HTTP [`Location`](https://www.rfc-editor.org/rfc/rfc7231#section-7.1.2) header field name.
     */
    object LOCATION : ResponseHeaderName("Location")

    /**
     * The HTTP [`Proxy-Authenticate`](https://www.rfc-editor.org/rfc/rfc7235#section-4.3) header field name.
     */
    object PROXY_AUTHENTICATE : ResponseHeaderName("Proxy-Authenticate")

    /**
     * The HTTP [`Retry-After`](https://www.rfc-editor.org/rfc/rfc7231#section-7.1.3) header field name.
     */
    object RETRY_AFTER : ResponseHeaderName("Retry-After")

    /**
     * The HTTP [`Server`](https://www.rfc-editor.org/rfc/rfc7231#section-7.4.2) header field name.
     */
    object SERVER : ResponseHeaderName("Server")

    /**
     * The HTTP [`Set-Cookie`](https://www.rfc-editor.org/rfc/rfc6265#section-4.1) header field name.
     */
    object SET_COOKIE : ResponseHeaderName("Set-Cookie")

    /**
     * The HTTP [`Vary`](https://www.rfc-editor.org/rfc/rfc7231#section-7.1.4) header field name.
     */
    object VARY : ResponseHeaderName("Vary")

    /**
     * The HTTP [`ETag`](https://www.rfc-editor.org/rfc/rfc7232#section-2.3) header field name.
     */
    object WARNING : ResponseHeaderName("Warning")

    /**
     * The HTTP [`UPGRADE`](https://www.rfc-editor.org/rfc/rfc7230#section-6.7) header field name.
     */
    object UPGRADE : ResponseHeaderName("Upgrade")

    /**
     * The HTTP [`WWW-Authenticate`](https://www.rfc-editor.org/rfc/rfc7235#section-4.1) header field name.
     */
    object WWW_AUTHENTICATE : ResponseHeaderName("WWW-Authenticate")

    /**
     * A custom response header name.
     *
     * @param name The name of the header.
     */
    class Custom(name: String) : ResponseHeaderName(name)
}


/**
 * Create a [ResponseHeaderName] from a [String].
 *
 * @receiver The name of the header.
 */
fun String.toResponseHeaderName() = when (this) {
    ResponseHeaderName.ACCEPT_RANGES.name -> ResponseHeaderName.ACCEPT_RANGES
    ResponseHeaderName.AGE.name -> ResponseHeaderName.AGE
    ResponseHeaderName.ALLOW.name -> ResponseHeaderName.ALLOW
    ResponseHeaderName.CACHE_CONTROL.name -> ResponseHeaderName.CACHE_CONTROL
    ResponseHeaderName.CONNECTION.name -> ResponseHeaderName.CONNECTION
    ResponseHeaderName.DATE.name -> ResponseHeaderName.DATE
    ResponseHeaderName.ETAG.name -> ResponseHeaderName.ETAG
    ResponseHeaderName.EXPIRES.name -> ResponseHeaderName.EXPIRES
    ResponseHeaderName.LAST_MODIFIED.name -> ResponseHeaderName.LAST_MODIFIED
    ResponseHeaderName.LOCATION.name -> ResponseHeaderName.LOCATION
    ResponseHeaderName.PROXY_AUTHENTICATE.name -> ResponseHeaderName.PROXY_AUTHENTICATE
    ResponseHeaderName.RETRY_AFTER.name -> ResponseHeaderName.RETRY_AFTER
    ResponseHeaderName.SERVER.name -> ResponseHeaderName.SERVER
    ResponseHeaderName.SET_COOKIE.name -> ResponseHeaderName.SET_COOKIE
    ResponseHeaderName.VARY.name -> ResponseHeaderName.VARY
    ResponseHeaderName.WARNING.name -> ResponseHeaderName.WARNING
    ResponseHeaderName.UPGRADE.name -> ResponseHeaderName.UPGRADE
    ResponseHeaderName.WWW_AUTHENTICATE.name -> ResponseHeaderName.WWW_AUTHENTICATE
    else -> ResponseHeaderName.Custom(this)
}

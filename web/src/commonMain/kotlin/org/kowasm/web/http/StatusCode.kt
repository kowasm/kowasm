package org.kowasm.web.http

/**
 * An HTTP response status code, as defined in the [RFC 7231](https://tools.ietf.org/html/rfc7231#section-6).
 *
 * @property code The status code.
 */
sealed class StatusCode(val code: Int) {

    /**
     * The status code for [`100 Continue`](https://www.rfc-editor.org/rfc/rfc7231#section-6.2.1).
     */
    object CONTINUE : StatusCode(100)

    /**
     * The status code for [`200 OK`](https://www.rfc-editor.org/rfc/rfc7231#section-6.3.1).
     */
    object OK : StatusCode(200)

    /**
     * The status code for [`201 Created`](https://www.rfc-editor.org/rfc/rfc7231#section-6.3.2).
     */
    object CREATED : StatusCode(201)

    /**
     * The status code for [`202 Accepted`](https://www.rfc-editor.org/rfc/rfc7231#section-6.3.3).
     */
    object ACCEPTED : StatusCode(202)

    /**
     * The status code for [`204 No Content`](https://www.rfc-editor.org/rfc/rfc7231#section-6.3.5).
     */
    object NO_CONTENT : StatusCode(204)

    /**
     * The status code for [`301 Moved Permanently`](https://www.rfc-editor.org/rfc/rfc7231#section-6.4.2).
     */
    object MOVED_PERMANENTLY : StatusCode(301)

    /**
     * The status code for [`302 Found`](https://www.rfc-editor.org/rfc/rfc7231#section-6.4.3).
     */
    object FOUND : StatusCode(302)

    /**
     * The status code for [`303 See Other`](https://www.rfc-editor.org/rfc/rfc7231#section-6.4.4).
     */
    object NOT_MODIFIED : StatusCode(304)

    /**
     * The status code for [`307 Temporary Redirect`](https://www.rfc-editor.org/rfc/rfc7231#section-6.4.7).
     */
    object TEMPORARY_REDIRECT : StatusCode(307)

    /**
     * The status code for [`308 Permanent Redirect`](https://www.rfc-editor.org/rfc/rfc7238#section-3).
     */
    object PERMANENT_REDIRECT : StatusCode(308)

    /**
     * The status code for [`400 Bad Request`](https://www.rfc-editor.org/rfc/rfc7231#section-6.5.1).
     */
    object BAD_REQUEST : StatusCode(400)

    /**
     * The status code for [`401 Unauthorized`](https://www.rfc-editor.org/rfc/rfc7235#section-3.1).
     */
    object UNAUTHORIZED : StatusCode(401)

    /**
     * The status code for [`403 Forbidden`](https://www.rfc-editor.org/rfc/rfc7231#section-6.5.3).
     */
    object FORBIDDEN : StatusCode(403)

    /**
     * The status code for [`404 Not Found`](https://www.rfc-editor.org/rfc/rfc7231#section-6.5.4).
     */
    object NOT_FOUND : StatusCode(404)

    /**
     * The status code for [`405 Method Not Allowed`](https://www.rfc-editor.org/rfc/rfc7231#section-6.5.5).
     */
    object METHOD_NOT_ALLOWED : StatusCode(405)

    /**
     * The status code for [`406 Not Acceptable`](https://www.rfc-editor.org/rfc/rfc7231#section-6.5.6).
     */
    object NOT_ACCEPTABLE : StatusCode(406)

    /**
     * The status code for [`500 Internal Server Error`](https://www.rfc-editor.org/rfc/rfc7231#section-6.6.1).
     */
    object INTERNAL_SERVER_ERROR : StatusCode(500)

    /**
     * The status code for [`501 Not Implemented`](https://www.rfc-editor.org/rfc/rfc7231#section-6.6.2).
     */
    object SERVICE_UNAVAILABLE : StatusCode(503)

    /**
     * A custom status code.
     *
     * @param code The status code.
     */
    class Custom(code: Int) : StatusCode(code)
}

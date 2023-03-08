package org.kowasm.web

/**
 * An HTTP request method, as defined in the [RFC 7231](https://www.rfc-editor.org/rfc/rfc7231#section-4).
 *
 * @property method The method name, e.g. "GET", "POST", etc.
 */
sealed class Method(val method: String) {

    /**
     * A [`GET` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.1).
     */
    object GET : Method("GET")

    /**
     * A [`HEAD` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.2).
     */
    object HEAD : Method("HEAD")

    /**
     * A [`POST` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.3).
     */
    object POST : Method("POST")

    /**
     * A `PUT` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.4).
     */
    object PUT : Method("PUT")

    /**
     * A [`DELETE` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.5).
     */
    object DELETE : Method("DELETE")

    /**
     * A [`CONNECT` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.6).
     */
    object CONNECT : Method("CONNECT")

    /**
     * A [`OPTIONS` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.7).
     */
    object OPTIONS : Method("OPTIONS")

    /**
     * A [`TRACE` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.8).
     */
    object TRACE : Method("TRACE")

    /**
     * A [`PATCH` method](https://www.rfc-editor.org/rfc/rfc5789#section-2).
     */
    object PATCH : Method("PATCH")

    /**
     * A custom method.
     *
     * @param method The method name.
     */
    class Other(method: String) : Method(method)
}

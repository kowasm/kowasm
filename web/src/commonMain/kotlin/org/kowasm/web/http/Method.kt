package org.kowasm.web.http

/**
 * An HTTP request method, as defined in the [RFC 7231](https://www.rfc-editor.org/rfc/rfc7231#section-4).
 *
 * @property name The method name, e.g. "GET", "POST", etc.
 */
sealed class Method(val name: String) {

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
     * @param name The method name.
     */
    class Custom(name: String) : Method(name)

}

/**
 * Create a [Method] from a [String].
 *
 * @receiver The name of the header.
 */
fun String.toMethod() = when (this) {
    Method.GET.name -> Method.GET
    Method.HEAD.name -> Method.HEAD
    Method.POST.name -> Method.POST
    Method.PUT.name -> Method.PUT
    Method.DELETE.name -> Method.DELETE
    Method.CONNECT.name -> Method.CONNECT
    Method.OPTIONS.name -> Method.OPTIONS
    Method.TRACE.name -> Method.TRACE
    Method.PATCH.name -> Method.PATCH
    else -> Method.Custom(this)
}

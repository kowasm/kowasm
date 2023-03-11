package org.kowasm.web.http

/**
 * An HTTP request method, as defined in the [RFC 7231](https://www.rfc-editor.org/rfc/rfc7231#section-4).
 *
 * @property name The method name, e.g. "GET", "POST", etc.
 */
sealed class Method(val name: String) {

    /**
     * The [`GET` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.1).
     */
    object GET : Method("GET")

    /**
     * The [`HEAD` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.2).
     */
    object HEAD : Method("HEAD")

    /**
     * The [`POST` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.3).
     */
    object POST : Method("POST")

    /**
     * The `PUT` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.4).
     */
    object PUT : Method("PUT")

    /**
     * The [`DELETE` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.5).
     */
    object DELETE : Method("DELETE")

    /**
     * The [`CONNECT` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.6).
     */
    object CONNECT : Method("CONNECT")

    /**
     * The [`OPTIONS` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.7).
     */
    object OPTIONS : Method("OPTIONS")

    /**
     * The [`TRACE` method](https://www.rfc-editor.org/rfc/rfc7231#section-4.3.8).
     */
    object TRACE : Method("TRACE")

    /**
     * The [`PATCH` method](https://www.rfc-editor.org/rfc/rfc5789#section-2).
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

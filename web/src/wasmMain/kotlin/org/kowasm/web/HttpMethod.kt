package org.kowasm.web

sealed class HttpMethod(val method: String) {
    object GET : HttpMethod("GET")
    object HEAD : HttpMethod("HEAD")
    object POST : HttpMethod("POST")
    object PUT : HttpMethod("PUT")
    object PATCH : HttpMethod("PATCH")
    object DELETE : HttpMethod("DELETE")
    object OPTIONS : HttpMethod("OPTIONS")
    object TRACE : HttpMethod("TRACE")
    class Other(method: String) : HttpMethod(method)
}

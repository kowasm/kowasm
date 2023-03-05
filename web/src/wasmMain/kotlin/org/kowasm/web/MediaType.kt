package org.kowasm.web

sealed class MediaType(val type: String, val subtype: String) {
    object TEXT_PLAIN : MediaType("text", "plain")
    object TEXT_HTML : MediaType("text", "html")
    object APPLICATION_JSON : MediaType("application", "json")
    object APPLICATION_XML : MediaType("application", "xml")

    override fun toString(): String {
        return "$type/$subtype"
    }
}
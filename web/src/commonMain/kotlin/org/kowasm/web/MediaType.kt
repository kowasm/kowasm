package org.kowasm.web

/**
 * An HTTP media type, as defined in the [RFC 7231](https://tools.ietf.org/html/rfc7231#section-3.1.1.1).
 *
 * @property type The type of the media type, e.g. "text", "application", etc.
 * @property subtype The subtype of the media type, e.g. "plain", "json", etc.
 */
sealed class MediaType(val type: String, val subtype: String) {

    /** A media type for plain text. */
    object TEXT_PLAIN : MediaType("text", "plain")

    /** A media type for HTML. */
    object TEXT_HTML : MediaType("text", "html")

    /** A media type for JSON. */
    object APPLICATION_JSON : MediaType("application", "json")

    /** A media type for XML. */
    object APPLICATION_XML : MediaType("application", "xml")

    /** Returns a media type for the given type and subtype, for example `text/plain`. */
    override fun toString(): String {
        return "$type/$subtype"
    }
}
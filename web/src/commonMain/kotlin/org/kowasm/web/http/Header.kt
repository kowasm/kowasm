package org.kowasm.web.http

/**
 * An HTTP header, as defined in the [RFC 7231](https://tools.ietf.org/html/rfc7231).
 */
sealed class Header(val name: String, val values: List<String>) {

    class Accept(values: List<String>) : Header(ACCEPT, values)
    class Age(values: List<String>) : Header(AGE, values)
    class Allow(values: List<String>) : Header(ALLOW, values)
    class Authorization(values: List<String>) : Header(AUTHORIZATION, values)
    class Connection(values: List<String>) : Header(CONNECTION, values)
    class Cookie(values: List<String>) : Header(COOKIE, values)
    class Date(values: List<String>) : Header(DATE, values)
    class Expect(values: List<String>) : Header(EXPECT, values)
    class Expires(values: List<String>) : Header(EXPIRES, values)
    class From(values: List<String>) : Header(FROM, values)
    class Host(values: List<String>) : Header(HOST, values)
    class Location(values: List<String>) : Header(LOCATION, values)
    class Origin(values: List<String>) : Header(ORIGIN, values)
    class Pragma(values: List<String>) : Header(PRAGMA, values)
    class Range(values: List<String>) : Header(RANGE, values)
    class Referer(values: List<String>) : Header(REFERER, values)
    class Upgrade(values: List<String>) : Header(UPGRADE, values)
    class Vary(values: List<String>) : Header(VARY, values)
    class Custom(name: String, values: List<String>) : Header(name, values)

    companion object {

        const val ACCEPT = "Accept"
        const val AGE = "Age"
        const val ALLOW = "Allow"
        const val AUTHORIZATION = "Authorization"
        const val CONNECTION = "Connection"
        const val COOKIE = "Cookie"
        const val DATE = "Date"
        const val EXPECT = "Expect"
        const val EXPIRES = "Expires"
        const val FROM = "From"
        const val HOST = "Host"
        const val LOCATION = "Location"
        const val ORIGIN = "Origin"
        const val PRAGMA = "Pragma"
        const val RANGE = "Range"
        const val REFERER = "Referer"
        const val UPGRADE = "Upgrade"
        const val VARY = "Vary"

        fun from(name: String, values: List<String>): Header = when (name) {
            "Accept" -> Accept(values)
            "Age" -> Age(values)
            "Allow" -> Allow(values)
            "Authorization" -> Authorization(values)
            "Connection" -> Connection(values)
            "Cookie" -> Cookie(values)
            "Date" -> Date(values)
            "Expect" -> Expect(values)
            "Expires" -> Expires(values)
            "From" -> From(values)
            "Host" -> Host(values)
            "Location" -> Location(values)
            "Origin" -> Origin(values)
            "Pragma" -> Pragma(values)
            "Range" -> Range(values)
            "Referer" -> Referer(values)
            "Upgrade" -> Upgrade(values)
            "Vary" -> Vary(values)
            else -> Custom(name, values)
        }
    }

    override fun toString(): String {
        return "$name: ${values.joinToString(", ")}"
    }
}
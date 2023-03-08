package org.kowasm.web

// TODO Use a MultiMap
class HttpHeaders : MutableMap<String, String> {

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
    }

    private val headers = mutableMapOf<String, String>()

    override val entries: MutableSet<MutableMap.MutableEntry<String, String>>
        get() = headers.entries
    override val keys: MutableSet<String>
        get() = headers.keys
    override val size: Int
        get() = headers.size
    override val values: MutableCollection<String>
        get() = headers.values

    override fun clear() {
        headers.clear()
    }

    override fun isEmpty(): Boolean {
        return headers.isEmpty()
    }

    override fun remove(key: String): String? {
        return headers.remove(key)
    }

    override fun putAll(from: Map<out String, String>) {
        headers.putAll(from)
    }

    override fun put(key: String, value: String): String? {
        return headers.put(key, value)
    }

    override fun get(key: String): String? {
        return headers[key]
    }

    override fun containsValue(value: String): Boolean {
        return headers.containsValue(value)
    }

    override fun containsKey(key: String): Boolean {
        return headers.containsKey(key)
    }
}

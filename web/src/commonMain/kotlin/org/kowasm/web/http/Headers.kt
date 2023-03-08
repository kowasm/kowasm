package org.kowasm.web.http

// TODO Replace with a multimap
class Headers(headers: List<Header>) : List<Header> by headers {

    operator fun get(name: String): Header? {
        return firstOrNull { it.name == name }
    }

    fun has(name: String): Boolean {
        return any { it.name == name }
    }
}
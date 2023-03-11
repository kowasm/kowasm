package org.kowasm.core.util

/**
 * Extension of the [Map] interface that stores multiple values.
 *
 * @param <K> the key type
 * @param <V> the value element type
 */
interface MultiMap<K, V> : Map<K, List<V>> {

    /**
     * Return the first value for the given key.
     * @param key the key
     * @return the first value for the specified key, or `null` if none
     */
    fun getFirst(key: K): V?

}

/**
 * Return a [MultiMap] containing the given [Map] entries.
 */
fun <K, V> Map<K, List<V>>.toMultiMap(): MultiMap<K, V> {
    return object : MultiMap<K, V>, Map<K, List<V>> by this {
        override fun getFirst(key: K): V? {
            val values: List<V> ?= this[key]
            return if (!values.isNullOrEmpty()) values[0] else null
        }
    }
}
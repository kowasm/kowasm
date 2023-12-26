package dev.scottpierce.html.writer

import kotlin.concurrent.Volatile

/**
 * Creates a [HtmlWriter], and handles it's lifecycle.
 *
 * A [HtmlWriter] should only be accessed inside of the given lambda, and shouldn't be saved for later.
 */
inline fun HtmlOutput.writer(func: HtmlWriter.() -> Unit): HtmlWriter {
    return HtmlWriter(this).apply {
        func()
        close()
    }
}

class HtmlWriter internal constructor(
    private val output: HtmlOutput,
    private var indent: Int,
    isEmpty: Boolean = true
) {
    constructor(
        output: HtmlOutput
    ) : this(output, 0)

    val options = output.options
    private val indentString: String? = if (options.indent.isEmpty()) null else options.indent
    private val newLineString: String? = if (options.newLine.isEmpty()) null else options.newLine

    private var currentOutput: HtmlOutput = output

    private var childOutputs: MutableList<StringHtmlOutput?>? = null
    private var isClosed = false

    private var childWriters: MutableMap<String, HtmlWriter>? = null
    private var states: MutableMap<String, Any>? = null

    var isEmpty: Boolean = isEmpty
        private set

    fun close() {
        if (isClosed) return
        isClosed = true

        childWriters?.forEach { it.value.close() }

        // Allow writers and outputs to be GC as they are written
        childWriters = null
        currentOutput = output

        childOutputs?.let { childOutputs ->
            for (i in childOutputs.indices) {
                val childOutput = childOutputs[i]!!
                output.write(childOutput.charSequence)
                childOutputs[i] = null // Free for GC
            }
        }
    }

    fun insertWriter(id: HtmlWriterId) {
        val childWriters = childWriters ?: HashMap<String, HtmlWriter>(8).also { childWriters = it }
        val childOutputs = childOutputs ?: ArrayList<StringHtmlOutput?>(8).also { childOutputs = it }

        val newWriter = HtmlWriter(output = currentOutput, indent = indent, isEmpty = false)
        val newOutput = StringHtmlOutput(options = options)
        currentOutput = newOutput
        childOutputs += newOutput
        val previous = childWriters.put(id, newWriter)

        check(previous == null) { "A writer with the name '$id' has already been inserted." }
    }

    fun writer(name: HtmlWriterId): HtmlWriter {
        return childWriters?.get(name)
            ?: throw IllegalArgumentException("Writer '$name' was retrieved before it was inserted.")
    }

    fun putState(key: String, state: Any?) {
        val states = states ?: HashMap<String, Any>().also { states = it }

        if (state == null) {
            removeState(key)
        } else {
            states[key] = state
        }
    }

    fun getState(key: String): Any? = states?.get(key)

    fun removeState(key: String): Any? = states?.remove(key)

    fun newLine(): HtmlWriter {
        if (newLineString != null) {
            write(newLineString)
        }

        if (indentString != null) {
            for (i in 1..indent) {
                write(indentString)
            }
        }

        return this
    }

    fun indent() {
        indent++
    }

    fun unindent() {
        indent--
    }

    fun write(c: Char): HtmlWriter {
        throwIfClosed()
        isEmpty = false
        currentOutput.write(c)
        return this
    }

    fun write(code: CharSequence): HtmlWriter {
        throwIfClosed()
        isEmpty = false
        currentOutput.write(code)
        return this
    }

    private fun throwIfClosed() {
        check(!isClosed) { "PageWriter is closed, and can no longer be used." }
    }
}

typealias HtmlWriterId = String

fun <T : HtmlWriterContext> T.insertWriter(id: HtmlWriterId) {
    writer.insertWriter(id)
}

inline fun HtmlWriter.getStateOrPut(key: String, defaultValue: () -> Any): Any {
    val value = getState(key)
    return if (value == null) {
        val answer = defaultValue()
        putState(key, answer)
        answer
    } else {
        value
    }
}

data class WriteOptions(
    val indent: String = "  ",
    val newLine: String = PlatformWriter.lineSeparator,
    val minifyStyles: Boolean = false
) {
    companion object {
        val readable = WriteOptions()
        val minified = WriteOptions(indent = "", newLine = "", minifyStyles = true)

        // TODO use atomicfu for Kotlin/native
        @Volatile
        var default = minified
    }
}

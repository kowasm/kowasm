// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.content(value: String, important: Boolean = false) {
    writeStyleProperty("content", value, important)
}

fun BaseStyleContext.content(value: Content, important: Boolean = false) {
    writeStyleProperty("content", value, important)
}

fun StyleContext.content(value: String, important: Boolean = false) {
    writeStyleProperty("content", value, important)
}

fun StyleContext.content(value: Content, important: Boolean = false) {
    writeStyleProperty("content", value, important)
}

fun InlineStyleContext.content(value: String, important: Boolean = false) {
    writeStyleProperty("content", value, important)
}

fun InlineStyleContext.content(value: Content, important: Boolean = false) {
    writeStyleProperty("content", value, important)
}

enum class Content(
    val value: String
) {
    NORMAL("normal"),

    NONE("none"),

    COUNTER("counter"),

    ATTR("attr"),

    OPEN_QUOTE("open-quote"),

    CLOSE_QUOTE("close-quote"),

    NO_OPEN_QUOTE("no-open-quote"),

    NO_CLOSE_QUOTE("no-close-quote"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

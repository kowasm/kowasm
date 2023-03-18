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

fun BaseStyleContext.top(value: Dimension, important: Boolean = false) {
    writeStyleProperty("top", value, important)
}

fun BaseStyleContext.top(value: Top, important: Boolean = false) {
    writeStyleProperty("top", value, important)
}

fun StyleContext.top(value: Dimension, important: Boolean = false) {
    writeStyleProperty("top", value, important)
}

fun StyleContext.top(value: Top, important: Boolean = false) {
    writeStyleProperty("top", value, important)
}

fun InlineStyleContext.top(value: Dimension, important: Boolean = false) {
    writeStyleProperty("top", value, important)
}

fun InlineStyleContext.top(value: Top, important: Boolean = false) {
    writeStyleProperty("top", value, important)
}

enum class Top(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

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

fun BaseStyleContext.maxHeight(value: Dimension, important: Boolean = false) {
    writeStyleProperty("max-height", value, important)
}

fun BaseStyleContext.maxHeight(value: MaxHeight, important: Boolean = false) {
    writeStyleProperty("max-height", value, important)
}

fun StyleContext.maxHeight(value: Dimension, important: Boolean = false) {
    writeStyleProperty("max-height", value, important)
}

fun StyleContext.maxHeight(value: MaxHeight, important: Boolean = false) {
    writeStyleProperty("max-height", value, important)
}

fun InlineStyleContext.maxHeight(value: Dimension, important: Boolean = false) {
    writeStyleProperty("max-height", value, important)
}

fun InlineStyleContext.maxHeight(value: MaxHeight, important: Boolean = false) {
    writeStyleProperty("max-height", value, important)
}

enum class MaxHeight(
    val value: String
) {
    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

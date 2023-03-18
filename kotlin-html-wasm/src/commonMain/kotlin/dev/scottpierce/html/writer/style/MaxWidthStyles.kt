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

fun BaseStyleContext.maxWidth(value: Dimension, important: Boolean = false) {
    writeStyleProperty("max-width", value, important)
}

fun BaseStyleContext.maxWidth(value: MaxWidth, important: Boolean = false) {
    writeStyleProperty("max-width", value, important)
}

fun StyleContext.maxWidth(value: Dimension, important: Boolean = false) {
    writeStyleProperty("max-width", value, important)
}

fun StyleContext.maxWidth(value: MaxWidth, important: Boolean = false) {
    writeStyleProperty("max-width", value, important)
}

fun InlineStyleContext.maxWidth(value: Dimension, important: Boolean = false) {
    writeStyleProperty("max-width", value, important)
}

fun InlineStyleContext.maxWidth(value: MaxWidth, important: Boolean = false) {
    writeStyleProperty("max-width", value, important)
}

enum class MaxWidth(
    val value: String
) {
    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

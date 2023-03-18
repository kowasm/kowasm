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

fun BaseStyleContext.bottom(value: Dimension, important: Boolean = false) {
    writeStyleProperty("bottom", value, important)
}

fun BaseStyleContext.bottom(value: Bottom, important: Boolean = false) {
    writeStyleProperty("bottom", value, important)
}

fun StyleContext.bottom(value: Dimension, important: Boolean = false) {
    writeStyleProperty("bottom", value, important)
}

fun StyleContext.bottom(value: Bottom, important: Boolean = false) {
    writeStyleProperty("bottom", value, important)
}

fun InlineStyleContext.bottom(value: Dimension, important: Boolean = false) {
    writeStyleProperty("bottom", value, important)
}

fun InlineStyleContext.bottom(value: Bottom, important: Boolean = false) {
    writeStyleProperty("bottom", value, important)
}

enum class Bottom(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

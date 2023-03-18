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

fun BaseStyleContext.height(value: Dimension, important: Boolean = false) {
    writeStyleProperty("height", value, important)
}

fun BaseStyleContext.height(value: Height, important: Boolean = false) {
    writeStyleProperty("height", value, important)
}

fun StyleContext.height(value: Dimension, important: Boolean = false) {
    writeStyleProperty("height", value, important)
}

fun StyleContext.height(value: Height, important: Boolean = false) {
    writeStyleProperty("height", value, important)
}

fun InlineStyleContext.height(value: Dimension, important: Boolean = false) {
    writeStyleProperty("height", value, important)
}

fun InlineStyleContext.height(value: Height, important: Boolean = false) {
    writeStyleProperty("height", value, important)
}

enum class Height(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

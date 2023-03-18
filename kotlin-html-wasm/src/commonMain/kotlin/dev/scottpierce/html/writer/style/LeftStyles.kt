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

fun BaseStyleContext.left(value: Dimension, important: Boolean = false) {
    writeStyleProperty("left", value, important)
}

fun BaseStyleContext.left(value: Left, important: Boolean = false) {
    writeStyleProperty("left", value, important)
}

fun StyleContext.left(value: Dimension, important: Boolean = false) {
    writeStyleProperty("left", value, important)
}

fun StyleContext.left(value: Left, important: Boolean = false) {
    writeStyleProperty("left", value, important)
}

fun InlineStyleContext.left(value: Dimension, important: Boolean = false) {
    writeStyleProperty("left", value, important)
}

fun InlineStyleContext.left(value: Left, important: Boolean = false) {
    writeStyleProperty("left", value, important)
}

enum class Left(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

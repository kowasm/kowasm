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

fun BaseStyleContext.right(value: Dimension, important: Boolean = false) {
    writeStyleProperty("right", value, important)
}

fun BaseStyleContext.right(value: Right, important: Boolean = false) {
    writeStyleProperty("right", value, important)
}

fun StyleContext.right(value: Dimension, important: Boolean = false) {
    writeStyleProperty("right", value, important)
}

fun StyleContext.right(value: Right, important: Boolean = false) {
    writeStyleProperty("right", value, important)
}

fun InlineStyleContext.right(value: Dimension, important: Boolean = false) {
    writeStyleProperty("right", value, important)
}

fun InlineStyleContext.right(value: Right, important: Boolean = false) {
    writeStyleProperty("right", value, important)
}

enum class Right(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

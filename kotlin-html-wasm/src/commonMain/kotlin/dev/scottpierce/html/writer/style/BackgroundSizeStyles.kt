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

fun BaseStyleContext.backgroundSize(value: Dimension, important: Boolean = false) {
    writeStyleProperty("background-size", value, important)
}

fun BaseStyleContext.backgroundSize(value: BackgroundSize, important: Boolean = false) {
    writeStyleProperty("background-size", value, important)
}

fun StyleContext.backgroundSize(value: Dimension, important: Boolean = false) {
    writeStyleProperty("background-size", value, important)
}

fun StyleContext.backgroundSize(value: BackgroundSize, important: Boolean = false) {
    writeStyleProperty("background-size", value, important)
}

fun InlineStyleContext.backgroundSize(value: Dimension, important: Boolean = false) {
    writeStyleProperty("background-size", value, important)
}

fun InlineStyleContext.backgroundSize(value: BackgroundSize, important: Boolean = false) {
    writeStyleProperty("background-size", value, important)
}

enum class BackgroundSize(
    val value: String
) {
    AUTO("auto"),

    COVER("cover"),

    CONTAIN("contain"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

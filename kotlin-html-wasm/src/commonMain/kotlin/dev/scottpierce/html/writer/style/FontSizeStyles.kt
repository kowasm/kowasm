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

fun BaseStyleContext.fontSize(value: Dimension, important: Boolean = false) {
    writeStyleProperty("font-size", value, important)
}

fun BaseStyleContext.fontSize(value: FontSize, important: Boolean = false) {
    writeStyleProperty("font-size", value, important)
}

fun StyleContext.fontSize(value: Dimension, important: Boolean = false) {
    writeStyleProperty("font-size", value, important)
}

fun StyleContext.fontSize(value: FontSize, important: Boolean = false) {
    writeStyleProperty("font-size", value, important)
}

fun InlineStyleContext.fontSize(value: Dimension, important: Boolean = false) {
    writeStyleProperty("font-size", value, important)
}

fun InlineStyleContext.fontSize(value: FontSize, important: Boolean = false) {
    writeStyleProperty("font-size", value, important)
}

enum class FontSize(
    val value: String
) {
    XX_SMALL("xx-small"),

    X_SMALL("x-small"),

    SMALLER("smaller"),

    SMALL("small"),

    LARGE("large"),

    LARGER("larger"),

    X_LARGE("x-large"),

    XX_LARGE("xx-large"),

    INHERIT("inherit"),

    INITIAL("initial");

    override fun toString() = value
}

// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.lineHeight(multiplier: Number, important: Boolean = false) {
    writeStyleProperty("line-height", multiplier, important)
}

fun BaseStyleContext.lineHeight(value: Dimension, important: Boolean = false) {
    writeStyleProperty("line-height", value, important)
}

fun BaseStyleContext.lineHeight(value: LineHeight, important: Boolean = false) {
    writeStyleProperty("line-height", value, important)
}

fun StyleContext.lineHeight(multiplier: Number, important: Boolean = false) {
    writeStyleProperty("line-height", multiplier, important)
}

fun StyleContext.lineHeight(value: Dimension, important: Boolean = false) {
    writeStyleProperty("line-height", value, important)
}

fun StyleContext.lineHeight(value: LineHeight, important: Boolean = false) {
    writeStyleProperty("line-height", value, important)
}

fun InlineStyleContext.lineHeight(multiplier: Number, important: Boolean = false) {
    writeStyleProperty("line-height", multiplier, important)
}

fun InlineStyleContext.lineHeight(value: Dimension, important: Boolean = false) {
    writeStyleProperty("line-height", value, important)
}

fun InlineStyleContext.lineHeight(value: LineHeight, important: Boolean = false) {
    writeStyleProperty("line-height", value, important)
}

enum class LineHeight(
    val value: String
) {
    NORMAL("normal"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

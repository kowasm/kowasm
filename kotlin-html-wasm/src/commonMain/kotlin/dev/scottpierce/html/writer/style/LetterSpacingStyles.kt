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

fun BaseStyleContext.letterSpacing(value: Dimension, important: Boolean = false) {
    writeStyleProperty("letter-spacing", value, important)
}

fun BaseStyleContext.letterSpacing(value: LetterSpacing, important: Boolean = false) {
    writeStyleProperty("letter-spacing", value, important)
}

fun StyleContext.letterSpacing(value: Dimension, important: Boolean = false) {
    writeStyleProperty("letter-spacing", value, important)
}

fun StyleContext.letterSpacing(value: LetterSpacing, important: Boolean = false) {
    writeStyleProperty("letter-spacing", value, important)
}

fun InlineStyleContext.letterSpacing(value: Dimension, important: Boolean = false) {
    writeStyleProperty("letter-spacing", value, important)
}

fun InlineStyleContext.letterSpacing(value: LetterSpacing, important: Boolean = false) {
    writeStyleProperty("letter-spacing", value, important)
}

enum class LetterSpacing(
    val value: String
) {
    NORMAL("normal"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

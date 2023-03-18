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

fun BaseStyleContext.textAlign(value: TextAlign, important: Boolean = false) {
    writeStyleProperty("text-align", value, important)
}

fun StyleContext.textAlign(value: TextAlign, important: Boolean = false) {
    writeStyleProperty("text-align", value, important)
}

fun InlineStyleContext.textAlign(value: TextAlign, important: Boolean = false) {
    writeStyleProperty("text-align", value, important)
}

enum class TextAlign(
    val value: String
) {
    LEFT("left"),

    RIGHT("right"),

    CENTER("center"),

    JUSTIFY("justify"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

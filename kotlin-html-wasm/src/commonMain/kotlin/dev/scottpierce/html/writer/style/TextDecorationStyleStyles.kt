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

fun BaseStyleContext.textDecorationStyle(value: TextDecorationStyle, important: Boolean = false) {
    writeStyleProperty("text-decoration-style", value, important)
}

fun StyleContext.textDecorationStyle(value: TextDecorationStyle, important: Boolean = false) {
    writeStyleProperty("text-decoration-style", value, important)
}

fun InlineStyleContext.textDecorationStyle(value: TextDecorationStyle, important: Boolean = false) {
    writeStyleProperty("text-decoration-style", value, important)
}

enum class TextDecorationStyle(
    val value: String
) {
    SOLID("solid"),

    DOUBLE("double"),

    DOTTED("dotted"),

    DASHED("dashed"),

    WAVY("wavy"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

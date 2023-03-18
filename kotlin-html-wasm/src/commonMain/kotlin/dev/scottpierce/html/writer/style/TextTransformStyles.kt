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

fun BaseStyleContext.textTransform(value: TextTransform, important: Boolean = false) {
    writeStyleProperty("text-transform", value, important)
}

fun StyleContext.textTransform(value: TextTransform, important: Boolean = false) {
    writeStyleProperty("text-transform", value, important)
}

fun InlineStyleContext.textTransform(value: TextTransform, important: Boolean = false) {
    writeStyleProperty("text-transform", value, important)
}

enum class TextTransform(
    val value: String
) {
    NONE("none"),

    CAPITALIZE("capitalize"),

    UPPERCASE("uppercase"),

    LOWERCASE("lowercase"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

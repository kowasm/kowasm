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

fun BaseStyleContext.borderWidth(value: Dimension, important: Boolean = false) {
    writeStyleProperty("border-width", value, important)
}

fun BaseStyleContext.borderWidth(value: BorderWidth, important: Boolean = false) {
    writeStyleProperty("border-width", value, important)
}

fun StyleContext.borderWidth(value: Dimension, important: Boolean = false) {
    writeStyleProperty("border-width", value, important)
}

fun StyleContext.borderWidth(value: BorderWidth, important: Boolean = false) {
    writeStyleProperty("border-width", value, important)
}

fun InlineStyleContext.borderWidth(value: Dimension, important: Boolean = false) {
    writeStyleProperty("border-width", value, important)
}

fun InlineStyleContext.borderWidth(value: BorderWidth, important: Boolean = false) {
    writeStyleProperty("border-width", value, important)
}

enum class BorderWidth(
    val value: String
) {
    MEDIUM("medium"),

    THIN("thin"),

    THICK("thick"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

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

fun BaseStyleContext.border(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border", """$width $style $color""", important)
}

fun BaseStyleContext.border(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border", """$width $style $color""", important)
}

fun BaseStyleContext.border(value: Border, important: Boolean = false) {
    writeStyleProperty("border", value, important)
}

fun StyleContext.border(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border", """$width $style $color""", important)
}

fun StyleContext.border(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border", """$width $style $color""", important)
}

fun StyleContext.border(value: Border, important: Boolean = false) {
    writeStyleProperty("border", value, important)
}

fun InlineStyleContext.border(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border", """$width $style $color""", important)
}

fun InlineStyleContext.border(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border", """$width $style $color""", important)
}

fun InlineStyleContext.border(value: Border, important: Boolean = false) {
    writeStyleProperty("border", value, important)
}

enum class Border(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit"),

    NONE("none");

    override fun toString() = value
}

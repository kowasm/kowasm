// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.borderLeft(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-left", """$width $style $color""", important)
}

fun BaseStyleContext.borderLeft(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-left", """$width $style $color""", important)
}

fun BaseStyleContext.borderLeft(value: Border, important: Boolean = false) {
    writeStyleProperty("border-left", value, important)
}

fun StyleContext.borderLeft(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-left", """$width $style $color""", important)
}

fun StyleContext.borderLeft(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-left", """$width $style $color""", important)
}

fun StyleContext.borderLeft(value: Border, important: Boolean = false) {
    writeStyleProperty("border-left", value, important)
}

fun InlineStyleContext.borderLeft(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-left", """$width $style $color""", important)
}

fun InlineStyleContext.borderLeft(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-left", """$width $style $color""", important)
}

fun InlineStyleContext.borderLeft(value: Border, important: Boolean = false) {
    writeStyleProperty("border-left", value, important)
}

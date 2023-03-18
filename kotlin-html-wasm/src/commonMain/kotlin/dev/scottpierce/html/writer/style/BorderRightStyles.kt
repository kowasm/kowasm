// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.borderRight(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-right", """$width $style $color""", important)
}

fun BaseStyleContext.borderRight(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-right", """$width $style $color""", important)
}

fun BaseStyleContext.borderRight(value: Border, important: Boolean = false) {
    writeStyleProperty("border-right", value, important)
}

fun StyleContext.borderRight(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-right", """$width $style $color""", important)
}

fun StyleContext.borderRight(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-right", """$width $style $color""", important)
}

fun StyleContext.borderRight(value: Border, important: Boolean = false) {
    writeStyleProperty("border-right", value, important)
}

fun InlineStyleContext.borderRight(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-right", """$width $style $color""", important)
}

fun InlineStyleContext.borderRight(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-right", """$width $style $color""", important)
}

fun InlineStyleContext.borderRight(value: Border, important: Boolean = false) {
    writeStyleProperty("border-right", value, important)
}

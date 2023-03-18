// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.borderBottom(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom", """$width $style $color""", important)
}

fun BaseStyleContext.borderBottom(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom", """$width $style $color""", important)
}

fun BaseStyleContext.borderBottom(value: Border, important: Boolean = false) {
    writeStyleProperty("border-bottom", value, important)
}

fun StyleContext.borderBottom(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom", """$width $style $color""", important)
}

fun StyleContext.borderBottom(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom", """$width $style $color""", important)
}

fun StyleContext.borderBottom(value: Border, important: Boolean = false) {
    writeStyleProperty("border-bottom", value, important)
}

fun InlineStyleContext.borderBottom(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom", """$width $style $color""", important)
}

fun InlineStyleContext.borderBottom(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom", """$width $style $color""", important)
}

fun InlineStyleContext.borderBottom(value: Border, important: Boolean = false) {
    writeStyleProperty("border-bottom", value, important)
}

// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.borderTop(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-top", """$width $style $color""", important)
}

fun BaseStyleContext.borderTop(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-top", """$width $style $color""", important)
}

fun BaseStyleContext.borderTop(value: Border, important: Boolean = false) {
    writeStyleProperty("border-top", value, important)
}

fun StyleContext.borderTop(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-top", """$width $style $color""", important)
}

fun StyleContext.borderTop(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-top", """$width $style $color""", important)
}

fun StyleContext.borderTop(value: Border, important: Boolean = false) {
    writeStyleProperty("border-top", value, important)
}

fun InlineStyleContext.borderTop(
    width: Dimension,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-top", """$width $style $color""", important)
}

fun InlineStyleContext.borderTop(
    width: BorderWidth,
    style: BorderStyle,
    color: Color,
    important: Boolean = false
) {
    writeStyleProperty("border-top", """$width $style $color""", important)
}

fun InlineStyleContext.borderTop(value: Border, important: Boolean = false) {
    writeStyleProperty("border-top", value, important)
}

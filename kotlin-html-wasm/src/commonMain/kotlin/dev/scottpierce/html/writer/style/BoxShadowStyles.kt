// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.boxShadow(boxShadow: BoxShadow, important: Boolean = false) {
    writeStyleProperty("box-shadow", boxShadow, important)
}

fun BaseStyleContext.boxShadow(vararg boxShadows: BoxShadow, important: Boolean = false) {
    writeStyleProperty("box-shadow", boxShadows.joinToString(), important)
}

fun BaseStyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    color: Color,
    inset: Boolean = false,
    important: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color,
            inset = inset), important)
}

fun BaseStyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    blur: Dimension,
    spread: Dimension? = null,
    color: Color,
    inset: Boolean = false,
    important: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, blur = blur,
            spread = spread, color = color, inset = inset), important)
}

fun StyleContext.boxShadow(boxShadow: BoxShadow, important: Boolean = false) {
    writeStyleProperty("box-shadow", boxShadow, important)
}

fun StyleContext.boxShadow(vararg boxShadows: BoxShadow, important: Boolean = false) {
    writeStyleProperty("box-shadow", boxShadows.joinToString(), important)
}

fun StyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    color: Color,
    inset: Boolean = false,
    important: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color,
            inset = inset), important)
}

fun StyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    blur: Dimension,
    spread: Dimension? = null,
    color: Color,
    inset: Boolean = false,
    important: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, blur = blur,
            spread = spread, color = color, inset = inset), important)
}

fun InlineStyleContext.boxShadow(boxShadow: BoxShadow, important: Boolean = false) {
    writeStyleProperty("box-shadow", boxShadow, important)
}

fun InlineStyleContext.boxShadow(vararg boxShadows: BoxShadow, important: Boolean = false) {
    writeStyleProperty("box-shadow", boxShadows.joinToString(), important)
}

fun InlineStyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    color: Color,
    inset: Boolean = false,
    important: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, color = color,
            inset = inset), important)
}

fun InlineStyleContext.boxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    blur: Dimension,
    spread: Dimension? = null,
    color: Color,
    inset: Boolean = false,
    important: Boolean = false
) {
    writeStyleProperty("box-shadow", BoxShadow(hOffset = hOffset, vOffset = vOffset, blur = blur,
            spread = spread, color = color, inset = inset), important)
}

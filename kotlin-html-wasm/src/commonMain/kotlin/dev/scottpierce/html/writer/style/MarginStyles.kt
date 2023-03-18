// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.margin(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin", value, important)
}

fun BaseStyleContext.margin(
    y: Dimension,
    x: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("margin", """$y $x""", important)
}

fun BaseStyleContext.margin(
    top: Dimension,
    x: Dimension,
    bottom: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("margin", """$top $x $bottom""", important)
}

fun BaseStyleContext.margin(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("margin", """$top $right $bottom $left""", important)
}

fun BaseStyleContext.margin(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin", value, important)
}

fun StyleContext.margin(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin", value, important)
}

fun StyleContext.margin(
    y: Dimension,
    x: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("margin", """$y $x""", important)
}

fun StyleContext.margin(
    top: Dimension,
    x: Dimension,
    bottom: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("margin", """$top $x $bottom""", important)
}

fun StyleContext.margin(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("margin", """$top $right $bottom $left""", important)
}

fun StyleContext.margin(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin", value, important)
}

fun InlineStyleContext.margin(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin", value, important)
}

fun InlineStyleContext.margin(
    y: Dimension,
    x: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("margin", """$y $x""", important)
}

fun InlineStyleContext.margin(
    top: Dimension,
    x: Dimension,
    bottom: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("margin", """$top $x $bottom""", important)
}

fun InlineStyleContext.margin(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("margin", """$top $right $bottom $left""", important)
}

fun InlineStyleContext.margin(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin", value, important)
}

// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.padding(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding", value, important)
}

fun BaseStyleContext.padding(
    y: Dimension,
    x: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("padding", """$y $x""", important)
}

fun BaseStyleContext.padding(
    top: Dimension,
    x: Dimension,
    bottom: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("padding", """$top $x $bottom""", important)
}

fun BaseStyleContext.padding(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("padding", """$top $right $bottom $left""", important)
}

fun BaseStyleContext.padding(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding", value, important)
}

fun StyleContext.padding(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding", value, important)
}

fun StyleContext.padding(
    y: Dimension,
    x: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("padding", """$y $x""", important)
}

fun StyleContext.padding(
    top: Dimension,
    x: Dimension,
    bottom: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("padding", """$top $x $bottom""", important)
}

fun StyleContext.padding(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("padding", """$top $right $bottom $left""", important)
}

fun StyleContext.padding(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding", value, important)
}

fun InlineStyleContext.padding(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding", value, important)
}

fun InlineStyleContext.padding(
    y: Dimension,
    x: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("padding", """$y $x""", important)
}

fun InlineStyleContext.padding(
    top: Dimension,
    x: Dimension,
    bottom: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("padding", """$top $x $bottom""", important)
}

fun InlineStyleContext.padding(
    top: Dimension,
    right: Dimension,
    bottom: Dimension,
    left: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("padding", """$top $right $bottom $left""", important)
}

fun InlineStyleContext.padding(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding", value, important)
}

// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Int
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.outlineColor(color: Color, important: Boolean = false) {
    writeStyleProperty("outline-color", color, important)
}

fun BaseStyleContext.outlineColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("outline-color", Color(hexString), important)
}

fun BaseStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("outline-color", Color(r, g, b), important)
}

fun BaseStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("outline-color", Color(r, g, b, a), important)
}

fun StyleContext.outlineColor(color: Color, important: Boolean = false) {
    writeStyleProperty("outline-color", color, important)
}

fun StyleContext.outlineColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("outline-color", Color(hexString), important)
}

fun StyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("outline-color", Color(r, g, b), important)
}

fun StyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("outline-color", Color(r, g, b, a), important)
}

fun InlineStyleContext.outlineColor(color: Color, important: Boolean = false) {
    writeStyleProperty("outline-color", color, important)
}

fun InlineStyleContext.outlineColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("outline-color", Color(hexString), important)
}

fun InlineStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("outline-color", Color(r, g, b), important)
}

fun InlineStyleContext.outlineColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("outline-color", Color(r, g, b, a), important)
}

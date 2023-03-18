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

fun BaseStyleContext.borderLeftColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-left-color", color, important)
}

fun BaseStyleContext.borderLeftColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-left-color", Color(hexString), important)
}

fun BaseStyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-left-color", Color(r, g, b), important)
}

fun BaseStyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-left-color", Color(r, g, b, a), important)
}

fun StyleContext.borderLeftColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-left-color", color, important)
}

fun StyleContext.borderLeftColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-left-color", Color(hexString), important)
}

fun StyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-left-color", Color(r, g, b), important)
}

fun StyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-left-color", Color(r, g, b, a), important)
}

fun InlineStyleContext.borderLeftColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-left-color", color, important)
}

fun InlineStyleContext.borderLeftColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-left-color", Color(hexString), important)
}

fun InlineStyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-left-color", Color(r, g, b), important)
}

fun InlineStyleContext.borderLeftColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-left-color", Color(r, g, b, a), important)
}

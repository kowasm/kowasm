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

fun BaseStyleContext.borderTopColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-top-color", color, important)
}

fun BaseStyleContext.borderTopColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-top-color", Color(hexString), important)
}

fun BaseStyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-top-color", Color(r, g, b), important)
}

fun BaseStyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-top-color", Color(r, g, b, a), important)
}

fun StyleContext.borderTopColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-top-color", color, important)
}

fun StyleContext.borderTopColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-top-color", Color(hexString), important)
}

fun StyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-top-color", Color(r, g, b), important)
}

fun StyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-top-color", Color(r, g, b, a), important)
}

fun InlineStyleContext.borderTopColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-top-color", color, important)
}

fun InlineStyleContext.borderTopColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-top-color", Color(hexString), important)
}

fun InlineStyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-top-color", Color(r, g, b), important)
}

fun InlineStyleContext.borderTopColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-top-color", Color(r, g, b, a), important)
}

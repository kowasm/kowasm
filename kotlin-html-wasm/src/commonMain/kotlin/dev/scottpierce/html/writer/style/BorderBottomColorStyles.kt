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

fun BaseStyleContext.borderBottomColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-bottom-color", color, important)
}

fun BaseStyleContext.borderBottomColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-bottom-color", Color(hexString), important)
}

fun BaseStyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b), important)
}

fun BaseStyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b, a), important)
}

fun StyleContext.borderBottomColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-bottom-color", color, important)
}

fun StyleContext.borderBottomColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-bottom-color", Color(hexString), important)
}

fun StyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b), important)
}

fun StyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b, a), important)
}

fun InlineStyleContext.borderBottomColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-bottom-color", color, important)
}

fun InlineStyleContext.borderBottomColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-bottom-color", Color(hexString), important)
}

fun InlineStyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b), important)
}

fun InlineStyleContext.borderBottomColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-bottom-color", Color(r, g, b, a), important)
}

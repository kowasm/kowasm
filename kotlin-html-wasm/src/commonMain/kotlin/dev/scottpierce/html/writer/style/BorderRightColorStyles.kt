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

fun BaseStyleContext.borderRightColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-right-color", color, important)
}

fun BaseStyleContext.borderRightColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-right-color", Color(hexString), important)
}

fun BaseStyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-right-color", Color(r, g, b), important)
}

fun BaseStyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-right-color", Color(r, g, b, a), important)
}

fun StyleContext.borderRightColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-right-color", color, important)
}

fun StyleContext.borderRightColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-right-color", Color(hexString), important)
}

fun StyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-right-color", Color(r, g, b), important)
}

fun StyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-right-color", Color(r, g, b, a), important)
}

fun InlineStyleContext.borderRightColor(color: Color, important: Boolean = false) {
    writeStyleProperty("border-right-color", color, important)
}

fun InlineStyleContext.borderRightColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("border-right-color", Color(hexString), important)
}

fun InlineStyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("border-right-color", Color(r, g, b), important)
}

fun InlineStyleContext.borderRightColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("border-right-color", Color(r, g, b, a), important)
}

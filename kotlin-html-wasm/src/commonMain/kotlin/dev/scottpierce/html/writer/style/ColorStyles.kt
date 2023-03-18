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

fun BaseStyleContext.color(color: Color, important: Boolean = false) {
    writeStyleProperty("color", color, important)
}

fun BaseStyleContext.color(hexString: String, important: Boolean = false) {
    writeStyleProperty("color", Color(hexString), important)
}

fun BaseStyleContext.color(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("color", Color(r, g, b), important)
}

fun BaseStyleContext.color(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("color", Color(r, g, b, a), important)
}

fun StyleContext.color(color: Color, important: Boolean = false) {
    writeStyleProperty("color", color, important)
}

fun StyleContext.color(hexString: String, important: Boolean = false) {
    writeStyleProperty("color", Color(hexString), important)
}

fun StyleContext.color(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("color", Color(r, g, b), important)
}

fun StyleContext.color(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("color", Color(r, g, b, a), important)
}

fun InlineStyleContext.color(color: Color, important: Boolean = false) {
    writeStyleProperty("color", color, important)
}

fun InlineStyleContext.color(hexString: String, important: Boolean = false) {
    writeStyleProperty("color", Color(hexString), important)
}

fun InlineStyleContext.color(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("color", Color(r, g, b), important)
}

fun InlineStyleContext.color(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("color", Color(r, g, b, a), important)
}

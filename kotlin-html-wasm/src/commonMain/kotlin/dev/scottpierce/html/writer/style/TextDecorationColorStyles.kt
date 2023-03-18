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

fun BaseStyleContext.textDecorationColor(color: Color, important: Boolean = false) {
    writeStyleProperty("text-decoration-color", color, important)
}

fun BaseStyleContext.textDecorationColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("text-decoration-color", Color(hexString), important)
}

fun BaseStyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b), important)
}

fun BaseStyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b, a), important)
}

fun StyleContext.textDecorationColor(color: Color, important: Boolean = false) {
    writeStyleProperty("text-decoration-color", color, important)
}

fun StyleContext.textDecorationColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("text-decoration-color", Color(hexString), important)
}

fun StyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b), important)
}

fun StyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b, a), important)
}

fun InlineStyleContext.textDecorationColor(color: Color, important: Boolean = false) {
    writeStyleProperty("text-decoration-color", color, important)
}

fun InlineStyleContext.textDecorationColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("text-decoration-color", Color(hexString), important)
}

fun InlineStyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b), important)
}

fun InlineStyleContext.textDecorationColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("text-decoration-color", Color(r, g, b, a), important)
}

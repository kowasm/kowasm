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

fun BaseStyleContext.backgroundColor(color: Color, important: Boolean = false) {
    writeStyleProperty("background-color", color, important)
}

fun BaseStyleContext.backgroundColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("background-color", Color(hexString), important)
}

fun BaseStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("background-color", Color(r, g, b), important)
}

fun BaseStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("background-color", Color(r, g, b, a), important)
}

fun StyleContext.backgroundColor(color: Color, important: Boolean = false) {
    writeStyleProperty("background-color", color, important)
}

fun StyleContext.backgroundColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("background-color", Color(hexString), important)
}

fun StyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("background-color", Color(r, g, b), important)
}

fun StyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("background-color", Color(r, g, b, a), important)
}

fun InlineStyleContext.backgroundColor(color: Color, important: Boolean = false) {
    writeStyleProperty("background-color", color, important)
}

fun InlineStyleContext.backgroundColor(hexString: String, important: Boolean = false) {
    writeStyleProperty("background-color", Color(hexString), important)
}

fun InlineStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("background-color", Color(r, g, b), important)
}

fun InlineStyleContext.backgroundColor(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("background-color", Color(r, g, b, a), important)
}

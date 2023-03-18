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

fun BaseStyleContext.fill(color: Color, important: Boolean = false) {
    writeStyleProperty("fill", color, important)
}

fun BaseStyleContext.fill(hexString: String, important: Boolean = false) {
    writeStyleProperty("fill", Color(hexString), important)
}

fun BaseStyleContext.fill(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("fill", Color(r, g, b), important)
}

fun BaseStyleContext.fill(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("fill", Color(r, g, b, a), important)
}

fun StyleContext.fill(color: Color, important: Boolean = false) {
    writeStyleProperty("fill", color, important)
}

fun StyleContext.fill(hexString: String, important: Boolean = false) {
    writeStyleProperty("fill", Color(hexString), important)
}

fun StyleContext.fill(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("fill", Color(r, g, b), important)
}

fun StyleContext.fill(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("fill", Color(r, g, b, a), important)
}

fun InlineStyleContext.fill(color: Color, important: Boolean = false) {
    writeStyleProperty("fill", color, important)
}

fun InlineStyleContext.fill(hexString: String, important: Boolean = false) {
    writeStyleProperty("fill", Color(hexString), important)
}

fun InlineStyleContext.fill(
    r: Int,
    g: Int,
    b: Int,
    important: Boolean = false
) {
    writeStyleProperty("fill", Color(r, g, b), important)
}

fun InlineStyleContext.fill(
    r: Int,
    g: Int,
    b: Int,
    a: Number,
    important: Boolean = false
) {
    writeStyleProperty("fill", Color(r, g, b, a), important)
}

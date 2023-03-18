// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.background(color: Color, important: Boolean = false) {
    writeStyleProperty("background", color, important)
}

fun BaseStyleContext.background(
    color: Color,
    image: BackgroundImage,
    important: Boolean = false
) {
    writeStyleProperty("background", """$color $image""", important)
}

fun BaseStyleContext.background(color: String, important: Boolean = false) {
    writeStyleProperty("background", color, important)
}

fun StyleContext.background(color: Color, important: Boolean = false) {
    writeStyleProperty("background", color, important)
}

fun StyleContext.background(
    color: Color,
    image: BackgroundImage,
    important: Boolean = false
) {
    writeStyleProperty("background", """$color $image""", important)
}

fun StyleContext.background(color: String, important: Boolean = false) {
    writeStyleProperty("background", color, important)
}

fun InlineStyleContext.background(color: Color, important: Boolean = false) {
    writeStyleProperty("background", color, important)
}

fun InlineStyleContext.background(
    color: Color,
    image: BackgroundImage,
    important: Boolean = false
) {
    writeStyleProperty("background", """$color $image""", important)
}

fun InlineStyleContext.background(color: String, important: Boolean = false) {
    writeStyleProperty("background", color, important)
}

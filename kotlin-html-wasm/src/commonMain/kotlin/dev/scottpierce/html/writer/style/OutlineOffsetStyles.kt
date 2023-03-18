// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.outlineOffset(value: Dimension, important: Boolean = false) {
    writeStyleProperty("outline-offset", value, important)
}

fun BaseStyleContext.outlineOffset(value: CssValue, important: Boolean = false) {
    writeStyleProperty("outline-offset", value, important)
}

fun StyleContext.outlineOffset(value: Dimension, important: Boolean = false) {
    writeStyleProperty("outline-offset", value, important)
}

fun StyleContext.outlineOffset(value: CssValue, important: Boolean = false) {
    writeStyleProperty("outline-offset", value, important)
}

fun InlineStyleContext.outlineOffset(value: Dimension, important: Boolean = false) {
    writeStyleProperty("outline-offset", value, important)
}

fun InlineStyleContext.outlineOffset(value: CssValue, important: Boolean = false) {
    writeStyleProperty("outline-offset", value, important)
}

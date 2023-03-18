// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.marginLeft(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-left", value, important)
}

fun BaseStyleContext.marginLeft(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-left", value, important)
}

fun StyleContext.marginLeft(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-left", value, important)
}

fun StyleContext.marginLeft(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-left", value, important)
}

fun InlineStyleContext.marginLeft(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-left", value, important)
}

fun InlineStyleContext.marginLeft(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-left", value, important)
}

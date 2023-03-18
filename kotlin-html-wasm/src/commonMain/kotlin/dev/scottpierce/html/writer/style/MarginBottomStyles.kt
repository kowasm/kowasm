// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.marginBottom(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-bottom", value, important)
}

fun BaseStyleContext.marginBottom(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-bottom", value, important)
}

fun StyleContext.marginBottom(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-bottom", value, important)
}

fun StyleContext.marginBottom(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-bottom", value, important)
}

fun InlineStyleContext.marginBottom(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-bottom", value, important)
}

fun InlineStyleContext.marginBottom(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-bottom", value, important)
}

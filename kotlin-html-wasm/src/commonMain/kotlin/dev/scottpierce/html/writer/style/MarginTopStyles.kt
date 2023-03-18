// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.marginTop(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-top", value, important)
}

fun BaseStyleContext.marginTop(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-top", value, important)
}

fun StyleContext.marginTop(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-top", value, important)
}

fun StyleContext.marginTop(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-top", value, important)
}

fun InlineStyleContext.marginTop(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-top", value, important)
}

fun InlineStyleContext.marginTop(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-top", value, important)
}

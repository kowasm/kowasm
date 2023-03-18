// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.marginRight(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-right", value, important)
}

fun BaseStyleContext.marginRight(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-right", value, important)
}

fun StyleContext.marginRight(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-right", value, important)
}

fun StyleContext.marginRight(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-right", value, important)
}

fun InlineStyleContext.marginRight(value: Dimension, important: Boolean = false) {
    writeStyleProperty("margin-right", value, important)
}

fun InlineStyleContext.marginRight(value: CssValue, important: Boolean = false) {
    writeStyleProperty("margin-right", value, important)
}

// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.paddingLeft(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding-left", value, important)
}

fun BaseStyleContext.paddingLeft(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding-left", value, important)
}

fun StyleContext.paddingLeft(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding-left", value, important)
}

fun StyleContext.paddingLeft(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding-left", value, important)
}

fun InlineStyleContext.paddingLeft(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding-left", value, important)
}

fun InlineStyleContext.paddingLeft(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding-left", value, important)
}

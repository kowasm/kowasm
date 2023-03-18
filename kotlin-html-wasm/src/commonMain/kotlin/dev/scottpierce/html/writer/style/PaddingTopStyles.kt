// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.paddingTop(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding-top", value, important)
}

fun BaseStyleContext.paddingTop(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding-top", value, important)
}

fun StyleContext.paddingTop(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding-top", value, important)
}

fun StyleContext.paddingTop(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding-top", value, important)
}

fun InlineStyleContext.paddingTop(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding-top", value, important)
}

fun InlineStyleContext.paddingTop(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding-top", value, important)
}

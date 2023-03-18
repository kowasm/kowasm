// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.paddingBottom(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding-bottom", value, important)
}

fun BaseStyleContext.paddingBottom(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding-bottom", value, important)
}

fun StyleContext.paddingBottom(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding-bottom", value, important)
}

fun StyleContext.paddingBottom(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding-bottom", value, important)
}

fun InlineStyleContext.paddingBottom(value: Dimension, important: Boolean = false) {
    writeStyleProperty("padding-bottom", value, important)
}

fun InlineStyleContext.paddingBottom(value: CssValue, important: Boolean = false) {
    writeStyleProperty("padding-bottom", value, important)
}

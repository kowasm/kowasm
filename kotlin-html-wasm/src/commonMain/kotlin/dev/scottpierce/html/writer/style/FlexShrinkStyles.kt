// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Number
import kotlin.Suppress

fun BaseStyleContext.flexShrink(value: Number, important: Boolean = false) {
    writeStyleProperty("flex-shrink", value, important)
}

fun BaseStyleContext.flexShrink(value: CssValue, important: Boolean = false) {
    writeStyleProperty("flex-shrink", value, important)
}

fun StyleContext.flexShrink(value: Number, important: Boolean = false) {
    writeStyleProperty("flex-shrink", value, important)
}

fun StyleContext.flexShrink(value: CssValue, important: Boolean = false) {
    writeStyleProperty("flex-shrink", value, important)
}

fun InlineStyleContext.flexShrink(value: Number, important: Boolean = false) {
    writeStyleProperty("flex-shrink", value, important)
}

fun InlineStyleContext.flexShrink(value: CssValue, important: Boolean = false) {
    writeStyleProperty("flex-shrink", value, important)
}

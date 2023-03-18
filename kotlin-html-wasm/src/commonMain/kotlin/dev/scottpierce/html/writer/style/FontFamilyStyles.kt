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

fun BaseStyleContext.fontFamily(value: String, important: Boolean = false) {
    writeStyleProperty("font-family", value, important)
}

fun BaseStyleContext.fontFamily(value: CssValue, important: Boolean = false) {
    writeStyleProperty("font-family", value, important)
}

fun StyleContext.fontFamily(value: String, important: Boolean = false) {
    writeStyleProperty("font-family", value, important)
}

fun StyleContext.fontFamily(value: CssValue, important: Boolean = false) {
    writeStyleProperty("font-family", value, important)
}

fun InlineStyleContext.fontFamily(value: String, important: Boolean = false) {
    writeStyleProperty("font-family", value, important)
}

fun InlineStyleContext.fontFamily(value: CssValue, important: Boolean = false) {
    writeStyleProperty("font-family", value, important)
}

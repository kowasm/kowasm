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

fun BaseStyleContext.flexGrow(value: Number, important: Boolean = false) {
    writeStyleProperty("flex-grow", value, important)
}

fun BaseStyleContext.flexGrow(value: CssValue, important: Boolean = false) {
    writeStyleProperty("flex-grow", value, important)
}

fun StyleContext.flexGrow(value: Number, important: Boolean = false) {
    writeStyleProperty("flex-grow", value, important)
}

fun StyleContext.flexGrow(value: CssValue, important: Boolean = false) {
    writeStyleProperty("flex-grow", value, important)
}

fun InlineStyleContext.flexGrow(value: Number, important: Boolean = false) {
    writeStyleProperty("flex-grow", value, important)
}

fun InlineStyleContext.flexGrow(value: CssValue, important: Boolean = false) {
    writeStyleProperty("flex-grow", value, important)
}

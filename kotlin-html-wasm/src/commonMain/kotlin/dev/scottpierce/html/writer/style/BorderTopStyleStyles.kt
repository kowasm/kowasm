// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.borderTopStyle(value: BorderStyle, important: Boolean = false) {
    writeStyleProperty("border-top-style", value, important)
}

fun StyleContext.borderTopStyle(value: BorderStyle, important: Boolean = false) {
    writeStyleProperty("border-top-style", value, important)
}

fun InlineStyleContext.borderTopStyle(value: BorderStyle, important: Boolean = false) {
    writeStyleProperty("border-top-style", value, important)
}

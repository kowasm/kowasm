// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.overflowY(value: Dimension, important: Boolean = false) {
    writeStyleProperty("overflow-y", value, important)
}

fun BaseStyleContext.overflowY(value: Overflow, important: Boolean = false) {
    writeStyleProperty("overflow-y", value, important)
}

fun StyleContext.overflowY(value: Dimension, important: Boolean = false) {
    writeStyleProperty("overflow-y", value, important)
}

fun StyleContext.overflowY(value: Overflow, important: Boolean = false) {
    writeStyleProperty("overflow-y", value, important)
}

fun InlineStyleContext.overflowY(value: Dimension, important: Boolean = false) {
    writeStyleProperty("overflow-y", value, important)
}

fun InlineStyleContext.overflowY(value: Overflow, important: Boolean = false) {
    writeStyleProperty("overflow-y", value, important)
}

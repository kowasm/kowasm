// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.borderBottomLeftRadius(value: Dimension, important: Boolean = false) {
    writeStyleProperty("border-bottom-left-radius", value, important)
}

fun StyleContext.borderBottomLeftRadius(value: Dimension, important: Boolean = false) {
    writeStyleProperty("border-bottom-left-radius", value, important)
}

fun InlineStyleContext.borderBottomLeftRadius(value: Dimension, important: Boolean = false) {
    writeStyleProperty("border-bottom-left-radius", value, important)
}

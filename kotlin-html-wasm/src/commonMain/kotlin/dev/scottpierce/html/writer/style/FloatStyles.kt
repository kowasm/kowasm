// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.float(value: FloatDirection, important: Boolean = false) {
    writeStyleProperty("float", value, important)
}

fun StyleContext.float(value: FloatDirection, important: Boolean = false) {
    writeStyleProperty("float", value, important)
}

fun InlineStyleContext.float(value: FloatDirection, important: Boolean = false) {
    writeStyleProperty("float", value, important)
}

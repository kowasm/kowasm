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

fun BaseStyleContext.animationDuration(value: String, important: Boolean = false) {
    writeStyleProperty("animation-duration", value, important)
}

fun BaseStyleContext.animationDuration(value: CssValue, important: Boolean = false) {
    writeStyleProperty("animation-duration", value, important)
}

fun StyleContext.animationDuration(value: String, important: Boolean = false) {
    writeStyleProperty("animation-duration", value, important)
}

fun StyleContext.animationDuration(value: CssValue, important: Boolean = false) {
    writeStyleProperty("animation-duration", value, important)
}

fun InlineStyleContext.animationDuration(value: String, important: Boolean = false) {
    writeStyleProperty("animation-duration", value, important)
}

fun InlineStyleContext.animationDuration(value: CssValue, important: Boolean = false) {
    writeStyleProperty("animation-duration", value, important)
}

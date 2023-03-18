// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.outline(
    width: Dimension,
    style: OutlineStyle,
    color: Color? = null,
    important: Boolean = false
) {
    writeStyleProperty("outline", """$width $style${if (color == null) "" else " $color"}""",
            important)
}

fun BaseStyleContext.outline(value: CssValue, important: Boolean = false) {
    writeStyleProperty("outline", value, important)
}

fun StyleContext.outline(
    width: Dimension,
    style: OutlineStyle,
    color: Color? = null,
    important: Boolean = false
) {
    writeStyleProperty("outline", """$width $style${if (color == null) "" else " $color"}""",
            important)
}

fun StyleContext.outline(value: CssValue, important: Boolean = false) {
    writeStyleProperty("outline", value, important)
}

fun InlineStyleContext.outline(
    width: Dimension,
    style: OutlineStyle,
    color: Color? = null,
    important: Boolean = false
) {
    writeStyleProperty("outline", """$width $style${if (color == null) "" else " $color"}""",
            important)
}

fun InlineStyleContext.outline(value: CssValue, important: Boolean = false) {
    writeStyleProperty("outline", value, important)
}

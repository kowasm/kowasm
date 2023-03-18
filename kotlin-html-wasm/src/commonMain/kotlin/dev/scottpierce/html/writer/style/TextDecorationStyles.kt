// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.textDecoration(
    vararg lines: TextDecorationLine,
    color: Color? = null,
    style: TextDecorationStyle? = null,
    important: Boolean = false
) {
    writeStyleProperty("text-decoration",
            """${lines.joinToString(separator = " ")}${if (color == null) "" else " $color"}${if (style == null) "" else " $style"}""",
            important)
}

fun BaseStyleContext.textDecoration(value: CssValue, important: Boolean = false) {
    writeStyleProperty("text-decoration", value, important)
}

fun StyleContext.textDecoration(
    vararg lines: TextDecorationLine,
    color: Color? = null,
    style: TextDecorationStyle? = null,
    important: Boolean = false
) {
    writeStyleProperty("text-decoration",
            """${lines.joinToString(separator = " ")}${if (color == null) "" else " $color"}${if (style == null) "" else " $style"}""",
            important)
}

fun StyleContext.textDecoration(value: CssValue, important: Boolean = false) {
    writeStyleProperty("text-decoration", value, important)
}

fun InlineStyleContext.textDecoration(
    vararg lines: TextDecorationLine,
    color: Color? = null,
    style: TextDecorationStyle? = null,
    important: Boolean = false
) {
    writeStyleProperty("text-decoration",
            """${lines.joinToString(separator = " ")}${if (color == null) "" else " $color"}${if (style == null) "" else " $style"}""",
            important)
}

fun InlineStyleContext.textDecoration(value: CssValue, important: Boolean = false) {
    writeStyleProperty("text-decoration", value, important)
}

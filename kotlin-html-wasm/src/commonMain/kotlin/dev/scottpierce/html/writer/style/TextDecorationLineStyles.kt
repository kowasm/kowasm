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

fun BaseStyleContext.textDecorationLine(value: TextDecorationLine, important: Boolean = false) {
    writeStyleProperty("text-decoration-line", value, important)
}

fun BaseStyleContext.textDecorationLine(vararg lines: TextDecorationLine, important: Boolean =
        false) {
    writeStyleProperty("text-decoration-line", lines.joinToString(separator = " "), important)
}

fun StyleContext.textDecorationLine(value: TextDecorationLine, important: Boolean = false) {
    writeStyleProperty("text-decoration-line", value, important)
}

fun StyleContext.textDecorationLine(vararg lines: TextDecorationLine, important: Boolean = false) {
    writeStyleProperty("text-decoration-line", lines.joinToString(separator = " "), important)
}

fun InlineStyleContext.textDecorationLine(value: TextDecorationLine, important: Boolean = false) {
    writeStyleProperty("text-decoration-line", value, important)
}

fun InlineStyleContext.textDecorationLine(vararg lines: TextDecorationLine, important: Boolean =
        false) {
    writeStyleProperty("text-decoration-line", lines.joinToString(separator = " "), important)
}

enum class TextDecorationLine(
    val value: String
) {
    NONE("none"),

    UNDERLINE("underline"),

    OVERLINE("overline"),

    LINE_THROUGH("line-through"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

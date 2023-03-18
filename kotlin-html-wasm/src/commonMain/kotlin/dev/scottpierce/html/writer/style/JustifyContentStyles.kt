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

fun BaseStyleContext.justifyContent(value: JustifyContent, important: Boolean = false) {
    writeStyleProperty("justify-content", value, important)
}

fun StyleContext.justifyContent(value: JustifyContent, important: Boolean = false) {
    writeStyleProperty("justify-content", value, important)
}

fun InlineStyleContext.justifyContent(value: JustifyContent, important: Boolean = false) {
    writeStyleProperty("justify-content", value, important)
}

enum class JustifyContent(
    val value: String
) {
    CENTER("center"),

    FLEX_END("flex-end"),

    FLEX_START("flex-start"),

    SPACE_AROUND("space-around"),

    SPACE_BETWEEN("space-between"),

    SPACE_EVENLY("space-evenly"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

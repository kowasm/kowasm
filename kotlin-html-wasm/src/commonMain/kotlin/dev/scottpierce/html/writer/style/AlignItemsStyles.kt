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

fun BaseStyleContext.alignItems(value: AlignItems, important: Boolean = false) {
    writeStyleProperty("align-items", value, important)
}

fun StyleContext.alignItems(value: AlignItems, important: Boolean = false) {
    writeStyleProperty("align-items", value, important)
}

fun InlineStyleContext.alignItems(value: AlignItems, important: Boolean = false) {
    writeStyleProperty("align-items", value, important)
}

enum class AlignItems(
    val value: String
) {
    BASELINE("baseline"),

    CENTER("center"),

    FLEX_START("flex-start"),

    FLEX_END("flex-end"),

    STRETCH("stretch"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

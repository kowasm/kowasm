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

fun BaseStyleContext.flexWrap(value: FlexWrap, important: Boolean = false) {
    writeStyleProperty("flex-wrap", value, important)
}

fun StyleContext.flexWrap(value: FlexWrap, important: Boolean = false) {
    writeStyleProperty("flex-wrap", value, important)
}

fun InlineStyleContext.flexWrap(value: FlexWrap, important: Boolean = false) {
    writeStyleProperty("flex-wrap", value, important)
}

enum class FlexWrap(
    val value: String
) {
    NOWRAP("nowrap"),

    WRAP("wrap"),

    WRAP_REVERSE("wrap-reverse"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

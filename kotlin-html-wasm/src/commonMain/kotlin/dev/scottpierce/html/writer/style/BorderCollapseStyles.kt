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

fun BaseStyleContext.borderCollapse(value: BorderCollapse, important: Boolean = false) {
    writeStyleProperty("border-collapse", value, important)
}

fun StyleContext.borderCollapse(value: BorderCollapse, important: Boolean = false) {
    writeStyleProperty("border-collapse", value, important)
}

fun InlineStyleContext.borderCollapse(value: BorderCollapse, important: Boolean = false) {
    writeStyleProperty("border-collapse", value, important)
}

enum class BorderCollapse(
    val value: String
) {
    SEPARATE("separate"),

    COLLAPSE("collapse"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

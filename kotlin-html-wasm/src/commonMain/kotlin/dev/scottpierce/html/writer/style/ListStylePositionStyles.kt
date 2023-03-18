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

fun BaseStyleContext.listStylePosition(value: ListStylePosition, important: Boolean = false) {
    writeStyleProperty("list-style-position", value, important)
}

fun StyleContext.listStylePosition(value: ListStylePosition, important: Boolean = false) {
    writeStyleProperty("list-style-position", value, important)
}

fun InlineStyleContext.listStylePosition(value: ListStylePosition, important: Boolean = false) {
    writeStyleProperty("list-style-position", value, important)
}

enum class ListStylePosition(
    val value: String
) {
    INSIDE("inside"),

    OUTSIDE("outside"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

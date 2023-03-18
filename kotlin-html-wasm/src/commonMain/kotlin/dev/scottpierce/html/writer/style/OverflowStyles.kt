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

fun BaseStyleContext.overflow(value: Dimension, important: Boolean = false) {
    writeStyleProperty("overflow", value, important)
}

fun BaseStyleContext.overflow(value: Overflow, important: Boolean = false) {
    writeStyleProperty("overflow", value, important)
}

fun StyleContext.overflow(value: Dimension, important: Boolean = false) {
    writeStyleProperty("overflow", value, important)
}

fun StyleContext.overflow(value: Overflow, important: Boolean = false) {
    writeStyleProperty("overflow", value, important)
}

fun InlineStyleContext.overflow(value: Dimension, important: Boolean = false) {
    writeStyleProperty("overflow", value, important)
}

fun InlineStyleContext.overflow(value: Overflow, important: Boolean = false) {
    writeStyleProperty("overflow", value, important)
}

enum class Overflow(
    val value: String
) {
    VISIBLE("visible"),

    HIDDEN("hidden"),

    SCROLL("scroll"),

    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

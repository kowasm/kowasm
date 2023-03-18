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

fun BaseStyleContext.position(value: Position, important: Boolean = false) {
    writeStyleProperty("position", value, important)
}

fun StyleContext.position(value: Position, important: Boolean = false) {
    writeStyleProperty("position", value, important)
}

fun InlineStyleContext.position(value: Position, important: Boolean = false) {
    writeStyleProperty("position", value, important)
}

enum class Position(
    val value: String
) {
    STATIC("static"),

    RELATIVE("relative"),

    FIXED("fixed"),

    ABSOLUTE("absolute"),

    STICKY("sticky"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

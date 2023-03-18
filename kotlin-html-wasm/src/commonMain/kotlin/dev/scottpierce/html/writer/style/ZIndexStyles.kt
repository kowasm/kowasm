// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.zIndex(value: Int, important: Boolean = false) {
    writeStyleProperty("z-index", value, important)
}

fun BaseStyleContext.zIndex(value: ZIndex, important: Boolean = false) {
    writeStyleProperty("z-index", value, important)
}

fun StyleContext.zIndex(value: Int, important: Boolean = false) {
    writeStyleProperty("z-index", value, important)
}

fun StyleContext.zIndex(value: ZIndex, important: Boolean = false) {
    writeStyleProperty("z-index", value, important)
}

fun InlineStyleContext.zIndex(value: Int, important: Boolean = false) {
    writeStyleProperty("z-index", value, important)
}

fun InlineStyleContext.zIndex(value: ZIndex, important: Boolean = false) {
    writeStyleProperty("z-index", value, important)
}

enum class ZIndex(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

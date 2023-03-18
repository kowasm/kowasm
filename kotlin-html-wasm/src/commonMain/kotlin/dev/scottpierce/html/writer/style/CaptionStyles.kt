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

fun BaseStyleContext.caption(value: Caption, important: Boolean = false) {
    writeStyleProperty("caption", value, important)
}

fun StyleContext.caption(value: Caption, important: Boolean = false) {
    writeStyleProperty("caption", value, important)
}

fun InlineStyleContext.caption(value: Caption, important: Boolean = false) {
    writeStyleProperty("caption", value, important)
}

enum class Caption(
    val value: String
) {
    TOP("top"),

    BOTTOM("bottom"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

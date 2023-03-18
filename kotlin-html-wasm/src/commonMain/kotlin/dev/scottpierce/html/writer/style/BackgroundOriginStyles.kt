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

fun BaseStyleContext.backgroundOrigin(value: BackgroundOrigin, important: Boolean = false) {
    writeStyleProperty("background-origin", value, important)
}

fun StyleContext.backgroundOrigin(value: BackgroundOrigin, important: Boolean = false) {
    writeStyleProperty("background-origin", value, important)
}

fun InlineStyleContext.backgroundOrigin(value: BackgroundOrigin, important: Boolean = false) {
    writeStyleProperty("background-origin", value, important)
}

enum class BackgroundOrigin(
    val value: String
) {
    PADDING_BOX("padding-box"),

    BORDER_BOX("border-box"),

    CONTENT_BOX("content-box"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

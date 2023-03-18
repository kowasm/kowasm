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

fun BaseStyleContext.backgroundAttachment(value: BackgroundAttachment, important: Boolean = false) {
    writeStyleProperty("background-attachment", value, important)
}

fun StyleContext.backgroundAttachment(value: BackgroundAttachment, important: Boolean = false) {
    writeStyleProperty("background-attachment", value, important)
}

fun InlineStyleContext.backgroundAttachment(value: BackgroundAttachment, important: Boolean =
        false) {
    writeStyleProperty("background-attachment", value, important)
}

enum class BackgroundAttachment(
    val value: String
) {
    SCROLL("scroll"),

    FIXED("fixed"),

    LOCAL("local"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

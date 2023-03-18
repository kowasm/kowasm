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

fun BaseStyleContext.alignSelf(value: AlignSelf, important: Boolean = false) {
    writeStyleProperty("align-self", value, important)
}

fun StyleContext.alignSelf(value: AlignSelf, important: Boolean = false) {
    writeStyleProperty("align-self", value, important)
}

fun InlineStyleContext.alignSelf(value: AlignSelf, important: Boolean = false) {
    writeStyleProperty("align-self", value, important)
}

enum class AlignSelf(
    val value: String
) {
    AUTO("auto"),

    BASELINE("baseline"),

    CENTER("center"),

    END("end"),

    FLEX_END("flex-end"),

    FLEX_START("flex-start"),

    START("start"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

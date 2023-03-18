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

fun BaseStyleContext.backgroundRepeat(value: BackgroundRepeat, important: Boolean = false) {
    writeStyleProperty("background-repeat", value, important)
}

fun StyleContext.backgroundRepeat(value: BackgroundRepeat, important: Boolean = false) {
    writeStyleProperty("background-repeat", value, important)
}

fun InlineStyleContext.backgroundRepeat(value: BackgroundRepeat, important: Boolean = false) {
    writeStyleProperty("background-repeat", value, important)
}

enum class BackgroundRepeat(
    val value: String
) {
    REPEAT("repeat"),

    REPEAT_X("repeat-x"),

    REPEAT_Y("repeat-y"),

    NO_REPEAT("no-repeat"),

    SPACE("space"),

    ROUND("round"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

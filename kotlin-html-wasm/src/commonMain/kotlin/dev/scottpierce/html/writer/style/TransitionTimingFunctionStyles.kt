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

fun BaseStyleContext.transitionTimingFunction(value: TransitionTimingFunction, important: Boolean =
        false) {
    writeStyleProperty("transition-timing-function", value, important)
}

fun StyleContext.transitionTimingFunction(value: TransitionTimingFunction, important: Boolean =
        false) {
    writeStyleProperty("transition-timing-function", value, important)
}

fun InlineStyleContext.transitionTimingFunction(value: TransitionTimingFunction, important: Boolean
        = false) {
    writeStyleProperty("transition-timing-function", value, important)
}

enum class TransitionTimingFunction(
    val value: String
) {
    LINEAR("linear"),

    EASE("ease"),

    EASE_IN("ease-in"),

    EASE_OUT("ease-out"),

    EASE_IN_OUT("ease-in-out"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

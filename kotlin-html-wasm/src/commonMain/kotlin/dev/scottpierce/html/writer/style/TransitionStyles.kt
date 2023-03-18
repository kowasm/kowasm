// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress
import kotlin.time.Duration

fun BaseStyleContext.transition(
    property: TransitionProperty,
    duration: Duration? = null,
    important: Boolean = false
) {
    writeStyleProperty("transition",
            """$property${if (duration == null) "" else " ${duration.toCssString()}"}""", important)
}

fun BaseStyleContext.transition(
    property: TransitionProperty,
    duration: Duration,
    timing: TransitionTimingFunction,
    delay: Duration? = null,
    important: Boolean = false
) {
    writeStyleProperty("transition",
            """$property ${duration.toCssString()} $timing${if (delay == null) "" else " " + delay.toCssString()}""",
            important)
}

fun BaseStyleContext.transition(value: CssValue, important: Boolean = false) {
    writeStyleProperty("transition", value, important)
}

fun StyleContext.transition(
    property: TransitionProperty,
    duration: Duration? = null,
    important: Boolean = false
) {
    writeStyleProperty("transition",
            """$property${if (duration == null) "" else " ${duration.toCssString()}"}""", important)
}

fun StyleContext.transition(
    property: TransitionProperty,
    duration: Duration,
    timing: TransitionTimingFunction,
    delay: Duration? = null,
    important: Boolean = false
) {
    writeStyleProperty("transition",
            """$property ${duration.toCssString()} $timing${if (delay == null) "" else " " + delay.toCssString()}""",
            important)
}

fun StyleContext.transition(value: CssValue, important: Boolean = false) {
    writeStyleProperty("transition", value, important)
}

fun InlineStyleContext.transition(
    property: TransitionProperty,
    duration: Duration? = null,
    important: Boolean = false
) {
    writeStyleProperty("transition",
            """$property${if (duration == null) "" else " ${duration.toCssString()}"}""", important)
}

fun InlineStyleContext.transition(
    property: TransitionProperty,
    duration: Duration,
    timing: TransitionTimingFunction,
    delay: Duration? = null,
    important: Boolean = false
) {
    writeStyleProperty("transition",
            """$property ${duration.toCssString()} $timing${if (delay == null) "" else " " + delay.toCssString()}""",
            important)
}

fun InlineStyleContext.transition(value: CssValue, important: Boolean = false) {
    writeStyleProperty("transition", value, important)
}

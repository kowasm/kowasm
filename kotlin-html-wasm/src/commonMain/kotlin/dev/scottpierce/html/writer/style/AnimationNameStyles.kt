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

fun BaseStyleContext.animationName(value: String, important: Boolean = false) {
    writeStyleProperty("animation-name", value, important)
}

fun BaseStyleContext.animationName(value: AnimationName, important: Boolean = false) {
    writeStyleProperty("animation-name", value, important)
}

fun StyleContext.animationName(value: String, important: Boolean = false) {
    writeStyleProperty("animation-name", value, important)
}

fun StyleContext.animationName(value: AnimationName, important: Boolean = false) {
    writeStyleProperty("animation-name", value, important)
}

fun InlineStyleContext.animationName(value: String, important: Boolean = false) {
    writeStyleProperty("animation-name", value, important)
}

fun InlineStyleContext.animationName(value: AnimationName, important: Boolean = false) {
    writeStyleProperty("animation-name", value, important)
}

enum class AnimationName(
    val value: String
) {
    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

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

fun BaseStyleContext.flexBasis(value: Dimension, important: Boolean = false) {
    writeStyleProperty("flex-basis", value, important)
}

fun BaseStyleContext.flexBasis(value: FlexBasis, important: Boolean = false) {
    writeStyleProperty("flex-basis", value, important)
}

fun StyleContext.flexBasis(value: Dimension, important: Boolean = false) {
    writeStyleProperty("flex-basis", value, important)
}

fun StyleContext.flexBasis(value: FlexBasis, important: Boolean = false) {
    writeStyleProperty("flex-basis", value, important)
}

fun InlineStyleContext.flexBasis(value: Dimension, important: Boolean = false) {
    writeStyleProperty("flex-basis", value, important)
}

fun InlineStyleContext.flexBasis(value: FlexBasis, important: Boolean = false) {
    writeStyleProperty("flex-basis", value, important)
}

enum class FlexBasis(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

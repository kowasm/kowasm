// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Number
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.flex(flexGrow: Number, important: Boolean = false) {
    writeStyleProperty("flex", flexGrow, important)
}

fun BaseStyleContext.flex(
    flexGrow: Number,
    flexShrink: Number,
    important: Boolean = false
) {
    writeStyleProperty("flex", """$flexGrow $flexShrink""", important)
}

fun BaseStyleContext.flex(
    flexGrow: Number,
    flexShrink: Number,
    flexBasis: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("flex", """$flexGrow $flexShrink $flexBasis""", important)
}

fun BaseStyleContext.flex(
    flexGrow: Number,
    flexShrink: Number,
    flexBasis: FlexBasis,
    important: Boolean = false
) {
    writeStyleProperty("flex", """$flexGrow $flexShrink $flexBasis""", important)
}

fun BaseStyleContext.flex(value: Flex, important: Boolean = false) {
    writeStyleProperty("flex", value, important)
}

fun StyleContext.flex(flexGrow: Number, important: Boolean = false) {
    writeStyleProperty("flex", flexGrow, important)
}

fun StyleContext.flex(
    flexGrow: Number,
    flexShrink: Number,
    important: Boolean = false
) {
    writeStyleProperty("flex", """$flexGrow $flexShrink""", important)
}

fun StyleContext.flex(
    flexGrow: Number,
    flexShrink: Number,
    flexBasis: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("flex", """$flexGrow $flexShrink $flexBasis""", important)
}

fun StyleContext.flex(
    flexGrow: Number,
    flexShrink: Number,
    flexBasis: FlexBasis,
    important: Boolean = false
) {
    writeStyleProperty("flex", """$flexGrow $flexShrink $flexBasis""", important)
}

fun StyleContext.flex(value: Flex, important: Boolean = false) {
    writeStyleProperty("flex", value, important)
}

fun InlineStyleContext.flex(flexGrow: Number, important: Boolean = false) {
    writeStyleProperty("flex", flexGrow, important)
}

fun InlineStyleContext.flex(
    flexGrow: Number,
    flexShrink: Number,
    important: Boolean = false
) {
    writeStyleProperty("flex", """$flexGrow $flexShrink""", important)
}

fun InlineStyleContext.flex(
    flexGrow: Number,
    flexShrink: Number,
    flexBasis: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("flex", """$flexGrow $flexShrink $flexBasis""", important)
}

fun InlineStyleContext.flex(
    flexGrow: Number,
    flexShrink: Number,
    flexBasis: FlexBasis,
    important: Boolean = false
) {
    writeStyleProperty("flex", """$flexGrow $flexShrink $flexBasis""", important)
}

fun InlineStyleContext.flex(value: Flex, important: Boolean = false) {
    writeStyleProperty("flex", value, important)
}

enum class Flex(
    val value: String
) {
    AUTO("auto"),

    INITIAL("initial"),

    INHERIT("inherit"),

    NONE("none");

    override fun toString() = value
}

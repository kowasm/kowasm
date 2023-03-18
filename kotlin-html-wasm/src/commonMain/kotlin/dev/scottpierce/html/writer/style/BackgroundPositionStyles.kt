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

fun BaseStyleContext.backgroundPosition(
    x: BackgroundPosition,
    y: BackgroundPosition? = null,
    important: Boolean = false
) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""", important)
}

fun BaseStyleContext.backgroundPosition(
    x: Dimension,
    y: Dimension? = null,
    important: Boolean = false
) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""", important)
}

fun BaseStyleContext.backgroundPosition(value: CssValue, important: Boolean = false) {
    writeStyleProperty("background-position", value, important)
}

fun StyleContext.backgroundPosition(
    x: BackgroundPosition,
    y: BackgroundPosition? = null,
    important: Boolean = false
) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""", important)
}

fun StyleContext.backgroundPosition(
    x: Dimension,
    y: Dimension? = null,
    important: Boolean = false
) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""", important)
}

fun StyleContext.backgroundPosition(value: CssValue, important: Boolean = false) {
    writeStyleProperty("background-position", value, important)
}

fun InlineStyleContext.backgroundPosition(
    x: BackgroundPosition,
    y: BackgroundPosition? = null,
    important: Boolean = false
) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""", important)
}

fun InlineStyleContext.backgroundPosition(
    x: Dimension,
    y: Dimension? = null,
    important: Boolean = false
) {
    writeStyleProperty("background-position", """$x${if (y == null) "" else " $y"}""", important)
}

fun InlineStyleContext.backgroundPosition(value: CssValue, important: Boolean = false) {
    writeStyleProperty("background-position", value, important)
}

enum class BackgroundPosition(
    val value: String
) {
    LEFT("left"),

    RIGHT("right"),

    TOP("top"),

    BOTTOM("bottom"),

    CENTER("center");

    override fun toString() = value
}

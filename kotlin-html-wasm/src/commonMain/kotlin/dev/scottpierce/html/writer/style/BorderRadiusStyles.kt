// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.Suppress

fun BaseStyleContext.borderRadius(value: Dimension, important: Boolean = false) {
    writeStyleProperty("border-radius", value, important)
}

fun BaseStyleContext.borderRadius(
    topLeftAndBottomRight: Dimension,
    topRightAndBottomLeft: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("border-radius", """$topLeftAndBottomRight $topRightAndBottomLeft""",
            important)
}

fun BaseStyleContext.borderRadius(
    topLeft: Dimension,
    topRightAndBottomLeft: Dimension,
    bottomRight: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("border-radius", """$topLeft $topRightAndBottomLeft $bottomRight""",
            important)
}

fun BaseStyleContext.borderRadius(
    topLeft: Dimension,
    topRight: Dimension,
    bottomRight: Dimension,
    bottomLeft: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("border-radius", """$topLeft $topRight $bottomRight $bottomLeft""",
            important)
}

fun StyleContext.borderRadius(value: Dimension, important: Boolean = false) {
    writeStyleProperty("border-radius", value, important)
}

fun StyleContext.borderRadius(
    topLeftAndBottomRight: Dimension,
    topRightAndBottomLeft: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("border-radius", """$topLeftAndBottomRight $topRightAndBottomLeft""",
            important)
}

fun StyleContext.borderRadius(
    topLeft: Dimension,
    topRightAndBottomLeft: Dimension,
    bottomRight: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("border-radius", """$topLeft $topRightAndBottomLeft $bottomRight""",
            important)
}

fun StyleContext.borderRadius(
    topLeft: Dimension,
    topRight: Dimension,
    bottomRight: Dimension,
    bottomLeft: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("border-radius", """$topLeft $topRight $bottomRight $bottomLeft""",
            important)
}

fun InlineStyleContext.borderRadius(value: Dimension, important: Boolean = false) {
    writeStyleProperty("border-radius", value, important)
}

fun InlineStyleContext.borderRadius(
    topLeftAndBottomRight: Dimension,
    topRightAndBottomLeft: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("border-radius", """$topLeftAndBottomRight $topRightAndBottomLeft""",
            important)
}

fun InlineStyleContext.borderRadius(
    topLeft: Dimension,
    topRightAndBottomLeft: Dimension,
    bottomRight: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("border-radius", """$topLeft $topRightAndBottomLeft $bottomRight""",
            important)
}

fun InlineStyleContext.borderRadius(
    topLeft: Dimension,
    topRight: Dimension,
    bottomRight: Dimension,
    bottomLeft: Dimension,
    important: Boolean = false
) {
    writeStyleProperty("border-radius", """$topLeft $topRight $bottomRight $bottomLeft""",
            important)
}

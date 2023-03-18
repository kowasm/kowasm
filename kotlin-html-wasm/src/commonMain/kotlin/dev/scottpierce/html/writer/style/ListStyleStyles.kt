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

fun BaseStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition? = null,
    important: Boolean = false
) {
    writeStyleProperty("list-style", """$type${if (position == null) "" else " $position"}""",
            important)
}

fun BaseStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    imageUrl: String,
    important: Boolean = false
) {
    writeStyleProperty("list-style", """$type $position url('$imageUrl')""", important)
}

fun BaseStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    image: ListStyleImage,
    important: Boolean = false
) {
    writeStyleProperty("list-style", """$type $position $image""", important)
}

fun BaseStyleContext.listStyle(value: CssValue, important: Boolean = false) {
    writeStyleProperty("list-style", value, important)
}

fun StyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition? = null,
    important: Boolean = false
) {
    writeStyleProperty("list-style", """$type${if (position == null) "" else " $position"}""",
            important)
}

fun StyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    imageUrl: String,
    important: Boolean = false
) {
    writeStyleProperty("list-style", """$type $position url('$imageUrl')""", important)
}

fun StyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    image: ListStyleImage,
    important: Boolean = false
) {
    writeStyleProperty("list-style", """$type $position $image""", important)
}

fun StyleContext.listStyle(value: CssValue, important: Boolean = false) {
    writeStyleProperty("list-style", value, important)
}

fun InlineStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition? = null,
    important: Boolean = false
) {
    writeStyleProperty("list-style", """$type${if (position == null) "" else " $position"}""",
            important)
}

fun InlineStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    imageUrl: String,
    important: Boolean = false
) {
    writeStyleProperty("list-style", """$type $position url('$imageUrl')""", important)
}

fun InlineStyleContext.listStyle(
    type: ListStyleType,
    position: ListStylePosition,
    image: ListStyleImage,
    important: Boolean = false
) {
    writeStyleProperty("list-style", """$type $position $image""", important)
}

fun InlineStyleContext.listStyle(value: CssValue, important: Boolean = false) {
    writeStyleProperty("list-style", value, important)
}

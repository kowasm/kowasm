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

fun BaseStyleContext.listStyleImage(imageUrl: String, important: Boolean = false) {
    writeStyleProperty("list-style-image", """url('$imageUrl')""", important)
}

fun BaseStyleContext.listStyleImage(value: ListStyleImage, important: Boolean = false) {
    writeStyleProperty("list-style-image", value, important)
}

fun StyleContext.listStyleImage(imageUrl: String, important: Boolean = false) {
    writeStyleProperty("list-style-image", """url('$imageUrl')""", important)
}

fun StyleContext.listStyleImage(value: ListStyleImage, important: Boolean = false) {
    writeStyleProperty("list-style-image", value, important)
}

fun InlineStyleContext.listStyleImage(imageUrl: String, important: Boolean = false) {
    writeStyleProperty("list-style-image", """url('$imageUrl')""", important)
}

fun InlineStyleContext.listStyleImage(value: ListStyleImage, important: Boolean = false) {
    writeStyleProperty("list-style-image", value, important)
}

enum class ListStyleImage(
    val value: String
) {
    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

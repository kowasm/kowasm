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

fun BaseStyleContext.outlineStyle(value: OutlineStyle, important: Boolean = false) {
    writeStyleProperty("outline-style", value, important)
}

fun StyleContext.outlineStyle(value: OutlineStyle, important: Boolean = false) {
    writeStyleProperty("outline-style", value, important)
}

fun InlineStyleContext.outlineStyle(value: OutlineStyle, important: Boolean = false) {
    writeStyleProperty("outline-style", value, important)
}

enum class OutlineStyle(
    val value: String
) {
    NONE("none"),

    HIDDEN("hidden"),

    DOTTED("dotted"),

    DASHED("dashed"),

    SOLID("solid"),

    DOUBLE("double"),

    GROOVE("groove"),

    RIDGE("ridge"),

    INSET("inset"),

    OUTSET("outset"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

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

fun BaseStyleContext.borderStyle(value: BorderStyle, important: Boolean = false) {
    writeStyleProperty("border-style", value, important)
}

fun StyleContext.borderStyle(value: BorderStyle, important: Boolean = false) {
    writeStyleProperty("border-style", value, important)
}

fun InlineStyleContext.borderStyle(value: BorderStyle, important: Boolean = false) {
    writeStyleProperty("border-style", value, important)
}

enum class BorderStyle(
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

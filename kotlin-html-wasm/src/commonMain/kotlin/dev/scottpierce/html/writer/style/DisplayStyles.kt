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

fun BaseStyleContext.display(value: Display, important: Boolean = false) {
    writeStyleProperty("display", value, important)
}

fun BaseStyleContext.displayNone(important: Boolean = false) {
    writeStyleProperty("display", Display.NONE, important)
}

fun BaseStyleContext.displayInline(important: Boolean = false) {
    writeStyleProperty("display", Display.INLINE, important)
}

fun BaseStyleContext.displayBlock(important: Boolean = false) {
    writeStyleProperty("display", Display.BLOCK, important)
}

fun BaseStyleContext.displayFlex(important: Boolean = false) {
    writeStyleProperty("display", Display.FLEX, important)
}

fun BaseStyleContext.displayGrid(important: Boolean = false) {
    writeStyleProperty("display", Display.GRID, important)
}

fun StyleContext.display(value: Display, important: Boolean = false) {
    writeStyleProperty("display", value, important)
}

fun StyleContext.displayNone(important: Boolean = false) {
    writeStyleProperty("display", Display.NONE, important)
}

fun StyleContext.displayInline(important: Boolean = false) {
    writeStyleProperty("display", Display.INLINE, important)
}

fun StyleContext.displayBlock(important: Boolean = false) {
    writeStyleProperty("display", Display.BLOCK, important)
}

fun StyleContext.displayFlex(important: Boolean = false) {
    writeStyleProperty("display", Display.FLEX, important)
}

fun StyleContext.displayGrid(important: Boolean = false) {
    writeStyleProperty("display", Display.GRID, important)
}

fun InlineStyleContext.display(value: Display, important: Boolean = false) {
    writeStyleProperty("display", value, important)
}

fun InlineStyleContext.displayNone(important: Boolean = false) {
    writeStyleProperty("display", Display.NONE, important)
}

fun InlineStyleContext.displayInline(important: Boolean = false) {
    writeStyleProperty("display", Display.INLINE, important)
}

fun InlineStyleContext.displayBlock(important: Boolean = false) {
    writeStyleProperty("display", Display.BLOCK, important)
}

fun InlineStyleContext.displayFlex(important: Boolean = false) {
    writeStyleProperty("display", Display.FLEX, important)
}

fun InlineStyleContext.displayGrid(important: Boolean = false) {
    writeStyleProperty("display", Display.GRID, important)
}

enum class Display(
    val value: String
) {
    INLINE("inline"),

    BLOCK("block"),

    CONTENTS("contents"),

    FLEX("flex"),

    GRID("grid"),

    INLINE_BLOCK("inline-block"),

    INLINE_FLEX("inline-flex"),

    INLINE_GRID("inline-grid"),

    INLINE_TABLE("inline-table"),

    LIST_ITEM("list-item"),

    RUN_IN("run-in"),

    TABLE("table"),

    TABLE_CAPTION("table-caption"),

    TABLE_COLUMN_GROUP("table-column-group"),

    TABLE_HEADER_GROUP("table-header-group"),

    TABLE_FOOTER_GROUP("table-footer-group"),

    TABLE_ROW_GROUP("table-row-group"),

    TABLE_CELL("table-cell"),

    TABLE_COLUMN("table-column"),

    TABLE_ROW("table-row"),

    NONE("none"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

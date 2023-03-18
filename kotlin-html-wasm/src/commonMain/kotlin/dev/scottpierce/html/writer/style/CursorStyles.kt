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

fun BaseStyleContext.cursor(value: Cursor, important: Boolean = false) {
    writeStyleProperty("cursor", value, important)
}

fun StyleContext.cursor(value: Cursor, important: Boolean = false) {
    writeStyleProperty("cursor", value, important)
}

fun InlineStyleContext.cursor(value: Cursor, important: Boolean = false) {
    writeStyleProperty("cursor", value, important)
}

enum class Cursor(
    val value: String
) {
    ALIAS("alias"),

    ALL_SCROLL("all-scroll"),

    AUTO("auto"),

    CELL("cell"),

    CONTEXT_MENU("context-menu"),

    COL_RESIZE("col-resize"),

    COPY("copy"),

    CROSSHAIR("crosshair"),

    DEFAULT("default"),

    E_RESIZE("e-resize"),

    EW_RESIZE("ew-resize"),

    GRAB("grab"),

    GRABBING("grabbing"),

    HELP("help"),

    MOVE("move"),

    N_RESIZE("n-resize"),

    NE_RESIZE("ne-resize"),

    NESW_RESIZE("nesw-resize"),

    NS_RESIZE("ns-resize"),

    NW_RESIZE("nw-resize"),

    NWSE_RESIZE("nwse-resize"),

    NO_DROP("no-drop"),

    NONE("none"),

    NOT_ALLOWED("not-allowed"),

    POINTER("pointer"),

    PROGRESS("progress"),

    ROW_RESIZE("row-resize"),

    S_RESIZE("s-resize"),

    SE_RESIZE("se-resize"),

    SW_RESIZE("sw-resize"),

    TEXT("text"),

    VERTICAL_TEXT("vertical-text"),

    W_RESIZE("w-resize"),

    WAIT("wait"),

    ZOOM_IN("zoom-in"),

    ZOOM_OUT("zoom-out"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

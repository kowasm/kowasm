@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext

fun BaseStyleContext.marginX(value: Dimension) {
    marginLeft(value)
    marginRight(value)
}

fun StyleContext.marginX(value: Dimension) {
    marginLeft(value)
    marginRight(value)
}

fun InlineStyleContext.marginX(value: Dimension) {
    marginLeft(value)
    marginRight(value)
}

fun BaseStyleContext.marginY(value: Dimension) {
    marginTop(value)
    marginBottom(value)
}

fun StyleContext.marginY(value: Dimension) {
    marginTop(value)
    marginBottom(value)
}

fun InlineStyleContext.marginY(value: Dimension) {
    marginTop(value)
    marginBottom(value)
}

fun BaseStyleContext.paddingX(value: Dimension) {
    paddingLeft(value)
    paddingRight(value)
}

fun StyleContext.paddingX(value: Dimension) {
    paddingLeft(value)
    paddingRight(value)
}

fun InlineStyleContext.paddingX(value: Dimension) {
    paddingLeft(value)
    paddingRight(value)
}

fun BaseStyleContext.paddingY(value: Dimension) {
    paddingTop(value)
    paddingBottom(value)
}

fun StyleContext.paddingY(value: Dimension) {
    paddingTop(value)
    paddingBottom(value)
}

fun InlineStyleContext.paddingY(value: Dimension) {
    paddingTop(value)
    paddingBottom(value)
}

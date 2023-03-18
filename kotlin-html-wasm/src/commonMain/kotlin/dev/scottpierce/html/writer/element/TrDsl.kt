// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.TableContext
import dev.scottpierce.html.writer.TableRowContext
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.tr(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableRowContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("tr", id, classes, style)
        TableRowContext(this).apply(func)
        this.writeNormalElementEnd("tr")
    }
}

@HtmlDsl
inline fun HtmlOutput.tr(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableRowContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("tr", id, classes, style, attrs)
        TableRowContext(this).apply(func)
        this.writeNormalElementEnd("tr")
    }
}

@HtmlDsl
inline fun HtmlOutput.tr(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableRowContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("tr", id, classes, style, attrs)
        TableRowContext(this).apply(func)
        this.writeNormalElementEnd("tr")
    }
}

@HtmlDsl
inline fun TableContext.tr(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableRowContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("tr", id, classes, style)
    TableRowContext(writer).apply(func)
    writer.writeNormalElementEnd("tr")
}

@HtmlDsl
inline fun TableContext.tr(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableRowContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("tr", id, classes, style, attrs)
    TableRowContext(writer).apply(func)
    writer.writeNormalElementEnd("tr")
}

@HtmlDsl
inline fun TableContext.tr(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableRowContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("tr", id, classes, style, attrs)
    TableRowContext(writer).apply(func)
    writer.writeNormalElementEnd("tr")
}

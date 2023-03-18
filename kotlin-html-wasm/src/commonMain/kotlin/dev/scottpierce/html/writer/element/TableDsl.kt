// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.TableContext
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.table(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("table", id, classes, style)
        TableContext(this).apply(func)
        this.writeNormalElementEnd("table")
    }
}

@HtmlDsl
inline fun HtmlOutput.table(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("table", id, classes, style, attrs)
        TableContext(this).apply(func)
        this.writeNormalElementEnd("table")
    }
}

@HtmlDsl
inline fun HtmlOutput.table(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("table", id, classes, style, attrs)
        TableContext(this).apply(func)
        this.writeNormalElementEnd("table")
    }
}

@HtmlDsl
inline fun BodyContext.table(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("table", id, classes, style)
    TableContext(writer).apply(func)
    writer.writeNormalElementEnd("table")
}

@HtmlDsl
inline fun BodyContext.table(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("table", id, classes, style, attrs)
    TableContext(writer).apply(func)
    writer.writeNormalElementEnd("table")
}

@HtmlDsl
inline fun BodyContext.table(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("table", id, classes, style, attrs)
    TableContext(writer).apply(func)
    writer.writeNormalElementEnd("table")
}

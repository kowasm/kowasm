// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

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
inline fun HtmlOutput.thead(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("thead", id, classes, style)
        TableContext(this).apply(func)
        this.writeNormalElementEnd("thead")
    }
}

@HtmlDsl
inline fun HtmlOutput.thead(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("thead", id, classes, style, attrs)
        TableContext(this).apply(func)
        this.writeNormalElementEnd("thead")
    }
}

@HtmlDsl
inline fun HtmlOutput.thead(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("thead", id, classes, style, attrs)
        TableContext(this).apply(func)
        this.writeNormalElementEnd("thead")
    }
}

@HtmlDsl
inline fun TableContext.thead(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("thead", id, classes, style)
    func()
    writer.writeNormalElementEnd("thead")
}

@HtmlDsl
inline fun TableContext.thead(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("thead", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("thead")
}

@HtmlDsl
inline fun TableContext.thead(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: TableContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("thead", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("thead")
}

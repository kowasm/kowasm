// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.head(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("head", id, classes, style)
        HeadContext(this).apply(func)
        this.writeNormalElementEnd("head")
    }
}

@HtmlDsl
inline fun HtmlOutput.head(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("head", id, classes, style, attrs)
        HeadContext(this).apply(func)
        this.writeNormalElementEnd("head")
    }
}

@HtmlDsl
inline fun HtmlOutput.head(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("head", id, classes, style, attrs)
        HeadContext(this).apply(func)
        this.writeNormalElementEnd("head")
    }
}

@HtmlDsl
inline fun HtmlContext.head(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("head", id, classes, style)
    HeadContext(writer).apply(func)
    writer.writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlContext.head(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("head", id, classes, style, attrs)
    HeadContext(writer).apply(func)
    writer.writeNormalElementEnd("head")
}

@HtmlDsl
inline fun HtmlContext.head(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: HeadContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("head", id, classes, style, attrs)
    HeadContext(writer).apply(func)
    writer.writeNormalElementEnd("head")
}

// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.UlContext
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.ul(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("ul", id, classes, style)
        UlContext(this).apply(func)
        this.writeNormalElementEnd("ul")
    }
}

@HtmlDsl
inline fun HtmlOutput.ul(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("ul", id, classes, style, attrs)
        UlContext(this).apply(func)
        this.writeNormalElementEnd("ul")
    }
}

@HtmlDsl
inline fun HtmlOutput.ul(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("ul", id, classes, style, attrs)
        UlContext(this).apply(func)
        this.writeNormalElementEnd("ul")
    }
}

@HtmlDsl
inline fun BodyContext.ul(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("ul", id, classes, style)
    UlContext(writer).apply(func)
    writer.writeNormalElementEnd("ul")
}

@HtmlDsl
inline fun BodyContext.ul(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("ul", id, classes, style, attrs)
    UlContext(writer).apply(func)
    writer.writeNormalElementEnd("ul")
}

@HtmlDsl
inline fun BodyContext.ul(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: UlContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("ul", id, classes, style, attrs)
    UlContext(writer).apply(func)
    writer.writeNormalElementEnd("ul")
}

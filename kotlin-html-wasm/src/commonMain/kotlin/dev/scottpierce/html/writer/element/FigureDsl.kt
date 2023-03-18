// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.figure(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("figure", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("figure")
    }
}

@HtmlDsl
inline fun HtmlOutput.figure(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("figure", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("figure")
    }
}

@HtmlDsl
inline fun HtmlOutput.figure(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("figure", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("figure")
    }
}

@HtmlDsl
inline fun BodyContext.figure(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("figure", id, classes, style)
    func()
    writer.writeNormalElementEnd("figure")
}

@HtmlDsl
inline fun BodyContext.figure(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("figure", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("figure")
}

@HtmlDsl
inline fun BodyContext.figure(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("figure", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("figure")
}

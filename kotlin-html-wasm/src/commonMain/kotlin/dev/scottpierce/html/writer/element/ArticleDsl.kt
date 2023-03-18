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
inline fun HtmlOutput.article(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("article", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("article")
    }
}

@HtmlDsl
inline fun HtmlOutput.article(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("article", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("article")
    }
}

@HtmlDsl
inline fun HtmlOutput.article(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("article", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("article")
    }
}

@HtmlDsl
inline fun BodyContext.article(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("article", id, classes, style)
    func()
    writer.writeNormalElementEnd("article")
}

@HtmlDsl
inline fun BodyContext.article(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("article", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("article")
}

@HtmlDsl
inline fun BodyContext.article(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("article", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("article")
}

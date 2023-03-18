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
inline fun HtmlOutput.section(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("section", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("section")
    }
}

@HtmlDsl
inline fun HtmlOutput.section(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("section", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("section")
    }
}

@HtmlDsl
inline fun HtmlOutput.section(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("section", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("section")
    }
}

@HtmlDsl
inline fun BodyContext.section(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("section", id, classes, style)
    func()
    writer.writeNormalElementEnd("section")
}

@HtmlDsl
inline fun BodyContext.section(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("section", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("section")
}

@HtmlDsl
inline fun BodyContext.section(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("section", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("section")
}

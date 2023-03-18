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
inline fun HtmlOutput.mark(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("mark", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("mark")
    }
}

@HtmlDsl
inline fun HtmlOutput.mark(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("mark", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("mark")
    }
}

@HtmlDsl
inline fun HtmlOutput.mark(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("mark", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("mark")
    }
}

@HtmlDsl
inline fun BodyContext.mark(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("mark", id, classes, style)
    func()
    writer.writeNormalElementEnd("mark")
}

@HtmlDsl
inline fun BodyContext.mark(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("mark", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("mark")
}

@HtmlDsl
inline fun BodyContext.mark(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("mark", id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd("mark")
}

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
inline fun HtmlOutput.caption(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("caption", id, classes, style)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("caption")
    }
}

@HtmlDsl
inline fun HtmlOutput.caption(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("caption", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("caption")
    }
}

@HtmlDsl
inline fun HtmlOutput.caption(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeNormalElementStart("caption", id, classes, style, attrs)
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("caption")
    }
}

@HtmlDsl
inline fun TableContext.caption(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("caption", id, classes, style)
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("caption")
}

@HtmlDsl
inline fun TableContext.caption(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("caption", id, classes, style, attrs)
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("caption")
}

@HtmlDsl
inline fun TableContext.caption(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart("caption", id, classes, style, attrs)
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("caption")
}

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
inline fun HtmlOutput.label(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("label")
        this.writeStandardAttributes(id, classes, style)
        if (forId != null) this.write(" for=\"").write(forId).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("label")
    }
}

@HtmlDsl
inline fun HtmlOutput.label(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("label")
        this.writeStandardAttributes(id, classes, style)
        if (forId != null) this.write(" for=\"").write(forId).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("label")
    }
}

@HtmlDsl
inline fun HtmlOutput.label(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("label")
        this.writeStandardAttributes(id, classes, style)
        if (forId != null) this.write(" for=\"").write(forId).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("label")
    }
}

@HtmlDsl
inline fun BodyContext.label(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("label")
    writer.writeStandardAttributes(id, classes, style)
    if (forId != null) writer.write(" for=\"").write(forId).write('"')
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("label")
}

@HtmlDsl
inline fun BodyContext.label(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("label")
    writer.writeStandardAttributes(id, classes, style)
    if (forId != null) writer.write(" for=\"").write(forId).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("label")
}

@HtmlDsl
inline fun BodyContext.label(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    forId: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("label")
    writer.writeStandardAttributes(id, classes, style)
    if (forId != null) writer.write(" for=\"").write(forId).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("label")
}

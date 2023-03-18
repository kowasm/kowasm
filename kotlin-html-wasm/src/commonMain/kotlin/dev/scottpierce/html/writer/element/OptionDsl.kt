// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.SelectContext
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.option(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("option")
        this.writeStandardAttributes(id, classes, style)
        if (value != null) this.write(" value=\"").write(value).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("option")
    }
}

@HtmlDsl
inline fun HtmlOutput.option(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("option")
        this.writeStandardAttributes(id, classes, style)
        if (value != null) this.write(" value=\"").write(value).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("option")
    }
}

@HtmlDsl
inline fun HtmlOutput.option(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("option")
        this.writeStandardAttributes(id, classes, style)
        if (value != null) this.write(" value=\"").write(value).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("option")
    }
}

@HtmlDsl
inline fun SelectContext.option(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("option")
    writer.writeStandardAttributes(id, classes, style)
    if (value != null) writer.write(" value=\"").write(value).write('"')
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("option")
}

@HtmlDsl
inline fun SelectContext.option(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("option")
    writer.writeStandardAttributes(id, classes, style)
    if (value != null) writer.write(" value=\"").write(value).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("option")
}

@HtmlDsl
inline fun SelectContext.option(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    value: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("option")
    writer.writeStandardAttributes(id, classes, style)
    if (value != null) writer.write(" value=\"").write(value).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("option")
}

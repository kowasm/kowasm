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
inline fun HtmlOutput.time(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    datetime: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("time")
        this.writeStandardAttributes(id, classes, style)
        if (datetime != null) this.write(" datetime=\"").write(datetime).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("time")
    }
}

@HtmlDsl
inline fun HtmlOutput.time(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    datetime: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("time")
        this.writeStandardAttributes(id, classes, style)
        if (datetime != null) this.write(" datetime=\"").write(datetime).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("time")
    }
}

@HtmlDsl
inline fun HtmlOutput.time(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    datetime: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("time")
        this.writeStandardAttributes(id, classes, style)
        if (datetime != null) this.write(" datetime=\"").write(datetime).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("time")
    }
}

@HtmlDsl
inline fun BodyContext.time(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    datetime: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("time")
    writer.writeStandardAttributes(id, classes, style)
    if (datetime != null) writer.write(" datetime=\"").write(datetime).write('"')
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("time")
}

@HtmlDsl
inline fun BodyContext.time(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    datetime: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("time")
    writer.writeStandardAttributes(id, classes, style)
    if (datetime != null) writer.write(" datetime=\"").write(datetime).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("time")
}

@HtmlDsl
inline fun BodyContext.time(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    datetime: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("time")
    writer.writeStandardAttributes(id, classes, style)
    if (datetime != null) writer.write(" datetime=\"").write(datetime).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("time")
}

// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.TableRowContext
import dev.scottpierce.html.writer.writer
import kotlin.Int
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.td(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    headers: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("td")
        this.writeStandardAttributes(id, classes, style)
        if (colspan != null) this.write(" colspan=\"").write(colspan.toString()).write('"')
        if (rowspan != null) this.write(" rowspan=\"").write(rowspan.toString()).write('"')
        if (headers != null) this.write(" headers=\"").write(headers).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("td")
    }
}

@HtmlDsl
inline fun HtmlOutput.td(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    headers: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("td")
        this.writeStandardAttributes(id, classes, style)
        if (colspan != null) this.write(" colspan=\"").write(colspan.toString()).write('"')
        if (rowspan != null) this.write(" rowspan=\"").write(rowspan.toString()).write('"')
        if (headers != null) this.write(" headers=\"").write(headers).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("td")
    }
}

@HtmlDsl
inline fun HtmlOutput.td(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    headers: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("td")
        this.writeStandardAttributes(id, classes, style)
        if (colspan != null) this.write(" colspan=\"").write(colspan.toString()).write('"')
        if (rowspan != null) this.write(" rowspan=\"").write(rowspan.toString()).write('"')
        if (headers != null) this.write(" headers=\"").write(headers).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("td")
    }
}

@HtmlDsl
inline fun TableRowContext.td(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    headers: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("td")
    writer.writeStandardAttributes(id, classes, style)
    if (colspan != null) writer.write(" colspan=\"").write(colspan.toString()).write('"')
    if (rowspan != null) writer.write(" rowspan=\"").write(rowspan.toString()).write('"')
    if (headers != null) writer.write(" headers=\"").write(headers).write('"')
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("td")
}

@HtmlDsl
inline fun TableRowContext.td(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    headers: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("td")
    writer.writeStandardAttributes(id, classes, style)
    if (colspan != null) writer.write(" colspan=\"").write(colspan.toString()).write('"')
    if (rowspan != null) writer.write(" rowspan=\"").write(rowspan.toString()).write('"')
    if (headers != null) writer.write(" headers=\"").write(headers).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("td")
}

@HtmlDsl
inline fun TableRowContext.td(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    headers: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("td")
    writer.writeStandardAttributes(id, classes, style)
    if (colspan != null) writer.write(" colspan=\"").write(colspan.toString()).write('"')
    if (rowspan != null) writer.write(" rowspan=\"").write(rowspan.toString()).write('"')
    if (headers != null) writer.write(" headers=\"").write(headers).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("td")
}

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
inline fun HtmlOutput.th(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    abbr: String? = null,
    headers: String? = null,
    scope: String? = null,
    sorted: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("th")
        this.writeStandardAttributes(id, classes, style)
        if (colspan != null) this.write(" colspan=\"").write(colspan.toString()).write('"')
        if (rowspan != null) this.write(" rowspan=\"").write(rowspan.toString()).write('"')
        if (abbr != null) this.write(" abbr=\"").write(abbr).write('"')
        if (headers != null) this.write(" headers=\"").write(headers).write('"')
        if (scope != null) this.write(" scope=\"").write(scope).write('"')
        if (sorted != null) this.write(" sorted=\"").write(sorted).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("th")
    }
}

@HtmlDsl
inline fun HtmlOutput.th(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    abbr: String? = null,
    headers: String? = null,
    scope: String? = null,
    sorted: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("th")
        this.writeStandardAttributes(id, classes, style)
        if (colspan != null) this.write(" colspan=\"").write(colspan.toString()).write('"')
        if (rowspan != null) this.write(" rowspan=\"").write(rowspan.toString()).write('"')
        if (abbr != null) this.write(" abbr=\"").write(abbr).write('"')
        if (headers != null) this.write(" headers=\"").write(headers).write('"')
        if (scope != null) this.write(" scope=\"").write(scope).write('"')
        if (sorted != null) this.write(" sorted=\"").write(sorted).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("th")
    }
}

@HtmlDsl
inline fun HtmlOutput.th(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    abbr: String? = null,
    headers: String? = null,
    scope: String? = null,
    sorted: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("th")
        this.writeStandardAttributes(id, classes, style)
        if (colspan != null) this.write(" colspan=\"").write(colspan.toString()).write('"')
        if (rowspan != null) this.write(" rowspan=\"").write(rowspan.toString()).write('"')
        if (abbr != null) this.write(" abbr=\"").write(abbr).write('"')
        if (headers != null) this.write(" headers=\"").write(headers).write('"')
        if (scope != null) this.write(" scope=\"").write(scope).write('"')
        if (sorted != null) this.write(" sorted=\"").write(sorted).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("th")
    }
}

@HtmlDsl
inline fun TableRowContext.th(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    abbr: String? = null,
    headers: String? = null,
    scope: String? = null,
    sorted: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("th")
    writer.writeStandardAttributes(id, classes, style)
    if (colspan != null) writer.write(" colspan=\"").write(colspan.toString()).write('"')
    if (rowspan != null) writer.write(" rowspan=\"").write(rowspan.toString()).write('"')
    if (abbr != null) writer.write(" abbr=\"").write(abbr).write('"')
    if (headers != null) writer.write(" headers=\"").write(headers).write('"')
    if (scope != null) writer.write(" scope=\"").write(scope).write('"')
    if (sorted != null) writer.write(" sorted=\"").write(sorted).write('"')
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("th")
}

@HtmlDsl
inline fun TableRowContext.th(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    abbr: String? = null,
    headers: String? = null,
    scope: String? = null,
    sorted: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("th")
    writer.writeStandardAttributes(id, classes, style)
    if (colspan != null) writer.write(" colspan=\"").write(colspan.toString()).write('"')
    if (rowspan != null) writer.write(" rowspan=\"").write(rowspan.toString()).write('"')
    if (abbr != null) writer.write(" abbr=\"").write(abbr).write('"')
    if (headers != null) writer.write(" headers=\"").write(headers).write('"')
    if (scope != null) writer.write(" scope=\"").write(scope).write('"')
    if (sorted != null) writer.write(" sorted=\"").write(sorted).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("th")
}

@HtmlDsl
inline fun TableRowContext.th(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    colspan: Int? = null,
    rowspan: Int? = null,
    abbr: String? = null,
    headers: String? = null,
    scope: String? = null,
    sorted: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("th")
    writer.writeStandardAttributes(id, classes, style)
    if (colspan != null) writer.write(" colspan=\"").write(colspan.toString()).write('"')
    if (rowspan != null) writer.write(" rowspan=\"").write(rowspan.toString()).write('"')
    if (abbr != null) writer.write(" abbr=\"").write(abbr).write('"')
    if (headers != null) writer.write(" headers=\"").write(headers).write('"')
    if (scope != null) writer.write(" scope=\"").write(scope).write('"')
    if (sorted != null) writer.write(" sorted=\"").write(sorted).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    BodyContext(writer).apply(func)
    writer.writeNormalElementEnd("th")
}

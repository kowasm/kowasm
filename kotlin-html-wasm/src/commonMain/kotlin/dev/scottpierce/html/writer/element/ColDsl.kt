// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.ColGroupContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.TableContext
import dev.scottpierce.html.writer.writer
import kotlin.Int
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlOutput.col(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    span: Int? = null
) {
    writer {
        this.writeTag("col")
        this.writeStandardAttributes(id, classes, style)
        if (span != null) this.write(" span=\"").write(span.toString()).write('"')
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.col(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    span: Int? = null
) {
    writer {
        this.writeTag("col")
        this.writeStandardAttributes(id, classes, style)
        if (span != null) this.write(" span=\"").write(span.toString()).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.col(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    span: Int? = null
) {
    writer {
        this.writeTag("col")
        this.writeStandardAttributes(id, classes, style)
        if (span != null) this.write(" span=\"").write(span.toString()).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun TableContext.col(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    span: Int? = null
) {
    writer.writeTag("col")
    writer.writeStandardAttributes(id, classes, style)
    if (span != null) writer.write(" span=\"").write(span.toString()).write('"')
    writer.write('>')
}

@HtmlDsl
fun TableContext.col(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    span: Int? = null
) {
    writer.writeTag("col")
    writer.writeStandardAttributes(id, classes, style)
    if (span != null) writer.write(" span=\"").write(span.toString()).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

@HtmlDsl
fun TableContext.col(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    span: Int? = null
) {
    writer.writeTag("col")
    writer.writeStandardAttributes(id, classes, style)
    if (span != null) writer.write(" span=\"").write(span.toString()).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

@HtmlDsl
fun ColGroupContext.col(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    span: Int? = null
) {
    writer.writeTag("col")
    writer.writeStandardAttributes(id, classes, style)
    if (span != null) writer.write(" span=\"").write(span.toString()).write('"')
    writer.write('>')
}

@HtmlDsl
fun ColGroupContext.col(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    span: Int? = null
) {
    writer.writeTag("col")
    writer.writeStandardAttributes(id, classes, style)
    if (span != null) writer.write(" span=\"").write(span.toString()).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

@HtmlDsl
fun ColGroupContext.col(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    span: Int? = null
) {
    writer.writeTag("col")
    writer.writeStandardAttributes(id, classes, style)
    if (span != null) writer.write(" span=\"").write(span.toString()).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

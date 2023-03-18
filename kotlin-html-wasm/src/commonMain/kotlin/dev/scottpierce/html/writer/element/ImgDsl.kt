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
import kotlin.collections.List

@HtmlDsl
fun HtmlOutput.img(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    writer {
        this.writeTag("img")
        this.writeStandardAttributes(id, classes, style)
        if (src != null) this.write(" src=\"").write(src).write('"')
        if (alt != null) this.write(" alt=\"").write(alt).write('"')
        if (width != null) this.write(" width=\"").write(width).write('"')
        if (height != null) this.write(" height=\"").write(height).write('"')
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.img(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    writer {
        this.writeTag("img")
        this.writeStandardAttributes(id, classes, style)
        if (src != null) this.write(" src=\"").write(src).write('"')
        if (alt != null) this.write(" alt=\"").write(alt).write('"')
        if (width != null) this.write(" width=\"").write(width).write('"')
        if (height != null) this.write(" height=\"").write(height).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.img(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    writer {
        this.writeTag("img")
        this.writeStandardAttributes(id, classes, style)
        if (src != null) this.write(" src=\"").write(src).write('"')
        if (alt != null) this.write(" alt=\"").write(alt).write('"')
        if (width != null) this.write(" width=\"").write(width).write('"')
        if (height != null) this.write(" height=\"").write(height).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun BodyContext.img(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    writer.writeTag("img")
    writer.writeStandardAttributes(id, classes, style)
    if (src != null) writer.write(" src=\"").write(src).write('"')
    if (alt != null) writer.write(" alt=\"").write(alt).write('"')
    if (width != null) writer.write(" width=\"").write(width).write('"')
    if (height != null) writer.write(" height=\"").write(height).write('"')
    writer.write('>')
}

@HtmlDsl
fun BodyContext.img(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    writer.writeTag("img")
    writer.writeStandardAttributes(id, classes, style)
    if (src != null) writer.write(" src=\"").write(src).write('"')
    if (alt != null) writer.write(" alt=\"").write(alt).write('"')
    if (width != null) writer.write(" width=\"").write(width).write('"')
    if (height != null) writer.write(" height=\"").write(height).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

@HtmlDsl
fun BodyContext.img(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null,
    src: String? = null,
    alt: String? = null,
    width: String? = null,
    height: String? = null
) {
    writer.writeTag("img")
    writer.writeStandardAttributes(id, classes, style)
    if (src != null) writer.write(" src=\"").write(src).write('"')
    if (alt != null) writer.write(" alt=\"").write(alt).write('"')
    if (width != null) writer.write(" width=\"").write(width).write('"')
    if (height != null) writer.write(" height=\"").write(height).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

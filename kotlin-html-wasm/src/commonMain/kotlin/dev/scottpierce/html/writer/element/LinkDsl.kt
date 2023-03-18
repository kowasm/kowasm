// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlOutput.link(
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    writer {
        this.writeTag("link")
        if (href != null) this.write(" href=\"").write(href).write('"')
        if (rel != null) this.write(" rel=\"").write(rel).write('"')
        if (hreflang != null) this.write(" hreflang=\"").write(hreflang).write('"')
        if (media != null) this.write(" media=\"").write(media).write('"')
        if (type != null) this.write(" type=\"").write(type).write('"')
        if (sizes != null) this.write(" sizes=\"").write(sizes).write('"')
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.link(
    vararg attrs: Pair<String, String?>,
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    writer {
        this.writeTag("link")
        if (href != null) this.write(" href=\"").write(href).write('"')
        if (rel != null) this.write(" rel=\"").write(rel).write('"')
        if (hreflang != null) this.write(" hreflang=\"").write(hreflang).write('"')
        if (media != null) this.write(" media=\"").write(media).write('"')
        if (type != null) this.write(" type=\"").write(type).write('"')
        if (sizes != null) this.write(" sizes=\"").write(sizes).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun HtmlOutput.link(
    attrs: List<Pair<String, String?>>,
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    writer {
        this.writeTag("link")
        if (href != null) this.write(" href=\"").write(href).write('"')
        if (rel != null) this.write(" rel=\"").write(rel).write('"')
        if (hreflang != null) this.write(" hreflang=\"").write(hreflang).write('"')
        if (media != null) this.write(" media=\"").write(media).write('"')
        if (type != null) this.write(" type=\"").write(type).write('"')
        if (sizes != null) this.write(" sizes=\"").write(sizes).write('"')
        this.writeAttributes(attrs)
        this.write('>')
    }
}

@HtmlDsl
fun BaseHtmlContext.link(
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    writer.writeTag("link")
    if (href != null) writer.write(" href=\"").write(href).write('"')
    if (rel != null) writer.write(" rel=\"").write(rel).write('"')
    if (hreflang != null) writer.write(" hreflang=\"").write(hreflang).write('"')
    if (media != null) writer.write(" media=\"").write(media).write('"')
    if (type != null) writer.write(" type=\"").write(type).write('"')
    if (sizes != null) writer.write(" sizes=\"").write(sizes).write('"')
    writer.write('>')
}

@HtmlDsl
fun BaseHtmlContext.link(
    vararg attrs: Pair<String, String?>,
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    writer.writeTag("link")
    if (href != null) writer.write(" href=\"").write(href).write('"')
    if (rel != null) writer.write(" rel=\"").write(rel).write('"')
    if (hreflang != null) writer.write(" hreflang=\"").write(hreflang).write('"')
    if (media != null) writer.write(" media=\"").write(media).write('"')
    if (type != null) writer.write(" type=\"").write(type).write('"')
    if (sizes != null) writer.write(" sizes=\"").write(sizes).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

@HtmlDsl
fun BaseHtmlContext.link(
    attrs: List<Pair<String, String?>>,
    href: String? = null,
    rel: String? = null,
    hreflang: String? = null,
    media: String? = null,
    type: String? = null,
    sizes: String? = null
) {
    writer.writeTag("link")
    if (href != null) writer.write(" href=\"").write(href).write('"')
    if (rel != null) writer.write(" rel=\"").write(rel).write('"')
    if (hreflang != null) writer.write(" hreflang=\"").write(hreflang).write('"')
    if (media != null) writer.write(" media=\"").write(media).write('"')
    if (type != null) writer.write(" type=\"").write(type).write('"')
    if (sizes != null) writer.write(" sizes=\"").write(sizes).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
}

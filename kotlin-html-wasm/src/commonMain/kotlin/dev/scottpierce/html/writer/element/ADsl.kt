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
inline fun HtmlOutput.a(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("a")
        this.writeStandardAttributes(id, classes, style)
        if (href != null) this.write(" href=\"").write(href).write('"')
        if (target != null) this.write(" target=\"").write(target).write('"')
        if (rel != null) this.write(" rel=\"").write(rel).write('"')
        if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("a")
    }
}

@HtmlDsl
inline fun HtmlOutput.a(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("a")
        this.writeStandardAttributes(id, classes, style)
        if (href != null) this.write(" href=\"").write(href).write('"')
        if (target != null) this.write(" target=\"").write(target).write('"')
        if (rel != null) this.write(" rel=\"").write(rel).write('"')
        if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("a")
    }
}

@HtmlDsl
inline fun HtmlOutput.a(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("a")
        this.writeStandardAttributes(id, classes, style)
        if (href != null) this.write(" href=\"").write(href).write('"')
        if (target != null) this.write(" target=\"").write(target).write('"')
        if (rel != null) this.write(" rel=\"").write(rel).write('"')
        if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("a")
    }
}

@HtmlDsl
inline fun BodyContext.a(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("a")
    writer.writeStandardAttributes(id, classes, style)
    if (href != null) writer.write(" href=\"").write(href).write('"')
    if (target != null) writer.write(" target=\"").write(target).write('"')
    if (rel != null) writer.write(" rel=\"").write(rel).write('"')
    if (ariaLabel != null) writer.write(" aria-label=\"").write(ariaLabel).write('"')
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("a")
}

@HtmlDsl
inline fun BodyContext.a(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("a")
    writer.writeStandardAttributes(id, classes, style)
    if (href != null) writer.write(" href=\"").write(href).write('"')
    if (target != null) writer.write(" target=\"").write(target).write('"')
    if (rel != null) writer.write(" rel=\"").write(rel).write('"')
    if (ariaLabel != null) writer.write(" aria-label=\"").write(ariaLabel).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("a")
}

@HtmlDsl
inline fun BodyContext.a(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    href: String? = null,
    target: String? = null,
    rel: String? = null,
    ariaLabel: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("a")
    writer.writeStandardAttributes(id, classes, style)
    if (href != null) writer.write(" href=\"").write(href).write('"')
    if (target != null) writer.write(" target=\"").write(target).write('"')
    if (rel != null) writer.write(" rel=\"").write(rel).write('"')
    if (ariaLabel != null) writer.write(" aria-label=\"").write(ariaLabel).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("a")
}

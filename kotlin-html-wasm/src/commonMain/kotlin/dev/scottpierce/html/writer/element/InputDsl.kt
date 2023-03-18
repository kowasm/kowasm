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
inline fun HtmlOutput.input(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("input")
        this.writeStandardAttributes(id, classes, style)
        if (type != null) this.write(" type=\"").write(type).write('"')
        if (maxLength != null) this.write(" maxLength=\"").write(maxLength).write('"')
        if (value != null) this.write(" value=\"").write(value).write('"')
        if (name != null) this.write(" name=\"").write(name).write('"')
        if (placeholder != null) this.write(" placeholder=\"").write(placeholder).write('"')
        if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
        if (ariaLabelledBy != null)
                this.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("input")
    }
}

@HtmlDsl
inline fun HtmlOutput.input(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("input")
        this.writeStandardAttributes(id, classes, style)
        if (type != null) this.write(" type=\"").write(type).write('"')
        if (maxLength != null) this.write(" maxLength=\"").write(maxLength).write('"')
        if (value != null) this.write(" value=\"").write(value).write('"')
        if (name != null) this.write(" name=\"").write(name).write('"')
        if (placeholder != null) this.write(" placeholder=\"").write(placeholder).write('"')
        if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
        if (ariaLabelledBy != null)
                this.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("input")
    }
}

@HtmlDsl
inline fun HtmlOutput.input(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer {
        this.writeTag("input")
        this.writeStandardAttributes(id, classes, style)
        if (type != null) this.write(" type=\"").write(type).write('"')
        if (maxLength != null) this.write(" maxLength=\"").write(maxLength).write('"')
        if (value != null) this.write(" value=\"").write(value).write('"')
        if (name != null) this.write(" name=\"").write(name).write('"')
        if (placeholder != null) this.write(" placeholder=\"").write(placeholder).write('"')
        if (ariaLabel != null) this.write(" aria-label=\"").write(ariaLabel).write('"')
        if (ariaLabelledBy != null)
                this.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("input")
    }
}

@HtmlDsl
inline fun BodyContext.input(
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("input")
    writer.writeStandardAttributes(id, classes, style)
    if (type != null) writer.write(" type=\"").write(type).write('"')
    if (maxLength != null) writer.write(" maxLength=\"").write(maxLength).write('"')
    if (value != null) writer.write(" value=\"").write(value).write('"')
    if (name != null) writer.write(" name=\"").write(name).write('"')
    if (placeholder != null) writer.write(" placeholder=\"").write(placeholder).write('"')
    if (ariaLabel != null) writer.write(" aria-label=\"").write(ariaLabel).write('"')
    if (ariaLabelledBy != null) writer.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("input")
}

@HtmlDsl
inline fun BodyContext.input(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("input")
    writer.writeStandardAttributes(id, classes, style)
    if (type != null) writer.write(" type=\"").write(type).write('"')
    if (maxLength != null) writer.write(" maxLength=\"").write(maxLength).write('"')
    if (value != null) writer.write(" value=\"").write(value).write('"')
    if (name != null) writer.write(" name=\"").write(name).write('"')
    if (placeholder != null) writer.write(" placeholder=\"").write(placeholder).write('"')
    if (ariaLabel != null) writer.write(" aria-label=\"").write(ariaLabel).write('"')
    if (ariaLabelledBy != null) writer.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("input")
}

@HtmlDsl
inline fun BodyContext.input(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    type: String? = null,
    maxLength: String? = null,
    value: String? = null,
    name: String? = null,
    placeholder: String? = null,
    ariaLabel: String? = null,
    ariaLabelledBy: String? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeTag("input")
    writer.writeStandardAttributes(id, classes, style)
    if (type != null) writer.write(" type=\"").write(type).write('"')
    if (maxLength != null) writer.write(" maxLength=\"").write(maxLength).write('"')
    if (value != null) writer.write(" value=\"").write(value).write('"')
    if (name != null) writer.write(" name=\"").write(name).write('"')
    if (placeholder != null) writer.write(" placeholder=\"").write(placeholder).write('"')
    if (ariaLabel != null) writer.write(" aria-label=\"").write(ariaLabel).write('"')
    if (ariaLabelledBy != null) writer.write(" aria-labelledby=\"").write(ariaLabelledBy).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("input")
}

// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.ScriptContext
import dev.scottpierce.html.writer.writer
import kotlin.Boolean
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.script(
    async: Boolean = false,
    defer: Boolean = false,
    type: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writer {
        this.writeTag("script")
        if (async) this.write(" async")
        if (defer) this.write(" defer")
        if (type != null) this.write(" type=\"").write(type).write('"')
        this.write('>')
        this.indent()
        ScriptContext(this).apply(func)
        this.writeNormalElementEnd("script")
    }
}

@HtmlDsl
inline fun HtmlOutput.script(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    type: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writer {
        this.writeTag("script")
        if (async) this.write(" async")
        if (defer) this.write(" defer")
        if (type != null) this.write(" type=\"").write(type).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        ScriptContext(this).apply(func)
        this.writeNormalElementEnd("script")
    }
}

@HtmlDsl
inline fun HtmlOutput.script(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    type: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writer {
        this.writeTag("script")
        if (async) this.write(" async")
        if (defer) this.write(" defer")
        if (type != null) this.write(" type=\"").write(type).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        ScriptContext(this).apply(func)
        this.writeNormalElementEnd("script")
    }
}

@HtmlDsl
inline fun BaseHtmlContext.script(
    async: Boolean = false,
    defer: Boolean = false,
    type: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writer.writeTag("script")
    if (async) writer.write(" async")
    if (defer) writer.write(" defer")
    if (type != null) writer.write(" type=\"").write(type).write('"')
    writer.write('>')
    writer.indent()
    ScriptContext(writer).apply(func)
    writer.writeNormalElementEnd("script")
}

@HtmlDsl
inline fun BaseHtmlContext.script(
    vararg attrs: Pair<String, String?>,
    async: Boolean = false,
    defer: Boolean = false,
    type: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writer.writeTag("script")
    if (async) writer.write(" async")
    if (defer) writer.write(" defer")
    if (type != null) writer.write(" type=\"").write(type).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    ScriptContext(writer).apply(func)
    writer.writeNormalElementEnd("script")
}

@HtmlDsl
inline fun BaseHtmlContext.script(
    attrs: List<Pair<String, String?>>,
    async: Boolean = false,
    defer: Boolean = false,
    type: String? = null,
    func: ScriptContext.() -> Unit = {}
) {
    writer.writeTag("script")
    if (async) writer.write(" async")
    if (defer) writer.write(" defer")
    if (type != null) writer.write(" type=\"").write(type).write('"')
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    ScriptContext(writer).apply(func)
    writer.writeNormalElementEnd("script")
}

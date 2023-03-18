// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.ColGroupContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.TableContext
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.colgroup(func: ColGroupContext.() -> Unit = {}) {
    writer {
        this.writeTag("colgroup")
        this.write('>')
        this.indent()
        ColGroupContext(this).apply(func)
        this.writeNormalElementEnd("colgroup")
    }
}

@HtmlDsl
inline fun HtmlOutput.colgroup(vararg attrs: Pair<String, String?>, func: ColGroupContext.() -> Unit
        = {}) {
    writer {
        this.writeTag("colgroup")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        ColGroupContext(this).apply(func)
        this.writeNormalElementEnd("colgroup")
    }
}

@HtmlDsl
inline fun HtmlOutput.colgroup(attrs: List<Pair<String, String?>>, func: ColGroupContext.() -> Unit
        = {}) {
    writer {
        this.writeTag("colgroup")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        ColGroupContext(this).apply(func)
        this.writeNormalElementEnd("colgroup")
    }
}

@HtmlDsl
inline fun TableContext.colgroup(func: ColGroupContext.() -> Unit = {}) {
    writer.writeTag("colgroup")
    writer.write('>')
    writer.indent()
    ColGroupContext(writer).apply(func)
    writer.writeNormalElementEnd("colgroup")
}

@HtmlDsl
inline fun TableContext.colgroup(vararg attrs: Pair<String, String?>, func: ColGroupContext.() ->
        Unit = {}) {
    writer.writeTag("colgroup")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    ColGroupContext(writer).apply(func)
    writer.writeNormalElementEnd("colgroup")
}

@HtmlDsl
inline fun TableContext.colgroup(attrs: List<Pair<String, String?>>, func: ColGroupContext.() ->
        Unit = {}) {
    writer.writeTag("colgroup")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    ColGroupContext(writer).apply(func)
    writer.writeNormalElementEnd("colgroup")
}

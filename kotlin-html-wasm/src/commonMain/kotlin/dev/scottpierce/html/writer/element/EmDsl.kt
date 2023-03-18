// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.em(func: BodyContext.() -> Unit = {}) {
    writer {
        this.writeTag("em")
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("em")
    }
}

@HtmlDsl
inline fun HtmlOutput.em(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    writer {
        this.writeTag("em")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("em")
    }
}

@HtmlDsl
inline fun HtmlOutput.em(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    writer {
        this.writeTag("em")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("em")
    }
}

@HtmlDsl
inline fun BodyContext.em(func: BodyContext.() -> Unit = {}) {
    writer.writeTag("em")
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("em")
}

@HtmlDsl
inline fun BodyContext.em(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    writer.writeTag("em")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("em")
}

@HtmlDsl
inline fun BodyContext.em(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    writer.writeTag("em")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("em")
}

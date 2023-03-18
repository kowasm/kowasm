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
inline fun HtmlOutput.b(func: BodyContext.() -> Unit = {}) {
    writer {
        this.writeTag("b")
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("b")
    }
}

@HtmlDsl
inline fun HtmlOutput.b(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    writer {
        this.writeTag("b")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("b")
    }
}

@HtmlDsl
inline fun HtmlOutput.b(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    writer {
        this.writeTag("b")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("b")
    }
}

@HtmlDsl
inline fun BodyContext.b(func: BodyContext.() -> Unit = {}) {
    writer.writeTag("b")
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("b")
}

@HtmlDsl
inline fun BodyContext.b(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit = {}) {
    writer.writeTag("b")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("b")
}

@HtmlDsl
inline fun BodyContext.b(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit = {}) {
    writer.writeTag("b")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("b")
}

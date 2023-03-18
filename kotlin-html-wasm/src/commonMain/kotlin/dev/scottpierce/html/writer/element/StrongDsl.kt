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
inline fun HtmlOutput.strong(func: BodyContext.() -> Unit = {}) {
    writer {
        this.writeTag("strong")
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("strong")
    }
}

@HtmlDsl
inline fun HtmlOutput.strong(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit =
        {}) {
    writer {
        this.writeTag("strong")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("strong")
    }
}

@HtmlDsl
inline fun HtmlOutput.strong(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit =
        {}) {
    writer {
        this.writeTag("strong")
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        BodyContext(this).apply(func)
        this.writeNormalElementEnd("strong")
    }
}

@HtmlDsl
inline fun BodyContext.strong(func: BodyContext.() -> Unit = {}) {
    writer.writeTag("strong")
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("strong")
}

@HtmlDsl
inline fun BodyContext.strong(vararg attrs: Pair<String, String?>, func: BodyContext.() -> Unit =
        {}) {
    writer.writeTag("strong")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("strong")
}

@HtmlDsl
inline fun BodyContext.strong(attrs: List<Pair<String, String?>>, func: BodyContext.() -> Unit =
        {}) {
    writer.writeTag("strong")
    writer.writeAttributes(attrs)
    writer.write('>')
    writer.indent()
    func()
    writer.writeNormalElementEnd("strong")
}

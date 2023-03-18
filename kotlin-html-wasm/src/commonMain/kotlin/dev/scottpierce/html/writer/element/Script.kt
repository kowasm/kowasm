// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.writer
import kotlin.Boolean
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlOutput.script(
    src: String,
    async: Boolean = false,
    defer: Boolean = false
) {
    writer {
        HtmlContext(this).script(src, async, defer)
    }
}

@HtmlDsl
fun HtmlOutput.script(
    vararg attrs: Pair<String, String?>,
    src: String,
    async: Boolean = false,
    defer: Boolean = false
) {
    writer {
        writeTag("script")
        if (async) write(" async")
        if (defer) write(" defer")
        writeAttributes(attrs)
        write(" src=\"").write(src).write("\"></script>")
    }
}

@HtmlDsl
fun HtmlOutput.script(
    attrs: List<Pair<String, String?>>,
    src: String,
    async: Boolean = false,
    defer: Boolean = false
) {
    writer {
        HtmlContext(this).script(attrs, src, async, defer)
    }
}

@HtmlDsl
fun BaseHtmlContext.script(
    src: String,
    async: Boolean = false,
    defer: Boolean = false
) {
    writer.apply {
        writeTag("script")
        if (async) write(" async")
        if (defer) write(" defer")
        write(" src=\"").write(src).write("\"></script>")
    }
}

@HtmlDsl
fun BaseHtmlContext.script(
    vararg attrs: Pair<String, String?>,
    src: String,
    async: Boolean = false,
    defer: Boolean = false
) {
    writer.apply {
        writeTag("script")
        if (async) write(" async")
        if (defer) write(" defer")
        writeAttributes(attrs)
        write(" src=\"").write(src).write("\"></script>")
    }
}

@HtmlDsl
fun BaseHtmlContext.script(
    attrs: List<Pair<String, String?>>,
    src: String,
    async: Boolean = false,
    defer: Boolean = false
) {
    writer.apply {
        writeTag("script")
        if (async) write(" async")
        if (defer) write(" defer")
        writeAttributes(attrs)
        write(" src=\"").write(src).write("\"></script>")
    }
}

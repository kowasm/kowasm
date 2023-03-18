package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

@HtmlDsl
inline fun HtmlOutput.html(
    docType: DocType? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    writer {
        if (docType != null) write("<!DOCTYPE ").write(docType.type!!).write('>')
        this.writeTag("html")
        this.writeStandardAttributes(null, classes, style)
        if (lang != null) this.write(" lang=\"").write(lang).write('"')
        this.write('>')
        this.indent()
        HtmlContext(this).apply(func)
        this.writeNormalElementEnd("html")
        close()
    }
}

@HtmlDsl
inline fun HtmlOutput.html(
    vararg attrs: Pair<String, String?>,
    docType: DocType? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    writer {
        if (docType != null) write("<!DOCTYPE ").write(docType.type!!).write('>')
        this.writeTag("html")
        this.writeStandardAttributes(null, classes, style)
        if (lang != null) this.write(" lang=\"").write(lang).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        HtmlContext(this).apply(func)
        this.writeNormalElementEnd("html")
        close()
    }
}

@HtmlDsl
inline fun HtmlOutput.html(
    attrs: List<Pair<String, String?>>,
    docType: DocType? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    lang: String? = null,
    func: HtmlContext.() -> Unit = {}
) {
    writer {
        if (docType != null) write("<!DOCTYPE ").write(docType.type!!).write('>')
        this.writeTag("html")
        this.writeStandardAttributes(null, classes, style)
        if (lang != null) this.write(" lang=\"").write(lang).write('"')
        this.writeAttributes(attrs)
        this.write('>')
        this.indent()
        HtmlContext(this).apply(func)
        this.writeNormalElementEnd("html")
        close()
    }
}

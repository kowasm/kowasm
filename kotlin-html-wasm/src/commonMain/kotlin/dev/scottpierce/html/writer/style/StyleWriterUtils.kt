package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.HtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.StyleContext
import dev.scottpierce.html.writer.StyleLambda
import dev.scottpierce.html.writer.StyleSheetContext
import dev.scottpierce.html.writer.writer

@HtmlDsl
inline fun HtmlOutput.styleSheet(func: StyleSheetContext.() -> Unit) {
    writer {
        HtmlContext(this).styleSheet(func)
    }
}

@HtmlDsl
inline fun BaseHtmlContext.styleSheet(func: StyleSheetContext.() -> Unit) {
    writer.apply {
        if (!isEmpty) newLine()

        write("<style type=\"text/css\">")
        indent()

        StyleSheetContext(this).apply(func)

        unindent()
        newLine()
        write("</style>")
    }
}

@HtmlDsl
inline fun HtmlOutput.media(
    selector: String,
    func: StyleSheetContext.() -> Unit
) {
    writer {
        StyleSheetContext(this).media(selector, func)
    }
}

@HtmlDsl
inline fun StyleSheetContext.media(selector: String, func: StyleSheetContext.() -> Unit) {
    writer.apply {
        if (!isEmpty) newLine()

        write("@media ").write(selector)
        if (!writer.options.minifyStyles) write(' ')
        write('{')
        indent()

        StyleSheetContext(this).apply(func)

        unindent()
        newLine()
        write('}')
    }
}

@HtmlDsl
inline fun HtmlOutput.style(selector: String, func: StyleLambda) {
    writer {
        StyleSheetContext(this).style(selector, func)
    }
}

@HtmlDsl
inline fun StyleSheetContext.style(selector: String, func: StyleLambda) {
    writer.apply {
        if (!isEmpty) newLine()

        write(selector)
        if (!options.minifyStyles) write(' ')
        write('{')
        indent()

        StyleContext(this).apply(func)

        unindent()
        newLine()
        write('}')
    }
}

fun BaseStyleContext.writeStyleProperty(property: String, value: Any, important: Boolean = false) {
    writer.apply {
        if (!isEmpty) newLine()

        write(property).write(':')
        if (!options.minifyStyles) write(' ')
        write(value.toString())
        if (important) {
            write(" !important")
        }
        write(';')
    }
}

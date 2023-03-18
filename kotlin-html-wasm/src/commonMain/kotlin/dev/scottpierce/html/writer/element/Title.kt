package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.writer

@HtmlDsl
fun HtmlOutput.title(title: String) {
    writer {
        HeadContext(this).title(title)
    }
}

@HtmlDsl
fun HeadContext.title(title: String) {
    writer.newLine()
    writer.write("<title>").write(title).write("</title>")
}

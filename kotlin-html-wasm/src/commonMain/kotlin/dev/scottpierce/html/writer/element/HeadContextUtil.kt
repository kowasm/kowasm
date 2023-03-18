package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.HeadContext
import dev.scottpierce.html.writer.HtmlDsl

@HtmlDsl
fun HeadContext.linkStyleSheet(href: String) {
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"").write(href).write("\">")
}

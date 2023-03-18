package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.StyleSheetContext
import dev.scottpierce.html.writer.insertWriter
import dev.scottpierce.html.writer.style.media
import dev.scottpierce.html.writer.style.styleSheet
import kotlin.jvm.JvmInline

@HtmlDsl
inline fun BaseHtmlContext.insertStyleBuilder(func: StyleBuilderInsertionContext.() -> Unit) {
    styleSheet {
        insertWriter(StyleBuilder.NORMAL.writerId)
        StyleBuilderInsertionContext(this).func()
    }
}

@HtmlDsl
@JvmInline
value class StyleBuilderInsertionContext(private val baseContext: StyleSheetContext) {
    fun media(id: StyleBuilderId, querySelector: String) {
        baseContext.media(querySelector) {
            insertWriter(id.writerId)
        }
    }
}

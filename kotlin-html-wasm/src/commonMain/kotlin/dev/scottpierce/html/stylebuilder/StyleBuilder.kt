package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.HtmlWriterId
import dev.scottpierce.html.writer.StyleLambda
import dev.scottpierce.html.writer.StyleSheetContext
import dev.scottpierce.html.writer.style.style
import kotlin.jvm.JvmInline

object StyleBuilder {
    val NORMAL = StyleBuilderId("StyleBuilder-normal")
}

@JvmInline
value class StyleBuilderId(val writerId: HtmlWriterId)

/**
 * Adds a style to the previously inserted style builder.
 *
 * @param selector the css selector
 */
@HtmlDsl
fun BaseHtmlContext.style(selector: String, func: StyleBuilderLambda) {
    style(selector, false, func)
}

/**
 * Adds a style to the previously inserted style builder.
 *
 * @param selector the css selector
 * @param writeOnce if true the selector will be tracked, and any further write once write requests with
 * this selector will be ignored.
 */
@HtmlDsl
fun BaseHtmlContext.style(selector: String, writeOnce: Boolean, func: StyleBuilderLambda) {
    val rootWriter = writer
    val styleSheetWriter = writer.writer(StyleBuilder.NORMAL.writerId)

    if (writeOnce) {
        val state = rootWriter.styleBuilderWriteOnceState
        if (!state.add(selector)) {
            // The selector has already been written to this style builder.
            return
        }
    }

    StyleSheetContext(styleSheetWriter).style(selector) {
        StyleBuilderContext(
            writer = styleSheetWriter,
            selector = selector,
            rootWriter = rootWriter
        ).func()
    }
}

@HtmlDsl
class StyleBuilderContext(
    override val writer: HtmlWriter,
    val selector: String,
    val rootWriter: HtmlWriter
) : BaseStyleContext {
    @HtmlDsl
    inline fun media(name: StyleBuilderId, func: StyleLambda) {
        StyleSheetContext(rootWriter.writer(name.writerId)).style(selector, func)
    }
}

typealias StyleBuilderLambda = StyleBuilderContext.() -> Unit

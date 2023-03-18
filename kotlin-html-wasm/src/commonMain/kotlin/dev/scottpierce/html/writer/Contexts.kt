package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.style.style
import kotlin.jvm.JvmInline

@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface HtmlWriterContext {
    val writer: HtmlWriter
}

/**
 * A [HtmlWriterContext] applied to all HTML contexts.
 */
@HtmlDsl
interface BaseHtmlContext : HtmlWriterContext

@HtmlDsl
@JvmInline
value class HtmlContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
@JvmInline
value class HeadContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
@JvmInline
value class ScriptContext(override val writer: HtmlWriter) : BaseHtmlContext, HasText

@HtmlDsl
@JvmInline
value class BodyContext(override val writer: HtmlWriter) : BaseHtmlContext, HasText

@HtmlDsl
@JvmInline
value class SelectContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
@JvmInline
value class TableContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
@JvmInline
value class ColGroupContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
@JvmInline
value class ColContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
@JvmInline
value class TableRowContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
@JvmInline
value class UlContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
@JvmInline
value class VideoContext(override val writer: HtmlWriter) : BaseHtmlContext

@HtmlDsl
interface HasText : HtmlWriterContext {
    operator fun CharSequence.unaryPlus() {
        writer.apply {
            newLine()
            write(this@unaryPlus)
        }
    }
}

@HtmlDsl
@JvmInline
value class StyleSheetContext(override val writer: HtmlWriter) : HtmlWriterContext {
    inline operator fun String.invoke(func: StyleLambda) = style(this, func)
}

/**
 * A [HtmlWriterContext] applied to all style contexts.
 */
@HtmlDsl
interface BaseStyleContext : HtmlWriterContext

@HtmlDsl
@JvmInline
value class InlineStyleContext(override val writer: HtmlWriter) : BaseStyleContext

@HtmlDsl
@JvmInline
value class StyleContext(override val writer: HtmlWriter) : BaseStyleContext

typealias InlineStyleLambda = InlineStyleContext.() -> Unit

typealias StyleLambda = StyleContext.() -> Unit

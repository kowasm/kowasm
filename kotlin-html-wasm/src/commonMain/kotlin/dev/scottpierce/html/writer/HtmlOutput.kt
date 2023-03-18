package dev.scottpierce.html.writer

import dev.scottpierce.html.writer.element.DocType
import dev.scottpierce.html.writer.element.html

@HtmlDsl
interface HtmlOutput {
    val options: WriteOptions
    fun write(c: Char)
    fun write(code: CharSequence)
}

class StringHtmlOutput(
    override val options: WriteOptions = WriteOptions.default,
    initialCapacity: Int = 128
) : HtmlOutput {
    private val sb = StringBuilder(initialCapacity)

    /**
     * A [CharSequence] of everything that's been written to this [HtmlOutput].
     *
     * This is exposed to save the underlying data from having to be converted to a [String], especially since the
     * html written can be quite large.
     */
    val charSequence: CharSequence
        get() = sb

    override fun write(c: Char) {
        sb.append(c)
    }

    override fun write(code: CharSequence) {
        sb.append(code)
    }

    override fun toString(): String = sb.toString()
}

fun createHtml(
    options: WriteOptions = WriteOptions.default,
    func: HtmlContext.() -> Unit
): String {
    return StringHtmlOutput(options).apply {
        html(DocType.Html) {
            func()
        }
    }.toString()
}

fun createInnerHtml(
    options: WriteOptions = WriteOptions.default,
    func: BodyContext.() -> Unit
): String {
    return StringHtmlOutput(options).apply {
        writer {
            BodyContext(this).apply(func)
        }
    }.toString()
}


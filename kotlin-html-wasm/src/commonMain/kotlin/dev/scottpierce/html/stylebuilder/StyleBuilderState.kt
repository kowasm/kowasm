package dev.scottpierce.html.stylebuilder

import dev.scottpierce.html.writer.HtmlWriter
import dev.scottpierce.html.writer.getStateOrPut

internal const val STATE_WRITE_ONCE = "StyleBuilder-WriteOnce"

@Suppress("UNCHECKED_CAST")
internal val HtmlWriter.styleBuilderWriteOnceState: MutableSet<String>
    get() = getStateOrPut(STATE_WRITE_ONCE) { mutableSetOf<String>() } as MutableSet<String>

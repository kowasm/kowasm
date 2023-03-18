// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.HtmlDsl
import dev.scottpierce.html.writer.HtmlOutput
import dev.scottpierce.html.writer.InlineStyleLambda
import dev.scottpierce.html.writer.writer
import kotlin.Pair
import kotlin.String
import kotlin.collections.List

@HtmlDsl
fun HtmlOutput.hr(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer {
        this.writeVoidElement("hr", id, classes, style)
    }
}

@HtmlDsl
fun HtmlOutput.hr(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer {
        this.writeVoidElement("hr", id, classes, style, attrs)
    }
}

@HtmlDsl
fun HtmlOutput.hr(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer {
        this.writeVoidElement("hr", id, classes, style, attrs)
    }
}

@HtmlDsl
fun BodyContext.hr(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer.writeVoidElement("hr", id, classes, style)
}

@HtmlDsl
fun BodyContext.hr(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer.writeVoidElement("hr", id, classes, style, attrs)
}

@HtmlDsl
fun BodyContext.hr(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer.writeVoidElement("hr", id, classes, style, attrs)
}

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
fun HtmlOutput.br(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer {
        this.writeVoidElement("br", id, classes, style)
    }
}

@HtmlDsl
fun HtmlOutput.br(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer {
        this.writeVoidElement("br", id, classes, style, attrs)
    }
}

@HtmlDsl
fun HtmlOutput.br(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer {
        this.writeVoidElement("br", id, classes, style, attrs)
    }
}

@HtmlDsl
fun BodyContext.br(
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer.writeVoidElement("br", id, classes, style)
}

@HtmlDsl
fun BodyContext.br(
    vararg attrs: Pair<String, String?>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer.writeVoidElement("br", id, classes, style, attrs)
}

@HtmlDsl
fun BodyContext.br(
    attrs: List<Pair<String, String?>>,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer.writeVoidElement("br", id, classes, style, attrs)
}

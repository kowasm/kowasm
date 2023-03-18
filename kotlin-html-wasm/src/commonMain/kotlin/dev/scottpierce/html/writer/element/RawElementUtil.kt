package dev.scottpierce.html.writer.element

import dev.scottpierce.html.writer.BaseHtmlContext
import dev.scottpierce.html.writer.BodyContext
import dev.scottpierce.html.writer.InlineStyleLambda

inline fun BodyContext.rawElement(
    tag: String,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart(tag, id, classes, style)
    func()
    writer.writeNormalElementEnd(tag)
}

inline fun BodyContext.rawElement(
    vararg attrs: Pair<String, String?>,
    tag: String,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: BodyContext.() -> Unit = {}
) {
    writer.writeNormalElementStart(tag, id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd(tag)
}

inline fun <T : BaseHtmlContext> T.rawElement(
    attrs: Array<out Pair<String, String?>>,
    tag: String,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: T.() -> Unit = {}
) {
    writer.writeNormalElementStart(tag, id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd(tag)
}

inline fun <T : BaseHtmlContext> T.rawElement(
    attrs: List<Pair<String, String?>>,
    tag: String,
    id: String? = null,
    classes: String? = null,
    noinline style: InlineStyleLambda? = null,
    func: T.() -> Unit = {}
) {
    writer.writeNormalElementStart(tag, id, classes, style, attrs)
    func()
    writer.writeNormalElementEnd(tag)
}

fun BodyContext.rawVoidElement(
    tag: String,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer.writeVoidElement(tag, id, classes, style)
}

fun BodyContext.rawVoidElement(
    vararg attrs: Pair<String, String?>,
    tag: String,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer.writeVoidElement(tag, id, classes, style, attrs)
}

fun BodyContext.rawVoidElement(
    attrs: List<Pair<String, String?>>,
    tag: String,
    id: String? = null,
    classes: String? = null,
    style: InlineStyleLambda? = null
) {
    writer.writeVoidElement(tag, id, classes, style, attrs)
}

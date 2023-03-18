// This file was generated using the `kotlin-html-generator` module. Instead of modifying it, modify the
// `html-builder-generator` and run it again.
@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import dev.scottpierce.html.writer.BaseStyleContext
import dev.scottpierce.html.writer.InlineStyleContext
import dev.scottpierce.html.writer.StyleContext
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress

fun BaseStyleContext.backgroundImage(url: String, important: Boolean = false) {
    writeStyleProperty("background-image", """url('$url')""", important)
}

fun BaseStyleContext.backgroundImage(image: BackgroundImage, important: Boolean = false) {
    writeStyleProperty("background-image", image, important)
}

fun BaseStyleContext.backgroundImage(
    image: BackgroundImage,
    vararg images: BackgroundImage,
    important: Boolean = false
) {
    writeStyleProperty("background-image",
            """$image${if (images.isEmpty()) "" else images.joinToString(prefix = ", ")}""",
            important)
}

fun StyleContext.backgroundImage(url: String, important: Boolean = false) {
    writeStyleProperty("background-image", """url('$url')""", important)
}

fun StyleContext.backgroundImage(image: BackgroundImage, important: Boolean = false) {
    writeStyleProperty("background-image", image, important)
}

fun StyleContext.backgroundImage(
    image: BackgroundImage,
    vararg images: BackgroundImage,
    important: Boolean = false
) {
    writeStyleProperty("background-image",
            """$image${if (images.isEmpty()) "" else images.joinToString(prefix = ", ")}""",
            important)
}

fun InlineStyleContext.backgroundImage(url: String, important: Boolean = false) {
    writeStyleProperty("background-image", """url('$url')""", important)
}

fun InlineStyleContext.backgroundImage(image: BackgroundImage, important: Boolean = false) {
    writeStyleProperty("background-image", image, important)
}

fun InlineStyleContext.backgroundImage(
    image: BackgroundImage,
    vararg images: BackgroundImage,
    important: Boolean = false
) {
    writeStyleProperty("background-image",
            """$image${if (images.isEmpty()) "" else images.joinToString(prefix = ", ")}""",
            important)
}

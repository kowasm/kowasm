@file:Suppress("FunctionName")

package dev.scottpierce.html.writer.style

import kotlin.jvm.JvmInline

interface BoxShadow {
    companion object {
        val NONE: BoxShadow = BoxShadowString("none")
        val INITIAL: BoxShadow = BoxShadowString("initial")
        val INHERIT: BoxShadow = BoxShadowString("inherit")
    }
}

@JvmInline
private value class BoxShadowString(val styleString: String) : BoxShadow {
    override fun toString(): String = styleString
}

fun BoxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    color: Color? = null,
    inset: Boolean = false
): BoxShadow = BoxShadowString("$hOffset $vOffset $color${if (inset) " inset" else ""}")

fun BoxShadow(
    hOffset: Dimension,
    vOffset: Dimension,
    blur: Dimension,
    spread: Dimension? = null,
    color: Color? = null,
    inset: Boolean = false
): BoxShadow {
    return BoxShadowString(
        "$hOffset $vOffset $blur" +
            (if (spread == null) "" else " $spread") +
            (if (color == null) "" else " $color") +
            (if (inset) " inset" else "")
    )
}

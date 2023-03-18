@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package dev.scottpierce.html.writer.style

import kotlin.jvm.JvmInline

enum class CssValue(val value: String) {
    INITIAL("initial"),
    INHERIT("inherit");

    override fun toString(): String = value
}

interface BackgroundImage {
    companion object {
        val NONE: BackgroundImage = BackgroundImageString("none")
        val INITIAL: BackgroundImage = BackgroundImageString("initial")
        val INHERIT: BackgroundImage = BackgroundImageString("inherit")

        fun url(url: String): BackgroundImage = BackgroundImageString("url('$url')")

        fun linearGradient(color1: Color, color2: Color, vararg colors: Color): BackgroundImage {
            return linearGradient(
                direction = null,
                color1 = color1,
                color2 = color2,
                colors = colors
            )
        }

        fun linearGradient(angle: Number, color1: Color, color2: Color, vararg colors: Color): BackgroundImage {
            return linearGradient(
                direction = "${angle}deg",
                color1 = color1,
                color2 = color2,
                colors = colors
            )
        }

        /**
         * If someone wants to take a stab at creating strongly typed versions of the other gradients, PRs are welcome.
         */
        fun customGradient(value: String): BackgroundImage {
            return BackgroundImageString(value)
        }

        private fun linearGradient(
            direction: String? = null,
            color1: Color,
            color2: Color,
            colors: Array<out Color>
        ): BackgroundImage {
            val directionValue = if (direction == null) "" else "$direction,"

            val extraColors: String = if (colors.isEmpty()) {
                colors.joinToString(prefix = ",", separator = ",")
            } else ""

            return BackgroundImageString("linear-gradient($directionValue$color1,$color2$extraColors)")
        }
    }
}

@JvmInline
internal value class BackgroundImageString(val value: String) : BackgroundImage

enum class FloatDirection(
    val value: String
) {
    NONE("none"),

    LEFT("left"),

    RIGHT("right"),

    INITIAL("initial"),

    INHERIT("inherit");

    override fun toString() = value
}

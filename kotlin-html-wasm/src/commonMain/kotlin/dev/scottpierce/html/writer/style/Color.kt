@file:Suppress("EXPERIMENTAL_FEATURE_WARNING", "FunctionName", "unused")

package dev.scottpierce.html.writer.style

import kotlin.jvm.JvmInline

fun Color(r: Int, g: Int, b: Int): Color = ColorString("rgb($r,$g,$b)")
fun Color(r: Int, g: Int, b: Int, a: Number): Color = ColorString("rgba($r,$g,$b,$a)")
fun Color(hexString: String): Color = ColorString(if (hexString.first() == '#') hexString else "#$hexString")

interface Color {
    companion object {
        val WHITE: Color = ColorString("#ffffff")
        val BLACK: Color = ColorString("#000000")
        val TRANSPARENT: Color = ColorString("transparent")
        val INHERIT: Color = ColorString("inherit")
        val INITIAL: Color = ColorString("initial")

        fun toHexString(red: Int, green: Int, blue: Int, alpha: Float = 1f): String {
            val hexR = red.twoDigitHex()
            val hexG = green.twoDigitHex()
            val hexB = blue.twoDigitHex()
            val hexA = if (alpha == 1f) null else (alpha * (255 + 0.5f)).toInt().twoDigitHex()

            return "#$hexR$hexG$hexB${hexA.orEmpty()}"
        }

        internal fun colorString(r: Int, g: Int, b: Int): String = "rgb($r,$g,$b)"
        internal fun colorString(r: Int, g: Int, b: Int, a: Number): String = "rgba($r,$g,$b,$a)"
        internal fun colorString(hexString: String): String =
            if (hexString.first() == '#') hexString else "#$hexString"
    }
}

@JvmInline
internal value class ColorString(val cssValue: String) : Color {
    override fun toString() = cssValue
}

internal fun Int.twoDigitHex(): String {
    val firstDigit: Char = (this and 0b1111).toChar()
    val secondDigit: Char = (this and 0b11110000).shr(4).toChar()

    return "${secondDigit.encodedHexToChar()}${firstDigit.encodedHexToChar()}"
}

private fun Char.encodedHexToChar(): Char = when (this) {
    0x0.toChar() -> '0'
    0x1.toChar() -> '1'
    0x2.toChar() -> '2'
    0x3.toChar() -> '3'
    0x4.toChar() -> '4'
    0x5.toChar() -> '5'
    0x6.toChar() -> '6'
    0x7.toChar() -> '7'
    0x8.toChar() -> '8'
    0x9.toChar() -> '9'
    0xA.toChar() -> 'A'
    0xB.toChar() -> 'B'
    0xC.toChar() -> 'C'
    0xD.toChar() -> 'D'
    0xE.toChar() -> 'E'
    0xF.toChar() -> 'F'
    else -> throw UnsupportedOperationException()
}

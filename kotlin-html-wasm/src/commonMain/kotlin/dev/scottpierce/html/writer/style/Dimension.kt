@file:Suppress("unused")

package dev.scottpierce.html.writer.style

import kotlin.jvm.JvmInline

interface Dimension {
    companion object {
        val ZERO: MeasurableDimension = StringMeasurableDimension("0")
        val AUTO: Dimension = StringDimension("auto")
        val INHERIT: Dimension = StringDimension("inherit")
    }
}

interface MeasurableDimension : Dimension

@JvmInline
private value class StringDimension(val value: String) : Dimension {
    override fun toString(): String = value
}

@JvmInline
private value class StringMeasurableDimension(val value: String) : MeasurableDimension {
    override fun toString(): String = value
}

enum class DimensionUnit(private val value: String) {
    // Relative units
    PX("px"),
    EM("em"),
    EX("ex"),
    PERCENT("%"),
    REM("rem"),

    // Absolute units
    INCH("in"),
    CM("cm"),
    MM("mm"),
    PT("pt"),
    PC("pc"),
    ;

    override fun toString() = value
}

private fun dimension(value: Int, unit: DimensionUnit): MeasurableDimension {
    return if (value == 0) {
        Dimension.ZERO
    } else {
        StringMeasurableDimension("$value$unit")
    }
}

private fun dimension(value: Float, unit: DimensionUnit): MeasurableDimension {
    return if (value == 0f) {
        Dimension.ZERO
    } else {
        StringMeasurableDimension("$value$unit")
    }
}

private fun dimension(value: Double, unit: DimensionUnit): MeasurableDimension {
    return if (value == 0.0) {
        Dimension.ZERO
    } else {
        StringMeasurableDimension("$value$unit")
    }
}

val Int.px: MeasurableDimension
    get() = dimension(this, DimensionUnit.PX)

val Int.em: MeasurableDimension
    get() = dimension(this, DimensionUnit.EM)

val Int.ex: MeasurableDimension
    get() = dimension(this, DimensionUnit.EX)

val Int.percent: MeasurableDimension
    get() = dimension(this, DimensionUnit.PERCENT)

val Int.rem: MeasurableDimension
    get() = dimension(this, DimensionUnit.REM)

val Float.px: MeasurableDimension
    get() = dimension(this, DimensionUnit.PX)

val Float.em: MeasurableDimension
    get() = dimension(this, DimensionUnit.EM)

val Float.ex: MeasurableDimension
    get() = dimension(this, DimensionUnit.EX)

val Float.percent: MeasurableDimension
    get() = dimension(this, DimensionUnit.PERCENT)

val Float.rem: MeasurableDimension
    get() = dimension(this, DimensionUnit.REM)

val Double.px: MeasurableDimension
    get() = dimension(this, DimensionUnit.PX)

val Double.em: MeasurableDimension
    get() = dimension(this, DimensionUnit.EM)

val Double.ex: MeasurableDimension
    get() = dimension(this, DimensionUnit.EX)

val Double.percent: MeasurableDimension
    get() = dimension(this, DimensionUnit.PERCENT)

val Double.rem: MeasurableDimension
    get() = dimension(this, DimensionUnit.REM)

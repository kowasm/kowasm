/*
 * Copyright 2019-2022 JetBrains s.r.o. and contributors.
 * Use of this source code is governed by the Apache 2.0 License that can be found in the LICENSE.txt file.
 */

package kotlinx.datetime

import kotlinx.datetime.internal.NANOS_PER_DAY
import kotlinx.datetime.internal.NANOS_PER_ONE
import kotlinx.datetime.internal.SECONDS_PER_DAY
import kotlinx.datetime.internal.multiplyAddAndDivide


/**
 * The representation of a specific civil date and time without a reference to a particular time zone.
 *
 * This class does not describe specific *moments in time*, which are represented as [Instant] values.
 * Instead, its instances can be thought of as clock readings, something that an observer in a particular time zone
 * could witness.
 * For example, `2020-08-30T18:43` is not a *moment in time*, since someone in Berlin and someone in Tokyo would witness
 * this on their clocks at different times.
 *
 * The main purpose of this class is to provide human-readable representations of [Instant] values, or to transfer them
 * as data.
 *
 * The arithmetic on [LocalDateTime] values is not provided, since without accounting for the time zone transitions it may give misleading results.
 */
public expect class LocalDateTime : Comparable<LocalDateTime> {
    public companion object {

        /**
         * Parses a string that represents a date/time value in ISO-8601 format including date and time components
         * but without any time zone component and returns the parsed [LocalDateTime] value.
         *
         * Examples of date/time in ISO-8601 format:
         * - `2020-08-30T18:43`
         * - `2020-08-30T18:43:00`
         * - `2020-08-30T18:43:00.500`
         * - `2020-08-30T18:43:00.123456789`
         *
         * @throws IllegalArgumentException if the text cannot be parsed or the boundaries of [LocalDateTime] are
         * exceeded.
         */
        public fun parse(isoString: String): LocalDateTime

        internal val MIN: LocalDateTime
        internal val MAX: LocalDateTime
    }

    /**
     * Constructs a [LocalDateTime] instance from the given date and time components.
     *
     * The components [monthNumber] and [dayOfMonth] are 1-based.
     *
     * The supported ranges of components:
     * - [year] the range is platform dependent, but at least is enough to represent dates of all instants between
     *          [Instant.DISTANT_PAST] and [Instant.DISTANT_FUTURE]
     * - [monthNumber] `1..12`
     * - [dayOfMonth] `1..31`, the upper bound can be less, depending on the month
     * - [hour] `0..23`
     * - [minute] `0..59`
     * - [second] `0..59`
     * - [nanosecond] `0..999_999_999`
     *
     * @throws IllegalArgumentException if any parameter is out of range, or if [dayOfMonth] is invalid for the given [monthNumber] and
     * [year].
     */
    public constructor(year: Int, monthNumber: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int = 0, nanosecond: Int = 0)

    /**
     * Constructs a [LocalDateTime] instance from the given date and time components.
     *
     * The supported ranges of components:
     * - [year] the range is platform dependent, but at least is enough to represent dates of all instants between
     *          [Instant.DISTANT_PAST] and [Instant.DISTANT_FUTURE]
     * - [month] all values of the [Month] enum
     * - [dayOfMonth] `1..31`, the upper bound can be less, depending on the month
     * - [hour] `0..23`
     * - [minute] `0..59`
     * - [second] `0..59`
     * - [nanosecond] `0..999_999_999`
     *
     * @throws IllegalArgumentException if any parameter is out of range, or if [dayOfMonth] is invalid for the given [month] and
     * [year].
     */
    public constructor(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int = 0, nanosecond: Int = 0)

    /**
     * Constructs a [LocalDateTime] instance by combining the given [date] and [time] parts.
     */
    public constructor(date: LocalDate, time: LocalTime)

    /** Returns the year component of the date. */
    public val year: Int
    /** Returns the number-of-month (1..12) component of the date. */
    public val monthNumber: Int
    /** Returns the month ([Month]) component of the date. */
    public val month: Month
    /** Returns the day-of-month component of the date. */
    public val dayOfMonth: Int
    /** Returns the day-of-week component of the date. */
    public val dayOfWeek: DayOfWeek
    /** Returns the day-of-year component of the date. */
    public val dayOfYear: Int
    /** Returns the hour-of-day time component of this date/time value. */
    public val hour: Int
    /** Returns the minute-of-hour time component of this date/time value. */
    public val minute: Int
    /** Returns the second-of-minute time component of this date/time value. */
    public val second: Int
    /** Returns the nanosecond-of-second time component of this date/time value. */
    public val nanosecond: Int

    /** Returns the date part of this date/time value. */
    public val date: LocalDate

    /** Returns the time part of this date/time value. */
    public val time: LocalTime

    /**
     * Compares `this` date/time value with the [other] date/time value.
     * Returns zero if this value is equal to the other,
     * a negative number if this value represents earlier civil time than the other,
     * and a positive number if this value represents later civil time than the other.
     */
    // TODO: add a note about pitfalls of comparing localdatetimes falling in the Autumn transition
    public override operator fun compareTo(other: LocalDateTime): Int

    /**
     * Converts this date/time value to the ISO-8601 string representation.
     *
     * @see LocalDateTime.parse
     */
    public override fun toString(): String
}

/**
 * Converts this string representing a date/time value in ISO-8601 format including date and time components
 * but without any time zone component to a [LocalDateTime] value.
 *
 * See [LocalDateTime.parse] for examples of date/time string representations.
 *
 * @throws IllegalArgumentException if the text cannot be parsed or the boundaries of [LocalDateTime] are exceeded.
 */
public fun String.toLocalDateTime(): LocalDateTime = LocalDateTime.parse(this)

// This is a function and not a value due to https://github.com/Kotlin/kotlinx-datetime/issues/5
// org.threeten.bp.format.DateTimeFormatter#ISO_LOCAL_DATE_TIME
internal val localDateTimeParser: Parser<LocalDateTime>
    get() = localDateParser
        .chainIgnoring(concreteCharParser('T').or(concreteCharParser('t')))
        .chain(localTimeParser)
        .map { (date, time) ->
            LocalDateTime(date, time)
        }

public actual class LocalDateTime
public actual constructor(public actual val date: LocalDate, public actual val time: LocalTime) : Comparable<LocalDateTime> {
    public actual companion object {
        public actual fun parse(isoString: String): LocalDateTime =
            localDateTimeParser.parse(isoString)

        internal actual val MIN: LocalDateTime = LocalDateTime(LocalDate.MIN, LocalTime.MIN)
        internal actual val MAX: LocalDateTime = LocalDateTime(LocalDate.MAX, LocalTime.MAX)
    }

    public actual constructor(year: Int, monthNumber: Int, dayOfMonth: Int, hour: Int, minute: Int, second: Int, nanosecond: Int) :
            this(LocalDate(year, monthNumber, dayOfMonth), LocalTime.of(hour, minute, second, nanosecond))

    public actual constructor(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int, second: Int, nanosecond: Int) :
            this(LocalDate(year, month, dayOfMonth), LocalTime.of(hour, minute, second, nanosecond))

    public actual val year: Int get() = date.year
    public actual val monthNumber: Int get() = date.monthNumber
    public actual val month: Month get() = date.month
    public actual val dayOfMonth: Int get() = date.dayOfMonth
    public actual val dayOfWeek: DayOfWeek get() = date.dayOfWeek
    public actual val dayOfYear: Int get() = date.dayOfYear
    public actual val hour: Int get() = time.hour
    public actual val minute: Int get() = time.minute
    public actual val second: Int get() = time.second
    public actual val nanosecond: Int get() = time.nanosecond

    // Several times faster than using `compareBy`
    actual override fun compareTo(other: LocalDateTime): Int {
        val d = date.compareTo(other.date)
        if (d != 0) {
            return d
        }
        return time.compareTo(other.time)
    }

    override fun equals(other: Any?): Boolean =
        this === other || (other is LocalDateTime && compareTo(other) == 0)

    // org.threeten.bp.LocalDateTime#hashCode
    override fun hashCode(): Int {
        return date.hashCode() xor time.hashCode()
    }

    // org.threeten.bp.LocalDateTime#toString
    actual override fun toString(): String = date.toString() + 'T' + time.toString()

    // org.threeten.bp.chrono.ChronoLocalDateTime#toEpochSecond
    internal fun toEpochSecond(offset: UtcOffset): Long {
        val epochDay = date.toEpochDays().toLong()
        var secs: Long = epochDay * 86400 + time.toSecondOfDay()
        secs -= offset.totalSeconds
        return secs
    }

    /**
     * @throws IllegalArgumentException if the result exceeds the boundaries
     * @throws ArithmeticException if arithmetic overflow occurs
     */
    internal fun plus(value: Int, unit: DateTimeUnit.DateBased): LocalDateTime =
        LocalDateTime(date.plus(value, unit), time)
}

// org.threeten.bp.LocalDateTime#until
internal fun LocalDateTime.until(other: LocalDateTime, unit: DateTimeUnit.DateBased): Int {
    var endDate: LocalDate = other.date
    if (endDate > date && other.time < time) {
        endDate = endDate.plusDays(-1) // won't throw: endDate - date >= 1
    } else if (endDate < date && other.time > time) {
        endDate = endDate.plusDays(1) // won't throw: date - endDate >= 1
    }
    return when (unit) {
        is DateTimeUnit.MonthBased -> date.monthsUntil(endDate) / unit.months
        is DateTimeUnit.DayBased -> date.daysUntil(endDate) / unit.days
    }
}

// org.threeten.bp.LocalDateTime#until
/** @throws ArithmeticException on arithmetic overflow. */
internal fun LocalDateTime.until(other: LocalDateTime, unit: DateTimeUnit.TimeBased): Long {
    val daysUntil = date.daysUntil(other.date)
    val timeUntil: Long = other.time.toNanosecondOfDay() - time.toNanosecondOfDay()
    return multiplyAddAndDivide(daysUntil.toLong(), NANOS_PER_DAY, timeUntil, unit.nanoseconds)
}

// org.threeten.bp.LocalDateTime#plusWithOverflow
/**
 * @throws IllegalArgumentException if the result exceeds the boundaries
 * @throws ArithmeticException if arithmetic overflow occurs
 */
internal fun LocalDateTime.plusSeconds(seconds: Int): LocalDateTime
{
    if (seconds == 0) {
        return this
    }
    val currentNanoOfDay = time.toNanosecondOfDay() // at most a day
    val totalNanos: Long = seconds % SECONDS_PER_DAY * NANOS_PER_ONE.toLong() + // at most a day
            currentNanoOfDay
    val totalDays = seconds / SECONDS_PER_DAY + // max/24*60*60 < max * 0.000012
            totalNanos.floorDiv(NANOS_PER_DAY) // max 2 days
    val newNanoOfDay: Long = totalNanos.mod(NANOS_PER_DAY)
    val newTime: LocalTime = if (newNanoOfDay == currentNanoOfDay) time else LocalTime.ofNanoOfDay(newNanoOfDay)
    return LocalDateTime(date.plusDays(totalDays.toInt()), newTime)
}

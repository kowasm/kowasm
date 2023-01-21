/*
 * Copyright 2019-2022 JetBrains s.r.o. and contributors.
 * Use of this source code is governed by the Apache 2.0 License that can be found in the LICENSE.txt file.
 */

package kotlinx.datetime

import kotlinx.datetime.internal.*
import kotlinx.datetime.internal.MILLIS_PER_ONE
import kotlinx.datetime.internal.NANOS_PER_HOUR
import kotlinx.datetime.internal.NANOS_PER_MILLI
import kotlinx.datetime.internal.NANOS_PER_MINUTE
import kotlinx.datetime.internal.NANOS_PER_ONE
import kotlinx.datetime.internal.SECONDS_PER_DAY
import kotlinx.datetime.internal.SECONDS_PER_HOUR
import kotlinx.datetime.internal.SECONDS_PER_MINUTE


/**
 * The time part of [LocalDateTime].
 *
 * This class represents time-of-day without a referencing a specific date.
 * To reconstruct a full [LocalDateTime], representing civil date and time, [LocalTime] needs to be
 * combined with [LocalDate] via [LocalDate.atTime] or [LocalTime.atDate].
 *
 * Also, [LocalTime] does not reference a particular time zone.
 * Therefore, even on the same date, [LocalTime] denotes different moments of time.
 * For example, `18:43` happens at different moments in Berlin and in Tokyo.
 *
 * The arithmetic on [LocalTime] values is not provided, since without accounting for the time zone
 * transitions it may give misleading results.
 */
public expect class LocalTime : Comparable<LocalTime> {
    public companion object {

        /**
         * Parses a string that represents a time value in ISO-8601 and returns the parsed [LocalTime] value.
         *
         * Examples of time in ISO-8601 format:
         * - `18:43`
         * - `18:43:00`
         * - `18:43:00.500`
         * - `18:43:00.123456789`
         *
         * @throws IllegalArgumentException if the text cannot be parsed or the boundaries of [LocalTime] are
         * exceeded.
         */
        public fun parse(isoString: String): LocalTime

        /**
         * Constructs a [LocalTime] that represents the specified number of seconds since the start of a calendar day.
         * The fractional parts of the second will be zero.
         *
         * @throws IllegalArgumentException if [secondOfDay] is outside the `0 until 86400` range,
         * with 86400 being the number of seconds in a calendar day.
         *
         * @see LocalTime.toSecondOfDay
         * @see LocalTime.fromMillisecondOfDay
         * @see LocalTime.fromNanosecondOfDay
         */
        public fun fromSecondOfDay(secondOfDay: Int): LocalTime

        /**
         * Constructs a [LocalTime] that represents the specified number of milliseconds since the start of
         * a calendar day.
         * The sub-millisecond parts of the `LocalTime` will be zero.
         *
         * @throws IllegalArgumentException if [millisecondOfDay] is outside the `0 until 86400 * 1_000` range,
         * with 86400 being the number of seconds in a calendar day.
         *
         * @see LocalTime.fromSecondOfDay
         * @see LocalTime.toMillisecondOfDay
         * @see LocalTime.fromNanosecondOfDay
         */
        public fun fromMillisecondOfDay(millisecondOfDay: Int): LocalTime

        /**
         * Constructs a [LocalTime] that represents the specified number of nanoseconds since the start of
         * a calendar day.
         *
         * @throws IllegalArgumentException if [nanosecondOfDay] is outside the `0 until 86400 * 1_000_000_000` range,
         * with 86400 being the number of seconds in a calendar day.
         *
         * @see LocalTime.fromSecondOfDay
         * @see LocalTime.fromMillisecondOfDay
         * @see LocalTime.toNanosecondOfDay
         */
        public fun fromNanosecondOfDay(nanosecondOfDay: Long): LocalTime

        internal val MIN: LocalTime
        internal val MAX: LocalTime
    }

    /**
     * Constructs a [LocalTime] instance from the given time components.
     *
     * The supported ranges of components:
     * - [hour] `0..23`
     * - [minute] `0..59`
     * - [second] `0..59`
     * - [nanosecond] `0..999_999_999`
     *
     * @throws IllegalArgumentException if any parameter is out of range.
     */
    public constructor(hour: Int, minute: Int, second: Int = 0, nanosecond: Int = 0)

    /** Returns the hour-of-day time component of this time value. */
    public val hour: Int
    /** Returns the minute-of-hour time component of this time value. */
    public val minute: Int
    /** Returns the second-of-minute time component of this time value. */
    public val second: Int
    /** Returns the nanosecond-of-second time component of this time value. */
    public val nanosecond: Int

    /** Returns the time as a second of a day, in `0 until 24 * 60 * 60`. */
    public fun toSecondOfDay(): Int

    /** Returns the time as a millisecond of a day, in `0 until 24 * 60 * 60 * 1_000`. */
    public fun toMillisecondOfDay(): Int

    /** Returns the time as a nanosecond of a day, in `0 until 24 * 60 * 60 * 1_000_000_000`. */
    public fun toNanosecondOfDay(): Long

    /**
     * Compares `this` time value with the [other] time value.
     * Returns zero if this value is equal to the other, a negative number if this value occurs earlier
     * in the course of a typical day than the other, and a positive number if this value occurs
     * later in the course of a typical day than the other.
     *
     * Note that, on days when there is a time overlap (for example, due to the daylight saving time
     * transitions in autumn), a "lesser" wall-clock reading can, in fact, happen later than the
     * "greater" one.
     */
    public override operator fun compareTo(other: LocalTime): Int

    /**
     * Converts this time value to the ISO-8601 string representation.
     *
     * @see LocalDateTime.parse
     */
    public override fun toString(): String
}

/**
 * Converts this string representing a time value in ISO-8601 format to a [LocalTime] value.
 *
 * See [LocalTime.parse] for examples of time string representations.
 *
 * @throws IllegalArgumentException if the text cannot be parsed or the boundaries of [LocalTime] are exceeded.
 */
public fun String.toLocalTime(): LocalTime = LocalTime.parse(this)

/**
 * Combines this time's components with the specified date components into a [LocalDateTime] value.
 */
public fun LocalTime.atDate(year: Int, monthNumber: Int, dayOfMonth: Int = 0): LocalDateTime =
    LocalDateTime(year, monthNumber, dayOfMonth, hour, minute, second, nanosecond)

/**
 * Combines this time's components with the specified date components into a [LocalDateTime] value.
 */
public fun LocalTime.atDate(year: Int, month: Month, dayOfMonth: Int = 0): LocalDateTime =
    LocalDateTime(year, month, dayOfMonth, hour, minute, second, nanosecond)

/**
 * Combines this time's components with the specified [LocalDate] components into a [LocalDateTime] value.
 */
public fun LocalTime.atDate(date: LocalDate): LocalDateTime = LocalDateTime(date, this)

// This is a function and not a value due to https://github.com/Kotlin/kotlinx-datetime/issues/5
// org.threeten.bp.format.DateTimeFormatter#ISO_LOCAL_TIME
internal val localTimeParser: Parser<LocalTime>
    get() = intParser(2, 2) // hour
        .chainIgnoring(concreteCharParser(':'))
        .chain(intParser(2, 2)) // minute
        .chain(optional(
            concreteCharParser(':')
                .chainSkipping(intParser(2, 2)) // second
                .chain(optional(
                    concreteCharParser('.')
                        .chainSkipping(fractionParser(0, 9, 9))
                ))
        ))
        .map {
            val (hourMinute, secNano) = it
            val (hour, minute) = hourMinute
            val (sec, nanosecond) = when (secNano) {
                null -> Pair(0, 0)
                else -> Pair(secNano.first, secNano.second ?: 0)
            }
            try {
                LocalTime.of(hour, minute, sec, nanosecond)
            } catch (e: IllegalArgumentException) {
                throw DateTimeFormatException(e)
            }
        }

public actual class LocalTime actual constructor(
    public actual val hour: Int,
    public actual val minute: Int,
    public actual val second: Int,
    public actual val nanosecond: Int
) : Comparable<LocalTime> {

    init {
        fun check(value: Int, lower: Int, upper: Int, str: String) =
            require(value in lower..upper) {
                "Invalid time: $str must be a number between $lower and $upper, got $value"
            }
        check(hour, 0, 23, "hour")
        check(minute, 0, 59, "minute")
        check(second, 0, 59, "second")
        check(nanosecond, 0, NANOS_PER_ONE - 1, "nanosecond")
    }

    public actual companion object {
        public actual fun parse(isoString: String): LocalTime =
            localTimeParser.parse(isoString)

        public actual fun fromSecondOfDay(secondOfDay: Int): LocalTime =
            ofSecondOfDay(secondOfDay, 0)

        public actual fun fromMillisecondOfDay(millisecondOfDay: Int): LocalTime =
            ofNanoOfDay(millisecondOfDay.toLong() * NANOS_PER_MILLI)

        public actual fun fromNanosecondOfDay(nanosecondOfDay: Long): LocalTime =
            ofNanoOfDay(nanosecondOfDay)

        // org.threeten.bp.LocalTime#ofSecondOfDay(long, int)
        internal fun ofSecondOfDay(secondOfDay: Int, nanoOfSecond: Int): LocalTime {
            require(secondOfDay in 0 until SECONDS_PER_DAY)
            require(nanoOfSecond in 0 until NANOS_PER_ONE)
            val hours = (secondOfDay / SECONDS_PER_HOUR)
            val secondWithoutHours = secondOfDay - hours * SECONDS_PER_HOUR
            val minutes = (secondWithoutHours / SECONDS_PER_MINUTE)
            val second = secondWithoutHours - minutes * SECONDS_PER_MINUTE
            return LocalTime(hours, minutes, second, nanoOfSecond)
        }

        internal fun of(hour: Int, minute: Int, second: Int, nanosecond: Int): LocalTime {
            return LocalTime(hour, minute, second, nanosecond)
        }

        // org.threeten.bp.LocalTime#ofNanoOfDay
        internal fun ofNanoOfDay(nanoOfDay: Long): LocalTime {
            require(nanoOfDay >= 0 && nanoOfDay < SECONDS_PER_DAY.toLong() * NANOS_PER_ONE)
            var newNanoOfDay = nanoOfDay
            val hours = (newNanoOfDay / NANOS_PER_HOUR).toInt()
            newNanoOfDay -= hours * NANOS_PER_HOUR
            val minutes = (newNanoOfDay / NANOS_PER_MINUTE).toInt()
            newNanoOfDay -= minutes * NANOS_PER_MINUTE
            val seconds = (newNanoOfDay / NANOS_PER_ONE).toInt()
            newNanoOfDay -= seconds * NANOS_PER_ONE
            return LocalTime(hours, minutes, seconds, newNanoOfDay.toInt())
        }

        internal actual val MIN: LocalTime = LocalTime(0, 0, 0, 0)
        internal actual val MAX: LocalTime = LocalTime(23, 59, 59, NANOS_PER_ONE - 1)
    }

    // Several times faster than using `compareBy`
    actual override fun compareTo(other: LocalTime): Int {
        val h = hour.compareTo(other.hour)
        if (h != 0) {
            return h
        }
        val m = minute.compareTo(other.minute)
        if (m != 0) {
            return m
        }
        val s = second.compareTo(other.second)
        if (s != 0) {
            return s
        }
        return nanosecond.compareTo(other.nanosecond)
    }

    override fun hashCode(): Int {
        val nod: Long = this.toNanosecondOfDay()
        return (nod xor (nod ushr 32)).toInt()
    }

    // org.threeten.bp.LocalTime#toSecondOfDay
    public actual fun toSecondOfDay(): Int {
        var total: Int = hour * SECONDS_PER_HOUR
        total += minute * SECONDS_PER_MINUTE
        total += second
        return total
    }

    public actual fun toMillisecondOfDay(): Int =
        toSecondOfDay() * MILLIS_PER_ONE + nanosecond / NANOS_PER_MILLI

    // org.threeten.bp.LocalTime#toNanoOfDay
    public actual fun toNanosecondOfDay(): Long {
        var total: Long = hour.toLong() * NANOS_PER_ONE * SECONDS_PER_HOUR
        total += minute.toLong() * NANOS_PER_ONE * SECONDS_PER_MINUTE
        total += second.toLong() * NANOS_PER_ONE
        total += nanosecond.toLong()
        return total
    }

    // org.threeten.bp.LocalTime#toString
    actual override fun toString(): String {
        val buf = StringBuilder(18)
        val hourValue = hour
        val minuteValue = minute
        val secondValue = second
        val nanoValue: Int = nanosecond
        buf.append(if (hourValue < 10) "0" else "").append(hourValue)
            .append(if (minuteValue < 10) ":0" else ":").append(minuteValue)
        if (secondValue > 0 || nanoValue > 0) {
            buf.append(if (secondValue < 10) ":0" else ":").append(secondValue)
            if (nanoValue > 0) {
                buf.append('.')
                when {
                    nanoValue % 1000000 == 0 -> {
                        buf.append((nanoValue / 1000000 + 1000).toString().substring(1))
                    }
                    nanoValue % 1000 == 0 -> {
                        buf.append((nanoValue / 1000 + 1000000).toString().substring(1))
                    }
                    else -> {
                        buf.append((nanoValue + 1000000000).toString().substring(1))
                    }
                }
            }
        }
        return buf.toString()
    }

    override fun equals(other: Any?): Boolean =
        other is LocalTime && this.compareTo(other) == 0

}
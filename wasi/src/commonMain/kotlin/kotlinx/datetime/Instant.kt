/*
 * Copyright 2019-2020 JetBrains s.r.o.
 * Use of this source code is governed by the Apache 2.0 License that can be found in the LICENSE.txt file.
 */

package kotlinx.datetime

import kotlinx.datetime.internal.*
import kotlin.math.*
import kotlin.time.*
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds

/**
 * A moment in time.
 *
 * A point in time must be uniquely identified, so that it is independent of a time zone.
 * For example, `1970-01-01, 00:00:00` does not represent a moment in time, since this would happen at different times
 * in different time zones: someone in Tokyo would think its already `1970-01-01` several hours earlier than someone in
 * Berlin would. To represent such entities, use [LocalDateTime].
 * In contrast, "the moment the clocks in London first showed 00:00 on Jan 1, 2000" is a specific moment
 * in time, as is "1970-01-01, 00:00:00 UTC+0", and so it can be represented as an [Instant].
 *
 * `Instant` uses the UTC-SLS (smeared leap second) time scale. This time scale doesn't contain instants
 * corresponding to leap seconds, but instead "smears" positive and negative leap seconds among the last 1000 seconds
 * of the day when a leap second happens.
 *
 * Some ways in which [Instant] can be acquired are:
 * - [Clock.now] can be used to query the current moment for the given clock. With [Clock.System], it is the current
 *   moment as the platform sees it.
 * - [Instant.parse] parses an ISO-8601 string.
 * - [Instant.fromEpochMilliseconds] and [Instant.fromEpochSeconds] construct the instant values from the amount of time
 *   since `1970-01-01T00:00:00Z` (the Unix epoch).
 */
public expect class Instant : Comparable<Instant> {

    /**
     * The number of seconds from the epoch instant `1970-01-01T00:00:00Z` rounded down to a [Long] number.
     *
     * The difference between the rounded number of seconds and the actual number of seconds
     * is returned by [nanosecondsOfSecond] property expressed in nanoseconds.
     *
     * Note that this number doesn't include leap seconds added or removed since the epoch.
     *
     * @see Instant.fromEpochSeconds
     */
    public val epochSeconds: Long

    /**
     * The number of nanoseconds by which this instant is later than [epochSeconds] from the epoch instant.
     *
     * The value is always positive and lies in the range `0..999_999_999`.
     *
     * @see Instant.fromEpochSeconds
     */
    public val nanosecondsOfSecond: Int

    /**
     * Returns the number of milliseconds from the epoch instant `1970-01-01T00:00:00Z`.
     *
     * Any fractional part of millisecond is rounded down to the whole number of milliseconds.
     *
     * If the result does not fit in [Long], returns [Long.MAX_VALUE] for a positive result or [Long.MIN_VALUE] for a negative result.
     *
     * @see Instant.fromEpochMilliseconds
     */
    public fun toEpochMilliseconds(): Long

    /**
     * Returns an instant that is the result of adding the specified [duration] to this instant.
     *
     * If the [duration] is positive, the returned instant is later than this instant.
     * If the [duration] is negative, the returned instant is earlier than this instant.
     *
     * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
     */
    public operator fun plus(duration: Duration): Instant

    /**
     * Returns an instant that is the result of subtracting the specified [duration] from this instant.
     *
     * If the [duration] is positive, the returned instant is earlier than this instant.
     * If the [duration] is negative, the returned instant is later than this instant.
     *
     * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
     */
    public operator fun minus(duration: Duration): Instant

    // questionable
    /**
     * Returns the [Duration] between two instants: [other] and `this`.
     *
     * The duration returned is positive if this instant is later than the other,
     * and negative if this instant is earlier than the other.
     *
     * The result is never clamped, but note that for instants that are far apart,
     * the value returned may represent the duration between them inexactly due to the loss of precision.
     */
    public operator fun minus(other: Instant): Duration

    /**
     * Compares `this` instant with the [other] instant.
     * Returns zero if this instant represents the same moment as the other (i.e. equal to other),
     * a negative number if this instant is earlier than the other,
     * and a positive number if this instant is later than the other.
     */
    public override operator fun compareTo(other: Instant): Int

    /**
     * Converts this instant to the ISO-8601 string representation.
     *
     * The representation uses the UTC-SLS time scale, instead of UTC.
     * In practice, this means that leap second handling will not be readjusted to the UTC.
     * Leap seconds will not be added or skipped, so it is impossible to acquire a string
     * where the component for seconds is 60, and for any day, it's possible to observe 23:59:59.
     *
     * @see Instant.parse
     */
    public override fun toString(): String


    public companion object {
        @Deprecated("Use Clock.System.now() instead", ReplaceWith("Clock.System.now()", "kotlinx.datetime.Clock"), level = DeprecationLevel.ERROR)
        public fun now(): Instant

        /**
         * Returns an [Instant] that is [epochMilliseconds] number of milliseconds from the epoch instant `1970-01-01T00:00:00Z`.
         *
         * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
         *
         * @see Instant.toEpochMilliseconds
         */
        public fun fromEpochMilliseconds(epochMilliseconds: Long): Instant

        /**
         * Returns an [Instant] that is the [epochSeconds] number of seconds from the epoch instant `1970-01-01T00:00:00Z`
         * and the [nanosecondAdjustment] number of nanoseconds from the whole second.
         *
         * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
         */
        public fun fromEpochSeconds(epochSeconds: Long, nanosecondAdjustment: Long = 0): Instant

        /**
         * Returns an [Instant] that is the [epochSeconds] number of seconds from the epoch instant `1970-01-01T00:00:00Z`
         * and the [nanosecondAdjustment] number of nanoseconds from the whole second.
         *
         * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
         */
        public fun fromEpochSeconds(epochSeconds: Long, nanosecondAdjustment: Int): Instant

        /**
         * Parses a string that represents an instant in ISO-8601 format including date and time components and
         * the mandatory time zone offset and returns the parsed [Instant] value.
         *
         * Supports the following ways of specifying the time zone offset:
         * - the `Z` designator for the UTC+0 time zone,
         * - a custom time zone offset specified with `+hh`, or `+hh:mm`, or `+hh:mm:ss`
         *   (with `+` being replaced with `-` for the negative offsets)
         *
         * Examples of instants in the ISO-8601 format:
         * - `2020-08-30T18:43:00Z`
         * - `2020-08-30T18:43:00.500Z`
         * - `2020-08-30T18:43:00.123456789Z`
         * - `2020-08-30T18:40.00+03:00`
         * - `2020-08-30T18:40.00+03:30:20`
         *
         * The string is considered to represent time on the UTC-SLS time scale instead of UTC.
         * In practice, this means that, even if there is a leap second on the given day, it will not affect how the
         * time is parsed, even if it's in the last 1000 seconds of the day.
         * Instead, even if there is a negative leap second on the given day, 23:59:59 is still considered valid time.
         * 23:59:60 is invalid on UTC-SLS, so parsing it will fail.
         *
         * @throws IllegalArgumentException if the text cannot be parsed or the boundaries of [Instant] are exceeded.
         */
        public fun parse(isoString: String): Instant


        /**
         * An instant value that is far in the past.
         *
         * All instants in the range `DISTANT_PAST..DISTANT_FUTURE` can be [converted][Instant.toLocalDateTime] to
         * [LocalDateTime] without exceptions on all supported platforms.
         */
        public val DISTANT_PAST: Instant // -100001-12-31T23:59:59.999999999Z

        /**
         * An instant value that is far in the future.
         *
         * All instants in the range `DISTANT_PAST..DISTANT_FUTURE` can be [converted][Instant.toLocalDateTime] to
         * [LocalDateTime] without exceptions on all supported platforms.
         */
        public val DISTANT_FUTURE: Instant // +100000-01-01T00:00:00Z

        internal val MIN: Instant
        internal val MAX: Instant
    }
}

/** Returns true if the instant is [Instant.DISTANT_PAST] or earlier. */
public val Instant.isDistantPast: Boolean
    get() = this <= Instant.DISTANT_PAST

/** Returns true if the instant is [Instant.DISTANT_FUTURE] or later. */
public val Instant.isDistantFuture: Boolean
    get() = this >= Instant.DISTANT_FUTURE

/**
 * Converts this string representing an instant in ISO-8601 format including date and time components and
 * the time zone offset to an [Instant] value.
 *
 * See [Instant.parse] for examples of instant string representations and discussion of leap seconds.
 *
 * @throws IllegalArgumentException if the text cannot be parsed or the boundaries of [Instant] are exceeded.
 */
public fun String.toInstant(): Instant = Instant.parse(this)

/**
 * Returns an instant that is the result of adding components of [DateTimePeriod] to this instant. The components are
 * added in the order from the largest units to the smallest, i.e. from years to nanoseconds.
 *
 * @throws DateTimeArithmeticException if this value or the results of intermediate computations are too large to fit in
 * [LocalDateTime].
 */
public expect fun Instant.plus(period: DateTimePeriod, timeZone: TimeZone): Instant

/**
 * Returns an instant that is the result of subtracting components of [DateTimePeriod] from this instant. The components
 * are subtracted in the order from the largest units to the smallest, i.e. from years to nanoseconds.
 *
 * @throws DateTimeArithmeticException if this value or the results of intermediate computations are too large to fit in
 * [LocalDateTime].
 */
public fun Instant.minus(period: DateTimePeriod, timeZone: TimeZone): Instant =
    /* An overflow can happen for any component, but we are only worried about nanoseconds, as having an overflow in
    any other component means that `plus` will throw due to the minimum value of the numeric type overflowing the
    platform-specific limits. */
    if (period.totalNanoseconds != Long.MIN_VALUE) {
        val negatedPeriod = with(period) { buildDateTimePeriod(-totalMonths, -days, -totalNanoseconds) }
        plus(negatedPeriod, timeZone)
    } else {
        val negatedPeriod = with(period) { buildDateTimePeriod(-totalMonths, -days, -(totalNanoseconds+1)) }
        plus(negatedPeriod, timeZone).plus(DateTimeUnit.NANOSECOND)
    }

/**
 * Returns a [DateTimePeriod] representing the difference between `this` and [other] instants.
 *
 * The components of [DateTimePeriod] are calculated so that adding it to `this` instant results in the [other] instant.
 *
 * All components of the [DateTimePeriod] returned are:
 * - positive or zero if this instant is earlier than the other,
 * - negative or zero if this instant is later than the other,
 * - exactly zero if this instant is equal to the other.
 *
 * @throws DateTimeArithmeticException if `this` or [other] instant is too large to fit in [LocalDateTime].
 *     Or (only on the JVM) if the number of months between the two dates exceeds an Int.
 */
public expect fun Instant.periodUntil(other: Instant, timeZone: TimeZone): DateTimePeriod

/**
 * Returns the whole number of the specified date or time [units][unit] between `this` and [other] instants
 * in the specified [timeZone].
 *
 * The value returned is:
 * - positive or zero if this instant is earlier than the other,
 * - negative or zero if this instant is later than the other,
 * - zero if this instant is equal to the other.
 *
 * If the result does not fit in [Long], returns [Long.MAX_VALUE] for a positive result or [Long.MIN_VALUE] for a negative result.
 *
 * @throws DateTimeArithmeticException if `this` or [other] instant is too large to fit in [LocalDateTime].
 */
public expect fun Instant.until(other: Instant, unit: DateTimeUnit, timeZone: TimeZone): Long

/**
 * Returns the whole number of the specified time [units][unit] between `this` and [other] instants.
 *
 * The value returned is:
 * - positive or zero if this instant is earlier than the other,
 * - negative or zero if this instant is later than the other,
 * - zero if this instant is equal to the other.
 *
 * If the result does not fit in [Long], returns [Long.MAX_VALUE] for a positive result or [Long.MIN_VALUE] for a negative result.
 */
public fun Instant.until(other: Instant, unit: DateTimeUnit.TimeBased): Long =
    try {
        multiplyAddAndDivide(other.epochSeconds - epochSeconds,
            NANOS_PER_ONE.toLong(),
            (other.nanosecondsOfSecond - nanosecondsOfSecond).toLong(),
            unit.nanoseconds)
    } catch (e: ArithmeticException) {
        if (this < other) Long.MAX_VALUE else Long.MIN_VALUE
    }

/**
 * Returns the number of whole days between two instants in the specified [timeZone].
 *
 * If the result does not fit in [Int], returns [Int.MAX_VALUE] for a positive result or [Int.MIN_VALUE] for a negative result.
 *
 * @see Instant.until
 * @throws DateTimeArithmeticException if `this` or [other] instant is too large to fit in [LocalDateTime].
 */
public fun Instant.daysUntil(other: Instant, timeZone: TimeZone): Int =
        until(other, DateTimeUnit.DAY, timeZone).clampToInt()

/**
 * Returns the number of whole months between two instants in the specified [timeZone].
 *
 * If the result does not fit in [Int], returns [Int.MAX_VALUE] for a positive result or [Int.MIN_VALUE] for a negative result.
 *
 * @see Instant.until
 * @throws DateTimeArithmeticException if `this` or [other] instant is too large to fit in [LocalDateTime].
 */
public fun Instant.monthsUntil(other: Instant, timeZone: TimeZone): Int =
        until(other, DateTimeUnit.MONTH, timeZone).clampToInt()

/**
 * Returns the number of whole years between two instants in the specified [timeZone].
 *
 * If the result does not fit in [Int], returns [Int.MAX_VALUE] for a positive result or [Int.MIN_VALUE] for a negative result.
 *
 * @see Instant.until
 * @throws DateTimeArithmeticException if `this` or [other] instant is too large to fit in [LocalDateTime].
 */
public fun Instant.yearsUntil(other: Instant, timeZone: TimeZone): Int =
        until(other, DateTimeUnit.YEAR, timeZone).clampToInt()

/**
 * Returns a [DateTimePeriod] representing the difference between [other] and `this` instants.
 *
 * The components of [DateTimePeriod] are calculated so that adding it back to the `other` instant results in this instant.
 *
 * All components of the [DateTimePeriod] returned are:
 * - negative or zero if this instant is earlier than the other,
 * - positive or zero if this instant is later than the other,
 * - exactly zero if this instant is equal to the other.
 *
 * @throws DateTimeArithmeticException if `this` or [other] instant is too large to fit in [LocalDateTime].
 *   Or (only on the JVM) if the number of months between the two dates exceeds an Int.
 * @see Instant.periodUntil
 */
public fun Instant.minus(other: Instant, timeZone: TimeZone): DateTimePeriod =
        other.periodUntil(this, timeZone)


/**
 * Returns an instant that is the result of adding one [unit] to this instant
 * in the specified [timeZone].
 *
 * The returned instant is later than this instant.
 *
 * @throws DateTimeArithmeticException if this value or the result is too large to fit in [LocalDateTime].
 */
public expect fun Instant.plus(unit: DateTimeUnit, timeZone: TimeZone): Instant

/**
 * Returns an instant that is the result of subtracting one [unit] from this instant
 * in the specified [timeZone].
 *
 * The returned instant is earlier than this instant.
 *
 * @throws DateTimeArithmeticException if this value or the result is too large to fit in [LocalDateTime].
 */
public fun Instant.minus(unit: DateTimeUnit, timeZone: TimeZone): Instant =
    plus(-1, unit, timeZone)

/**
 * Returns an instant that is the result of adding one [unit] to this instant.
 *
 * The returned instant is later than this instant.
 *
 * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
 */
public fun Instant.plus(unit: DateTimeUnit.TimeBased): Instant =
    plus(1L, unit)

/**
 * Returns an instant that is the result of subtracting one [unit] from this instant.
 *
 * The returned instant is earlier than this instant.
 *
 * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
 */
public fun Instant.minus(unit: DateTimeUnit.TimeBased): Instant =
    plus(-1L, unit)

/**
 * Returns an instant that is the result of adding the [value] number of the specified [unit] to this instant
 * in the specified [timeZone].
 *
 * If the [value] is positive, the returned instant is later than this instant.
 * If the [value] is negative, the returned instant is earlier than this instant.
 *
 * @throws DateTimeArithmeticException if this value or the result is too large to fit in [LocalDateTime].
 */
public expect fun Instant.plus(value: Int, unit: DateTimeUnit, timeZone: TimeZone): Instant

/**
 * Returns an instant that is the result of subtracting the [value] number of the specified [unit] from this instant
 * in the specified [timeZone].
 *
 * If the [value] is positive, the returned instant is earlier than this instant.
 * If the [value] is negative, the returned instant is later than this instant.
 *
 * @throws DateTimeArithmeticException if this value or the result is too large to fit in [LocalDateTime].
 */
public expect fun Instant.minus(value: Int, unit: DateTimeUnit, timeZone: TimeZone): Instant

/**
 * Returns an instant that is the result of adding the [value] number of the specified [unit] to this instant.
 *
 * If the [value] is positive, the returned instant is later than this instant.
 * If the [value] is negative, the returned instant is earlier than this instant.
 *
 * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
 */
public fun Instant.plus(value: Int, unit: DateTimeUnit.TimeBased): Instant =
    plus(value.toLong(), unit)

/**
 * Returns an instant that is the result of subtracting the [value] number of the specified [unit] from this instant.
 *
 * If the [value] is positive, the returned instant is earlier than this instant.
 * If the [value] is negative, the returned instant is later than this instant.
 *
 * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
 */
public fun Instant.minus(value: Int, unit: DateTimeUnit.TimeBased): Instant =
    minus(value.toLong(), unit)

/**
 * Returns an instant that is the result of adding the [value] number of the specified [unit] to this instant
 * in the specified [timeZone].
 *
 * If the [value] is positive, the returned instant is later than this instant.
 * If the [value] is negative, the returned instant is earlier than this instant.
 *
 * @throws DateTimeArithmeticException if this value or the result is too large to fit in [LocalDateTime].
 */
public expect fun Instant.plus(value: Long, unit: DateTimeUnit, timeZone: TimeZone): Instant

/**
 * Returns an instant that is the result of subtracting the [value] number of the specified [unit] from this instant
 * in the specified [timeZone].
 *
 * If the [value] is positive, the returned instant is earlier than this instant.
 * If the [value] is negative, the returned instant is later than this instant.
 *
 * @throws DateTimeArithmeticException if this value or the result is too large to fit in [LocalDateTime].
 */
public fun Instant.minus(value: Long, unit: DateTimeUnit, timeZone: TimeZone): Instant =
    if (value != Long.MIN_VALUE) {
        plus(-value, unit, timeZone)
    } else {
        plus(-(value + 1), unit, timeZone).plus(unit, timeZone)
    }

/**
 * Returns an instant that is the result of adding the [value] number of the specified [unit] to this instant.
 *
 * If the [value] is positive, the returned instant is later than this instant.
 * If the [value] is negative, the returned instant is earlier than this instant.
 *
 * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
 */
public expect fun Instant.plus(value: Long, unit: DateTimeUnit.TimeBased): Instant

/**
 * Returns an instant that is the result of subtracting the [value] number of the specified [unit] from this instant.
 *
 * If the [value] is positive, the returned instant is earlier than this instant.
 * If the [value] is negative, the returned instant is later than this instant.
 *
 * The return value is clamped to the platform-specific boundaries for [Instant] if the result exceeds them.
 */
public fun Instant.minus(value: Long, unit: DateTimeUnit.TimeBased): Instant =
    if (value != Long.MIN_VALUE) {
        plus(-value, unit)
    } else {
        plus(-(value + 1), unit).plus(unit)
    }

/**
 * Returns the whole number of the specified date or time [units][unit] between [other] and `this` instants
 * in the specified [timeZone].
 *
 * The value returned is negative or zero if this instant is earlier than the other,
 * and positive or zero if this instant is later than the other.
 *
 * If the result does not fit in [Long], returns [Long.MAX_VALUE] for a positive result or [Long.MIN_VALUE] for a negative result.
 *
 * @throws DateTimeArithmeticException if `this` or [other] instant is too large to fit in [LocalDateTime].
 * @see Instant.until
 */
public fun Instant.minus(other: Instant, unit: DateTimeUnit, timeZone: TimeZone): Long =
        other.until(this, unit, timeZone)

/**
 * Returns the whole number of the specified time [units][unit] between [other] and `this` instants.
 *
 * The value returned is negative or zero if this instant is earlier than the other,
 * and positive or zero if this instant is later than the other.
 *
 * If the result does not fit in [Long], returns [Long.MAX_VALUE] for a positive result or [Long.MIN_VALUE] for a negative result.
 *
 * @see Instant.until
 */
public fun Instant.minus(other: Instant, unit: DateTimeUnit.TimeBased): Long =
    other.until(this, unit)

internal const val DISTANT_PAST_SECONDS = -3217862419201
internal const val DISTANT_FUTURE_SECONDS = 3093527980800

/**
 * Displays the given Instant in the given [offset].
 *
 * Be careful: this function may throw for some values of the [Instant].
 */
internal expect fun Instant.toStringWithOffset(offset: UtcOffset): String

public actual enum class DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

/** A parser for the string representation of [ZoneOffset] as seen in `OffsetDateTime`.
 *
 * We can't just reuse the parsing logic of [ZoneOffset.of], as that version is more lenient: here, strings like
 * "0330" are not considered valid zone offsets, whereas [ZoneOffset.of] sees treats the example above as "03:30". */
private val zoneOffsetParser: Parser<UtcOffset>
    get() = (concreteCharParser('z').or(concreteCharParser('Z')).map { UtcOffset.ZERO })
        .or(
            concreteCharParser('+').or(concreteCharParser('-'))
                .chain(intParser(2, 2))
                .chain(
                    optional(
                        // minutes
                        concreteCharParser(':').chainSkipping(intParser(2, 2))
                            .chain(optional(
                                // seconds
                                concreteCharParser(':').chainSkipping(intParser(2, 2))
                            ))))
                .map {
                    val (signHours, minutesSeconds) = it
                    val (sign, hours) = signHours
                    val minutes: Int
                    val seconds: Int
                    if (minutesSeconds == null) {
                        minutes = 0
                        seconds = 0
                    } else {
                        minutes = minutesSeconds.first
                        seconds = minutesSeconds.second ?: 0
                    }
                    try {
                        if (sign == '-')
                            UtcOffset.ofHoursMinutesSeconds(-hours, -minutes, -seconds)
                        else
                            UtcOffset.ofHoursMinutesSeconds(hours, minutes, seconds)
                    } catch (e: IllegalArgumentException) {
                        throw DateTimeFormatException(e)
                    }
                }
        )

// This is a function and not a value due to https://github.com/Kotlin/kotlinx-datetime/issues/5
// org.threeten.bp.format.DateTimeFormatter#ISO_OFFSET_DATE_TIME
private val instantParser: Parser<Instant>
    get() = localDateParser
        .chainIgnoring(concreteCharParser('T').or(concreteCharParser('t')))
        .chain(intParser(2, 2)) // hour
        .chainIgnoring(concreteCharParser(':'))
        .chain(intParser(2, 2)) // minute
        .chainIgnoring(concreteCharParser(':'))
        .chain(intParser(2, 2)) // second
        .chain(optional(
            concreteCharParser('.')
                .chainSkipping(fractionParser(0, 9, 9)) // nanos
        ))
        .chain(zoneOffsetParser)
        .map {
            val (localDateTime, offset) = it
            val (dateHourMinuteSecond, nanosVal) = localDateTime
            val (dateHourMinute, secondsVal) = dateHourMinuteSecond
            val (dateHour, minutesVal) = dateHourMinute
            val (dateVal, hoursVal) = dateHour

            val nano = nanosVal ?: 0
            val (days, hours, min, seconds) = if (hoursVal == 24 && minutesVal == 0 && secondsVal == 0 && nano == 0) {
                listOf(1, 0, 0, 0)
            } else if (hoursVal == 23 && minutesVal == 59 && secondsVal == 60) {
                // TODO: throw an error on leap seconds to match what the other platforms do
                listOf(0, 23, 59, 59)
            } else {
                listOf(0, hoursVal, minutesVal, secondsVal)
            }

            // never fails: 9_999 years are always supported
            val localDate = dateVal.withYear(dateVal.year % 10000).plus(days, DateTimeUnit.DAY)
            val localTime = LocalTime.of(hours, min, seconds, 0)
            val secDelta: Long = try {
                safeMultiply((dateVal.year / 10000).toLong(), SECONDS_PER_10000_YEARS)
            } catch (e: ArithmeticException) {
                throw DateTimeFormatException(e)
            }
            val epochDay = localDate.toEpochDays().toLong()
            val instantSecs = epochDay * 86400 - offset.totalSeconds + localTime.toSecondOfDay() + secDelta
            try {
                Instant(instantSecs, nano)
            } catch (e: IllegalArgumentException) {
                throw DateTimeFormatException(e)
            }
        }

/**
 * The minimum supported epoch second.
 */
private const val MIN_SECOND = -31619119219200L // -1000000-01-01T00:00:00Z

/**
 * The maximum supported epoch second.
 */
private const val MAX_SECOND = 31494816403199L // +1000000-12-31T23:59:59

private fun isValidInstantSecond(second: Long) = second >= MIN_SECOND && second <= MAX_SECOND

internal expect fun currentTime(): Instant

public actual class Instant internal constructor(public actual val epochSeconds: Long, public actual val nanosecondsOfSecond: Int) : Comparable<Instant> {

    init {
        require(isValidInstantSecond(epochSeconds)) { "Instant exceeds minimum or maximum instant" }
    }

    // org.threeten.bp.Instant#toEpochMilli
    public actual fun toEpochMilliseconds(): Long =
        epochSeconds * MILLIS_PER_ONE + nanosecondsOfSecond / NANOS_PER_MILLI

    // org.threeten.bp.Instant#plus(long, long)
    /**
     * @throws ArithmeticException if arithmetic overflow occurs
     * @throws IllegalArgumentException if the boundaries of Instant are overflown
     */
    internal fun plus(secondsToAdd: Long, nanosToAdd: Long): Instant {
        if ((secondsToAdd or nanosToAdd) == 0L) {
            return this
        }
        val newEpochSeconds: Long = safeAdd(safeAdd(epochSeconds, secondsToAdd), (nanosToAdd / NANOS_PER_ONE))
        val newNanosToAdd = nanosToAdd % NANOS_PER_ONE
        val nanoAdjustment = (nanosecondsOfSecond + newNanosToAdd) // safe int+NANOS_PER_ONE
        return fromEpochSecondsThrowing(newEpochSeconds, nanoAdjustment)
    }

    public actual operator fun plus(duration: Duration): Instant = duration.toComponents { secondsToAdd, nanosecondsToAdd ->
        try {
            plus(secondsToAdd, nanosecondsToAdd.toLong())
        } catch (e: IllegalArgumentException) {
            if (secondsToAdd > 0) MAX else MIN
        } catch (e: ArithmeticException) {
            if (secondsToAdd > 0) MAX else MIN
        }
    }

    public actual operator fun minus(duration: Duration): Instant = plus(-duration)

    public actual operator fun minus(other: Instant): Duration =
        (this.epochSeconds - other.epochSeconds).seconds + // won't overflow given the instant bounds
                (this.nanosecondsOfSecond - other.nanosecondsOfSecond).nanoseconds

    actual override fun compareTo(other: Instant): Int {
        val s = epochSeconds.compareTo(other.epochSeconds)
        if (s != 0) {
            return s
        }
        return nanosecondsOfSecond.compareTo(other.nanosecondsOfSecond)
    }

    override fun equals(other: Any?): Boolean =
        this === other || other is Instant && this.epochSeconds == other.epochSeconds && this.nanosecondsOfSecond == other.nanosecondsOfSecond

    // org.threeten.bp.Instant#hashCode
    override fun hashCode(): Int =
        (epochSeconds xor (epochSeconds ushr 32)).toInt() + 51 * nanosecondsOfSecond

    // org.threeten.bp.format.DateTimeFormatterBuilder.InstantPrinterParser#print
    actual override fun toString(): String = toStringWithOffset(UtcOffset.ZERO)

    public actual companion object {
        internal actual val MIN = Instant(MIN_SECOND, 0)
        internal actual val MAX = Instant(MAX_SECOND, 999_999_999)

        @Deprecated("Use Clock.System.now() instead", ReplaceWith("Clock.System.now()", "kotlinx.datetime.Clock"), level = DeprecationLevel.ERROR)
        public actual fun now(): Instant = currentTime()

        // org.threeten.bp.Instant#ofEpochMilli
        public actual fun fromEpochMilliseconds(epochMilliseconds: Long): Instant =
            if (epochMilliseconds < MIN_SECOND * MILLIS_PER_ONE) MIN
            else if (epochMilliseconds > MAX_SECOND * MILLIS_PER_ONE) MAX
            else Instant(
                epochMilliseconds.floorDiv(MILLIS_PER_ONE.toLong()),
                (epochMilliseconds.mod(MILLIS_PER_ONE.toLong()) * NANOS_PER_MILLI).toInt()
            )

        /**
         * @throws ArithmeticException if arithmetic overflow occurs
         * @throws IllegalArgumentException if the boundaries of Instant are overflown
         */
        private fun fromEpochSecondsThrowing(epochSeconds: Long, nanosecondAdjustment: Long): Instant {
            val secs = safeAdd(epochSeconds, nanosecondAdjustment.floorDiv(NANOS_PER_ONE.toLong()))
            val nos = nanosecondAdjustment.mod(NANOS_PER_ONE.toLong()).toInt()
            return Instant(secs, nos)
        }

        // org.threeten.bp.Instant#ofEpochSecond(long, long)
        public actual fun fromEpochSeconds(epochSeconds: Long, nanosecondAdjustment: Long): Instant =
            try {
                fromEpochSecondsThrowing(epochSeconds, nanosecondAdjustment)
            } catch (e: ArithmeticException) {
                if (epochSeconds > 0) MAX else MIN
            } catch (e: IllegalArgumentException) {
                if (epochSeconds > 0) MAX else MIN
            }

        public actual fun fromEpochSeconds(epochSeconds: Long, nanosecondAdjustment: Int): Instant =
            fromEpochSeconds(epochSeconds, nanosecondAdjustment.toLong())

        public actual fun parse(isoString: String): Instant =
            instantParser.parse(isoString)

        public actual val DISTANT_PAST: Instant = fromEpochSeconds(DISTANT_PAST_SECONDS, 999_999_999)

        public actual val DISTANT_FUTURE: Instant = fromEpochSeconds(DISTANT_FUTURE_SECONDS, 0)
    }

}

private fun Instant.toZonedDateTimeFailing(zone: TimeZone): ZonedDateTime = try {
    toZonedDateTime(zone)
} catch (e: IllegalArgumentException) {
    throw DateTimeArithmeticException("Can not convert instant $this to LocalDateTime to perform computations", e)
}

/**
 * @throws IllegalArgumentException if the [Instant] exceeds the boundaries of [LocalDateTime]
 */
private fun Instant.toZonedDateTime(zone: TimeZone): ZonedDateTime {
    val currentOffset = zone.offsetAt(this)
    return ZonedDateTime(toLocalDateTimeImpl(currentOffset), zone, currentOffset)
}

/** Check that [Instant] fits in [ZonedDateTime].
 * This is done on the results of computations for consistency with other platforms.
 */
private fun Instant.check(zone: TimeZone): Instant = this@check.also {
    toZonedDateTimeFailing(zone)
}

public actual fun Instant.plus(period: DateTimePeriod, timeZone: TimeZone): Instant = try {
    with(period) {
        val withDate = toZonedDateTimeFailing(timeZone)
            .run { if (totalMonths != 0) plus(totalMonths, DateTimeUnit.MONTH) else this }
            .run { if (days != 0) plus(days, DateTimeUnit.DAY) else this }
        withDate.toInstant()
            .run { if (totalNanoseconds != 0L) plus(0, totalNanoseconds).check(timeZone) else this }
    }.check(timeZone)
} catch (e: ArithmeticException) {
    throw DateTimeArithmeticException("Arithmetic overflow when adding CalendarPeriod to an Instant", e)
} catch (e: IllegalArgumentException) {
    throw DateTimeArithmeticException("Boundaries of Instant exceeded when adding CalendarPeriod", e)
}

public actual fun Instant.plus(unit: DateTimeUnit, timeZone: TimeZone): Instant =
    plus(1L, unit, timeZone)
public actual fun Instant.plus(value: Int, unit: DateTimeUnit, timeZone: TimeZone): Instant =
    plus(value.toLong(), unit, timeZone)
public actual fun Instant.minus(value: Int, unit: DateTimeUnit, timeZone: TimeZone): Instant =
    plus(-value.toLong(), unit, timeZone)
public actual fun Instant.plus(value: Long, unit: DateTimeUnit, timeZone: TimeZone): Instant = try {
    when (unit) {
        is DateTimeUnit.DateBased -> {
            if (value < Int.MIN_VALUE || value > Int.MAX_VALUE)
                throw ArithmeticException("Can't add a Long date-based value, as it would cause an overflow")
            toZonedDateTimeFailing(timeZone).plus(value.toInt(), unit).toInstant()
        }
        is DateTimeUnit.TimeBased ->
            check(timeZone).plus(value, unit).check(timeZone)
    }
} catch (e: ArithmeticException) {
    throw DateTimeArithmeticException("Arithmetic overflow when adding to an Instant", e)
} catch (e: IllegalArgumentException) {
    throw DateTimeArithmeticException("Boundaries of Instant exceeded when adding a value", e)
}

public actual fun Instant.plus(value: Long, unit: DateTimeUnit.TimeBased): Instant =
    try {
        multiplyAndDivide(value, unit.nanoseconds, NANOS_PER_ONE.toLong()).let { (seconds, nanoseconds) ->
            plus(seconds, nanoseconds)
        }
    } catch (e: ArithmeticException) {
        if (value > 0) Instant.MAX else Instant.MIN
    } catch (e: IllegalArgumentException) {
        if (value > 0) Instant.MAX else Instant.MIN
    }

public actual fun Instant.periodUntil(other: Instant, timeZone: TimeZone): DateTimePeriod {
    var thisLdt = toZonedDateTimeFailing(timeZone)
    val otherLdt = other.toZonedDateTimeFailing(timeZone)

    val months = thisLdt.until(otherLdt, DateTimeUnit.MONTH).toInt() // `until` on dates never fails
    thisLdt = thisLdt.plus(months, DateTimeUnit.MONTH) // won't throw: thisLdt + months <= otherLdt, which is known to be valid
    val days = thisLdt.until(otherLdt, DateTimeUnit.DAY).toInt() // `until` on dates never fails
    thisLdt = thisLdt.plus(days, DateTimeUnit.DAY) // won't throw: thisLdt + days <= otherLdt
    val nanoseconds = thisLdt.until(otherLdt, DateTimeUnit.NANOSECOND) // |otherLdt - thisLdt| < 24h

    return buildDateTimePeriod(months, days, nanoseconds)
}

public actual fun Instant.until(other: Instant, unit: DateTimeUnit, timeZone: TimeZone): Long =
    when (unit) {
        is DateTimeUnit.DateBased ->
            toZonedDateTimeFailing(timeZone).dateTime.until(other.toZonedDateTimeFailing(timeZone).dateTime, unit)
                .toLong()
        is DateTimeUnit.TimeBased -> {
            check(timeZone); other.check(timeZone)
            until(other, unit)
        }
    }

internal actual fun Instant.toStringWithOffset(offset: UtcOffset): String {
    val buf = StringBuilder()
    val inNano: Int = nanosecondsOfSecond
    val seconds = epochSeconds + offset.totalSeconds
    if (seconds >= -SECONDS_0000_TO_1970) { // current era
        val zeroSecs: Long = seconds - SECONDS_PER_10000_YEARS + SECONDS_0000_TO_1970
        val hi: Long = zeroSecs.floorDiv(SECONDS_PER_10000_YEARS) + 1
        val lo: Long = zeroSecs.mod(SECONDS_PER_10000_YEARS)
        val ldt: LocalDateTime = Instant(lo - SECONDS_0000_TO_1970, 0)
            .toLocalDateTime(TimeZone.UTC)
        if (hi > 0) {
            buf.append('+').append(hi)
        }
        buf.append(ldt)
        if (ldt.second == 0) {
            buf.append(":00")
        }
    } else { // before current era
        val zeroSecs: Long = seconds + SECONDS_0000_TO_1970
        val hi: Long = zeroSecs / SECONDS_PER_10000_YEARS
        val lo: Long = zeroSecs % SECONDS_PER_10000_YEARS
        val ldt: LocalDateTime = Instant(lo - SECONDS_0000_TO_1970, 0)
            .toLocalDateTime(TimeZone.UTC)
        val pos = buf.length
        buf.append(ldt)
        if (ldt.second == 0) {
            buf.append(":00")
        }
        if (hi < 0) {
            when {
                ldt.year == -10000 -> {
                    buf.deleteAt(pos)
                    buf.deleteAt(pos)
                    buf.insert(pos, (hi - 1).toString())
                }
                lo == 0L -> {
                    buf.insert(pos, hi)
                }
                else -> {
                    buf.insert(pos + 1, abs(hi))
                }
            }
        }
    }
    //fraction
    if (inNano != 0) {
        buf.append('.')
        when {
            inNano % 1000000 == 0 -> {
                buf.append((inNano / 1000000 + 1000).toString().substring(1))
            }
            inNano % 1000 == 0 -> {
                buf.append((inNano / 1000 + 1000000).toString().substring(1))
            }
            else -> {
                buf.append((inNano + 1000000000).toString().substring(1))
            }
        }
    }
    buf.append(offset)
    return buf.toString()
}


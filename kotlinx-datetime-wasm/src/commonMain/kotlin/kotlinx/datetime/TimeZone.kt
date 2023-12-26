/*
 * Copyright 2019-2020 JetBrains s.r.o.
 * Use of this source code is governed by the Apache 2.0 License that can be found in the LICENSE.txt file.
 */

package kotlinx.datetime

import kotlinx.datetime.internal.SECONDS_PER_DAY

/**
 * A time zone, provides the conversion between [Instant] and [LocalDateTime] values
 * using a collection of rules specifying which [LocalDateTime] value corresponds to each [Instant].
 */
public expect open class TimeZone {
    /**
     * Returns the identifier string of the time zone.
     *
     * This identifier can be used later for finding this time zone with [TimeZone.of] function.
     */
    public val id: String

    // TODO: Declare and document toString/equals/hashCode

    public companion object {
        /**
         * Queries the current system time zone.
         *
         * If the current system time zone changes, this function can reflect this change on the next invocation.
         */
        public fun currentSystemDefault(): TimeZone

        /**
         * Returns the time zone with the fixed UTC+0 offset.
         */
        public val UTC: FixedOffsetTimeZone

        /**
         * Returns the time zone identified by the provided [zoneId].
         *
         * The supported variants of time zone identifiers:
         * - `Z`, 'UTC', 'UT' or 'GMT' — identifies the fixed-offset time zone [TimeZone.UTC],
         * - a string starting with '+', '-', `UTC+`, `UTC-`, `UT+`, `UT-`, `GMT+`, `GMT-` — identifiers the time zone
         *   with the fixed offset specified after `+` or `-`,
         * - all other strings are treated as region-based zone identifiers.
         * In the IANA Time Zone Database (TZDB) which is used as the default source of time zones,
         * these ids are usually in the form `area/city`, for example, `Europe/Berlin` or `America/Los_Angeles`.
         *
         * @throws IllegalTimeZoneException if [zoneId] has an invalid format or a time-zone with the name [zoneId]
         * is not found.
         */
        public fun of(zoneId: String): TimeZone

        /**
         * Queries the set of identifiers of time zones available in the system.
         */
        public val availableZoneIds: Set<String>
    }

    /**
     * Return the civil date/time value that this instant has in the time zone provided as an implicit receiver.
     *
     * Note that while this conversion is unambiguous, the inverse ([LocalDateTime.toInstant])
     * is not necessary so.
     *
     * @see LocalDateTime.toInstant
     * @see Instant.offsetIn
     * @throws DateTimeArithmeticException if this value is too large to fit in [LocalDateTime].
     */
    public fun Instant.toLocalDateTime(): LocalDateTime

    /**
     * Returns an instant that corresponds to this civil date/time value in the time zone provided as an implicit receiver.
     *
     * Note that the conversion is not always unambiguous. There can be the following possible situations:
     * - There's only one instant that has this date/time value in the time zone. In this case
     * the conversion is unambiguous.
     * - There's no instant that has this date/time value in the time zone. Such situation appears when
     * the time zone experiences a transition from a lesser to a greater offset. In this case the conversion is performed with
     * the lesser offset.
     * - There are two possible instants that can have this date/time components in the time zone. In this case the earlier
     * instant is returned.
     *
     * @see Instant.toLocalDateTime
     */
    public fun LocalDateTime.toInstant(): Instant
}

/**
 * A time zone that is known to always have the same offset from UTC.
 */
public expect class FixedOffsetTimeZone : TimeZone {
    public constructor(offset: UtcOffset)

    /**
     * The constant offset from UTC that this time zone has.
     */
    public val offset: UtcOffset

    @Deprecated("Use offset.totalSeconds", ReplaceWith("offset.totalSeconds"))
    public val totalSeconds: Int
}

@Deprecated("Use FixedOffsetTimeZone of UtcOffset instead", ReplaceWith("FixedOffsetTimeZone"))
public typealias ZoneOffset = FixedOffsetTimeZone

/**
 * Finds the offset from UTC this time zone has at the specified [instant] of physical time.
 *
 * @see Instant.toLocalDateTime
 * @see TimeZone.offsetAt
 */
public expect fun TimeZone.offsetAt(instant: Instant): UtcOffset

/**
 * Returns a civil date/time value that this instant has in the specified [timeZone].
 *
 * Note that while this conversion is unambiguous, the inverse ([LocalDateTime.toInstant])
 * is not necessary so.
 *
 * @see LocalDateTime.toInstant
 * @see Instant.offsetIn
 * @throws DateTimeArithmeticException if this value is too large to fit in [LocalDateTime].
 */
public expect fun Instant.toLocalDateTime(timeZone: TimeZone): LocalDateTime

/**
 * Returns a civil date/time value that this instant has in the specified [UTC offset][offset].
 *
 * @see LocalDateTime.toInstant
 * @see Instant.offsetIn
 */
internal expect fun Instant.toLocalDateTime(offset: UtcOffset): LocalDateTime

/**
 * Finds the offset from UTC the specified [timeZone] has at this instant of physical time.
 *
 * @see Instant.toLocalDateTime
 * @see TimeZone.offsetAt
 */
public fun Instant.offsetIn(timeZone: TimeZone): UtcOffset =
        timeZone.offsetAt(this)

/**
 * Returns an instant that corresponds to this civil date/time value in the specified [timeZone].
 *
 * Note that the conversion is not always unambiguous. There can be the following possible situations:
 * - There's only one instant that has this date/time value in the [timeZone]. In this case
 * the conversion is unambiguous.
 * - There's no instant that has this date/time value in the [timeZone]. Such situation appears when
 * the time zone experiences a transition from a lesser to a greater offset. In this case the conversion is performed with
 * the lesser offset.
 * - There are two possible instants that can have this date/time components in the [timeZone]. In this case the earlier
 * instant is returned.
 *
 * @see Instant.toLocalDateTime
 */
public expect fun LocalDateTime.toInstant(timeZone: TimeZone): Instant

/**
 * Returns an instant that corresponds to this civil date/time value that happens at the specified [UTC offset][offset].
 *
 * @see Instant.toLocalDateTime
 */
public expect fun LocalDateTime.toInstant(offset: UtcOffset): Instant

/**
 * Returns an instant that corresponds to the start of this date in the specified [timeZone].
 *
 * Note that it's not equivalent to `atTime(0, 0).toInstant(timeZone)`
 * because a day does not always start at the fixed time 0:00:00.
 */
public expect fun LocalDate.atStartOfDayIn(timeZone: TimeZone): Instant

public actual open class TimeZone internal constructor() {

    public actual companion object {

        public actual fun currentSystemDefault(): TimeZone =
            // TODO: probably check if currentSystemDefault name is parseable as FixedOffsetTimeZone?
            RegionTimeZone.currentSystemDefault()

        public actual val UTC: FixedOffsetTimeZone = UtcOffset.ZERO.asTimeZone()

        // org.threeten.bp.ZoneId#of(java.lang.String)
        public actual fun of(zoneId: String): TimeZone {
            // TODO: normalize aliases?
            if (zoneId == "Z") {
                return UTC
            }
            if (zoneId.length == 1) {
                throw IllegalTimeZoneException("Invalid zone ID: $zoneId")
            }
            try {
                if (zoneId.startsWith("+") || zoneId.startsWith("-")) {
                    return UtcOffset.parse(zoneId).asTimeZone()
                }
                if (zoneId == "UTC" || zoneId == "GMT" || zoneId == "UT") {
                    return FixedOffsetTimeZone(UtcOffset.ZERO, zoneId)
                }
                if (zoneId.startsWith("UTC+") || zoneId.startsWith("GMT+") ||
                    zoneId.startsWith("UTC-") || zoneId.startsWith("GMT-")
                ) {
                    val prefix = zoneId.take(3)
                    val offset = UtcOffset.parse(zoneId.substring(3))
                    return when (offset.totalSeconds) {
                        0 -> FixedOffsetTimeZone(offset, prefix)
                        else -> FixedOffsetTimeZone(offset, "$prefix$offset")
                    }
                }
                if (zoneId.startsWith("UT+") || zoneId.startsWith("UT-")) {
                    val offset = UtcOffset.parse(zoneId.substring(2))
                    return when (offset.totalSeconds) {
                        0 -> FixedOffsetTimeZone(offset, "UT")
                        else -> FixedOffsetTimeZone(offset, "UT$offset")
                    }
                }
            } catch (e: DateTimeFormatException) {
                throw IllegalTimeZoneException(e)
            }
            return RegionTimeZone.of(zoneId)
        }

        public actual val availableZoneIds: Set<String>
            get() = RegionTimeZone.availableZoneIds
    }

    public actual open val id: String
        get() = error("Should be overridden")

    public actual fun Instant.toLocalDateTime(): LocalDateTime = instantToLocalDateTime(this)
    public actual fun LocalDateTime.toInstant(): Instant = localDateTimeToInstant(this)

    internal open fun atStartOfDay(date: LocalDate): Instant = error("Should be overridden") //value.atStartOfDay(date)
    internal open fun offsetAtImpl(instant: Instant): UtcOffset = error("Should be overridden")

    internal open fun instantToLocalDateTime(instant: Instant): LocalDateTime = try {
        instant.toLocalDateTimeImpl(offsetAtImpl(instant))
    } catch (e: IllegalArgumentException) {
        throw DateTimeArithmeticException("Instant $instant is not representable as LocalDateTime.", e)
    }

    internal open fun localDateTimeToInstant(dateTime: LocalDateTime): Instant =
        atZone(dateTime).toInstant()

    internal open fun atZone(dateTime: LocalDateTime, preferred: UtcOffset? = null): ZonedDateTime =
        error("Should be overridden")

    override fun equals(other: Any?): Boolean =
        this === other || other is TimeZone && this.id == other.id

    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String = id
}

internal expect class RegionTimeZone : TimeZone {
    override val id: String
    override fun atStartOfDay(date: LocalDate): Instant
    override fun offsetAtImpl(instant: Instant): UtcOffset
    override fun atZone(dateTime: LocalDateTime, preferred: UtcOffset?): ZonedDateTime

    companion object {
        fun of(zoneId: String): RegionTimeZone
        fun currentSystemDefault(): RegionTimeZone
        val availableZoneIds: Set<String>
    }
}


public actual class FixedOffsetTimeZone internal constructor(public actual val offset: UtcOffset, override val id: String) : TimeZone() {

    public actual constructor(offset: UtcOffset) : this(offset, offset.toString())

    @Deprecated("Use offset.totalSeconds", ReplaceWith("offset.totalSeconds"))
    public actual val totalSeconds: Int get() = offset.totalSeconds

    override fun atStartOfDay(date: LocalDate): Instant =
        LocalDateTime(date, LocalTime.MIN).toInstant(offset)

    override fun offsetAtImpl(instant: Instant): UtcOffset = offset

    override fun atZone(dateTime: LocalDateTime, preferred: UtcOffset?): ZonedDateTime =
        ZonedDateTime(dateTime, this, offset)

    override fun instantToLocalDateTime(instant: Instant): LocalDateTime = instant.toLocalDateTime(offset)
    override fun localDateTimeToInstant(dateTime: LocalDateTime): Instant = dateTime.toInstant(offset)
}


public actual fun TimeZone.offsetAt(instant: Instant): UtcOffset =
    offsetAtImpl(instant)

public actual fun Instant.toLocalDateTime(timeZone: TimeZone): LocalDateTime =
    timeZone.instantToLocalDateTime(this)

internal actual fun Instant.toLocalDateTime(offset: UtcOffset): LocalDateTime = try {
    toLocalDateTimeImpl(offset)
} catch (e: IllegalArgumentException) {
    throw DateTimeArithmeticException("Instant ${this@toLocalDateTime} is not representable as LocalDateTime", e)
}

internal fun Instant.toLocalDateTimeImpl(offset: UtcOffset): LocalDateTime {
    val localSecond: Long = epochSeconds + offset.totalSeconds // overflow caught later
    val localEpochDay = localSecond.floorDiv(SECONDS_PER_DAY.toLong()).toInt()
    val secsOfDay = localSecond.mod(SECONDS_PER_DAY.toLong()).toInt()
    val date: LocalDate = LocalDate.fromEpochDays(localEpochDay) // may throw
    val time: LocalTime = LocalTime.ofSecondOfDay(secsOfDay, nanosecondsOfSecond)
    return LocalDateTime(date, time)
}

public actual fun LocalDateTime.toInstant(timeZone: TimeZone): Instant =
    timeZone.localDateTimeToInstant(this)

public actual fun LocalDateTime.toInstant(offset: UtcOffset): Instant =
    Instant(this.toEpochSecond(offset), this.nanosecond)

public actual fun LocalDate.atStartOfDayIn(timeZone: TimeZone): Instant =
    timeZone.atStartOfDay(this)

package dev.scottpierce.html.writer.style

import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

fun Duration.toCssString(): String {
    val seconds = toDouble(DurationUnit.SECONDS)
    val secondsInt = seconds.toInt()
    return if (seconds == secondsInt.toDouble()) {
        "${seconds.toInt()}s"
    } else {
        "${inWholeMilliseconds}ms"
    }
}

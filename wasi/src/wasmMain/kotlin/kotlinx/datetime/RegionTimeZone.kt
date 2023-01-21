/*
 * Copyright 2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kotlinx.datetime

internal actual class RegionTimeZone(actual override val id: String): TimeZone() {
    actual companion object {
        actual fun of(zoneId: String): RegionTimeZone {
            throw UnsupportedOperationException()
        }

        actual fun currentSystemDefault(): RegionTimeZone {
            throw UnsupportedOperationException()
        }

        actual val availableZoneIds: Set<String>
            get() {
                throw UnsupportedOperationException()
            }
    }

    actual override fun atStartOfDay(date: LocalDate): Instant {
        throw UnsupportedOperationException()
    }

    actual override fun atZone(dateTime: LocalDateTime, preferred: UtcOffset?): ZonedDateTime {
        throw UnsupportedOperationException()
    }

    actual override fun offsetAtImpl(instant: Instant): UtcOffset {
        throw UnsupportedOperationException()
    }

}
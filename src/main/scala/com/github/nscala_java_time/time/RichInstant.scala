/**
 * Copyright 2021 Pascal Meheut
 * Copyright 2009 Jorge Ortiz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/
package com.github.nscala_java_time.time

import java.time._
import com.github.nscala_java_time.PimpedType

class RichInstant(val underlying: Instant) extends AnyVal with Ordered[RichInstant] with PimpedType[Instant] {
  def -(duration: Long): Instant = underlying.minusMillis(duration)

  def -(duration: Duration): Instant = underlying.minus(duration)

  def +(duration: Long): Instant = underlying.plusMillis(duration)

  def +(duration: Duration): Instant = underlying.plus(duration)

  def milli: Long = underlying.toEpochMilli

  override def compare(that: RichInstant): Int = underlying.compareTo(that.underlying)

  def toLocalDate(zoneId: ZoneId = ZoneId.systemDefault()): LocalDate =  toZonedDateTime(zoneId).toLocalDate()

  def toLocalDateTime(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime =  toZonedDateTime(zoneId).toLocalDateTime()

  def toZonedDateTime(zoneId: ZoneId = ZoneId.systemDefault()): ZonedDateTime =  underlying.atZone(zoneId)

  def toDate(): java.util.Date = java.util.Date.from(underlying)
}

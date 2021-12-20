/**
  * Copyright 2021 Pascal Meheut
  * Copyright 2009 Jorge Ortiz
  * Copyright 2009 Barry Kaplan
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  *
  * */
package com.github.nscala_java_time.time

import java.time._

import com.github.nscala_java_time.PimpedType

class RichLocalDate(val underlying: LocalDate) extends AnyVal with Ordered[RichLocalDate] with PimpedType[LocalDate] {

  def -(period: Period): LocalDate = underlying.minus(period)

  def -(duration: Duration): LocalDate = underlying.minus(duration)

  def +(period: Period): LocalDate = underlying.plus(period)

  def +(duration: Duration): LocalDate = underlying.plus(duration)

  def day = underlying.getDayOfMonth

  def month = underlying.getMonth

  def year = underlying.getYear

  def withDay(day: Int) = underlying.withDayOfMonth(day)

  def withMonth(month: Int) = underlying.withMonth(month)

  def withYear(year: Int) = underlying.withYear(year)

  override def compare(that: RichLocalDate): Int = underlying.compareTo(that.underlying)

  def toInstant(zoneId: ZoneId = ZoneId.systemDefault()): java.time.Instant = underlying.atStartOfDay().atZone(zoneId).toInstant()

  def toDate(zoneId: ZoneId = ZoneId.systemDefault()): java.util.Date = java.util.Date.from(toInstant(zoneId))

  def toLocalDate(): LocalDateTime = underlying.atStartOfDay()
}

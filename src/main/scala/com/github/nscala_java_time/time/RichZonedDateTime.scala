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

import java.time.temporal.ChronoUnit

class RichZonedDateTime(val underlying: ZonedDateTime) extends AnyVal with PimpedType[ZonedDateTime] {

  def -(duration: Long): ZonedDateTime = underlying.minus(duration, ChronoUnit.MILLIS)

  def -(duration: Duration): ZonedDateTime = underlying.minus(duration)

  def -(period: Period): ZonedDateTime = underlying.minus(period)

  def +(duration: Long): ZonedDateTime = underlying.plus(duration, ChronoUnit.MILLIS)

  def +(duration: Duration): ZonedDateTime = underlying.plus(duration)

  def +(period: Period): ZonedDateTime = underlying.plus(period)

  def millis = underlying.toInstant.toEpochMilli

  def second = underlying.getSecond

  def minute = underlying.getMinute

  def hour = underlying.getHour

  def day = underlying.getDayOfMonth

  def month = underlying.getMonthValue

  def year = underlying.getYear

  def withSecond(second: Int) = underlying.withSecond(second)

  def withMinute(minute: Int) = underlying.withMinute(minute)

  def withHour(hour: Int) = underlying.withHour(hour)

  def withDay(day: Int) = underlying.withDayOfMonth(day)

  def withMonth(month: Int) = underlying.withMonth(month)

  def withYear(year: Int) = underlying.withYear(year)
}

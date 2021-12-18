/**
  * Copyright 2021 Pascal Meheut
  * Copyright 2009 Jorge Ortiz
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

class RichLocalDateTime(val underlying: LocalDateTime) extends AnyVal with PimpedType[LocalDateTime] {

  def -(duration: Duration): LocalDateTime = underlying.minus(duration)

  def -(period: Period): LocalDateTime = underlying.minus(period)

  def +(duration: Duration): LocalDateTime = underlying.plus(duration)

  def +(period: Period): LocalDateTime = underlying.plus(period)

  def second = underlying.getSecond

  def minute = underlying.getMinute

  def hour = underlying.getHour

  def day = underlying.getDayOfMonth

  def month = underlying.getMonth

  def year = underlying.getMonth

  def withSecond(second: Int) = underlying.withSecond(second)

  def withMinute(minute: Int) = underlying.withMinute(minute)

  def withHour(hour: Int) = underlying.withHour(hour)

  def withDay(day: Int) = underlying.withDayOfMonth(day)

  def withMonth(month: Int) = underlying.withMonth(month)

  def withYear(year: Int) = underlying.withYear(year)
}

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

class RichInt(val underlying: Int) extends AnyVal with PimpedType[Int] {
  // These units of time can only be durations
  def millis  = Duration.ofMillis(underlying)
  def seconds = Duration.ofSeconds(underlying)
  def minutes = Duration.ofMinutes(underlying)
  def hours   = Duration.ofHours(underlying)

  // These units of time can only be periods
  def days   = Period.ofDays(underlying)
  def weeks  = Period.ofWeeks(underlying)
  def months = Period.ofMonths(underlying)
  def years  = Period.ofYears(underlying)

  // See above.
  def milli  = Duration.ofMillis(underlying)
  def second = Duration.ofSeconds(underlying)
  def minute = Duration.ofMinutes(underlying)
  def hour  = Duration.ofHours(underlying)

  // See above.
  def day   = Period.ofDays(underlying)
  def week  = Period.ofWeeks(underlying)
  def month = Period.ofMonths(underlying)
  def year  = Period.ofYears(underlying)

  def *(period: Period) = period.multipliedBy(underlying)
}

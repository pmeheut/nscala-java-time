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
import com.github.nscala_java_time.time.Implicits._

import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
object StaticZonedDateTime extends StaticZonedDateTime

trait StaticZonedDateTime {
  def now()        = ZonedDateTime.now()
  def now(zone: ZoneId) = ZonedDateTime.now(zone)
  def parse(str: String) = ZonedDateTime.parse(str)
  def parse(str: String, formatter: DateTimeFormatter) = ZonedDateTime.parse(str, formatter)

  def nextSecond() = now().plus(1, ChronoUnit.SECONDS)
  def nextMinute() = now().plus(1, ChronoUnit.MINUTES)
  def nextHour()   = now().plus(1, ChronoUnit.HOURS)
  def nextDay()    = now().plus(1, ChronoUnit.DAYS)
  def tomorrow()   = now().plus(1, ChronoUnit.DAYS)
  def nextWeek()   = now().plus(1, ChronoUnit.WEEKS)
  def nextMonth()  = now().plus(1, ChronoUnit.MONTHS)
  def nextYear()   = now().plus(1, ChronoUnit.YEARS)

  def lastSecond() = now().minus(1, ChronoUnit.SECONDS)
  def lastMinute() = now().minus(1, ChronoUnit.MINUTES)
  def lastHour()   = now().minus(1, ChronoUnit.HOURS)
  def lastDay()    = now().minus(1, ChronoUnit.DAYS)
  def yesterday()  = now().minus(1, ChronoUnit.DAYS)
  def lastWeek()   = now().minus(1, ChronoUnit.WEEKS)
  def lastMonth()  = now().minus(1, ChronoUnit.MONTHS)
  def lastYear()   = now().minus(1, ChronoUnit.YEARS)
}

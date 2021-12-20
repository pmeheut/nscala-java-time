/** Copyright 2021 Pascal Meheut Copyright 2009 Jorge Ortiz Copyright 2009 Barry Kaplan
  *
  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
  * in compliance with the License. You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software distributed under the
  * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
  * express or implied. See the License for the specific language governing permissions and
  * limitations under the License.
  */
package com.github.nscala_java_time.time

import com.github.nscala_java_time.time.Implicits._

import java.time._
import java.time.format.DateTimeFormatter

object StaticLocalDate extends StaticLocalDate

trait StaticLocalDate {
  def apply(year: Int, month: Int, dayOfMonth: Int) = LocalDate.of(year, month, dayOfMonth)
  def ofDate(date: java.util.Date, zoneId: ZoneId = ZoneId.systemDefault()): LocalDate = date.toInstant().atZone(zoneId).toLocalDate();

  def now() = LocalDate.now()
  def now(zone: ZoneId) = LocalDate.now(zone)
  def today() = now().atStartOfDay()
  def parse(str: String) = LocalDate.parse(str)
  def parse(str: String, formatter: DateTimeFormatter) = LocalDate.parse(str, formatter)

  def nextDay() = now() + 1.day
  def tomorrow() = now() + 1.day
  def nextWeek() = now() + 1.week
  def nextMonth() = now() + 1.month
  def nextYear() = now() + 1.year

  def lastDay() = now() - 1.day
  def yesterday() = now() - 1.day
  def lastWeek() = now() - 1.week
  def lastMonth() = now() - 1.month
  def lastYear() = now() - 1.year
}

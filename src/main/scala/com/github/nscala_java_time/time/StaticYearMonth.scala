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
import java.time.format.DateTimeFormatter

object StaticYearMonth extends StaticYearMonth

trait StaticYearMonth {
  def apply(year: Int, month: Int = 1) = MonthDay.of(year, month)
  def now() = YearMonth.now()
  def now(zone: ZoneId) = YearMonth.now(zone)
  def parse(str: String) = YearMonth.parse(str)
  def parse(str: String, formatter: DateTimeFormatter) = YearMonth.parse(str, formatter)
}


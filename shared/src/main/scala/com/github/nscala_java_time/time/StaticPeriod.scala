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

object StaticPeriod extends StaticPeriod

trait StaticPeriod {
  // Build with RichInt and + operator in RichPeriod
  def parse(str: String) = Period.parse(str)

  def days(days: Int) = Period.ofDays(days)
  def between(start: LocalDate, end: LocalDate) = Period.between(start, end)
  def months(months: Int) = Period.ofMonths(months)
  def weeks(weeks: Int) = Period.ofWeeks(weeks)
  def years(years: Int) = Period.ofYears(years)
}

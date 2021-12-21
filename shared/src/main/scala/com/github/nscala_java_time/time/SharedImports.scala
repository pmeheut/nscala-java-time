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

trait SharedImports extends SharedTypeImports with SharedStaticForwarderImports with Implicits

trait SharedTypeImports {
  type Instant = java.time.Instant
  type ZonedDateTime = java.time.ZonedDateTime
  type DateTimeFormatter = java.time.format.DateTimeFormatter
  type ZoneId = java.time.ZoneId
  type Duration = java.time.Duration
  type LocalDate = java.time.LocalDate
  type LocalDateTime = java.time.LocalDateTime
  type LocalTime = java.time.LocalTime
  type Period = java.time.Period
  type YearMonth = java.time.YearMonth
  type MonthDay = java.time.MonthDay
}

trait SharedStaticForwarderImports {
  val LocalDate = com.github.nscala_java_time.time.StaticLocalDate
  val LocalDateTime = com.github.nscala_java_time.time.StaticLocalDateTime
  val ZonedDateTime = com.github.nscala_java_time.time.StaticZonedDateTime
  val Instant = com.github.nscala_java_time.time.StaticInstant
  val LocalTime = com.github.nscala_java_time.time.StaticLocalTime
  val YearMonth = com.github.nscala_java_time.time.StaticYearMonth
  val MonthDay = com.github.nscala_java_time.time.StaticMonthDay
  val DateTimeFormatter = com.github.nscala_java_time.time.StaticDateTimeFormatter
  val ZoneId = com.github.nscala_java_time.time.StaticZoneId
  val Duration = com.github.nscala_java_time.time.StaticDuration
  val Period = com.github.nscala_java_time.time.StaticPeriod
}

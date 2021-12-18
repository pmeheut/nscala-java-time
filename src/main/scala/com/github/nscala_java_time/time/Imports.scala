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

object Imports extends Imports

object TypeImports extends TypeImports

object StaticForwarderImports extends StaticForwarderImports

trait Imports extends TypeImports with StaticForwarderImports with Implicits

trait TypeImports {
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

trait StaticForwarderImports {
  val DateTime = com.github.nscala_java_time.time.StaticZonedDateTime
  val DateTimeFormat = com.github.nscala_java_time.time.StaticDateTimeFormatter
  val DateTimeZone = com.github.nscala_java_time.time.StaticZoneId
  val Duration = com.github.nscala_java_time.time.StaticDuration
  val LocalDate = com.github.nscala_java_time.time.StaticLocalDate
  val LocalDateTime = com.github.nscala_java_time.time.StaticLocalDateTime
  val LocalTime = com.github.nscala_java_time.time.StaticLocalTime
  val Period = com.github.nscala_java_time.time.StaticPeriod
  val YearMonth = com.github.nscala_java_time.time.StaticYearMonth
  val MonthDay = com.github.nscala_java_time.time.StaticMonthDay
}

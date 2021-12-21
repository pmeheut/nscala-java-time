package com.github.nscala_java_time.time

object Imports extends Imports

object TypeImports extends TypeImports

object StaticForwarderImports extends StaticForwarderImports

trait Imports extends TypeImports with JsStaticForwarderImports with Implicits

trait TypeImports extends SharedTypeImports

trait StaticForwarderImports extends JsStaticForwarderImports

trait JsStaticForwarderImports {
  val LocalDate = com.github.nscala_java_time.time.JsStaticLocalDate
  val LocalDateTime = com.github.nscala_java_time.time.JsStaticLocalDateTime
  val ZonedDateTime = com.github.nscala_java_time.time.StaticZonedDateTime
  val Instant = com.github.nscala_java_time.time.JsStaticInstant
  val LocalTime = com.github.nscala_java_time.time.JsStaticLocalTime
  val YearMonth = com.github.nscala_java_time.time.JsStaticYearMonth
  val MonthDay = com.github.nscala_java_time.time.JsStaticMonthDay
  val DateTimeFormatter = com.github.nscala_java_time.time.StaticDateTimeFormatter
  val ZoneId = com.github.nscala_java_time.time.StaticZoneId
  val Duration = com.github.nscala_java_time.time.StaticDuration
  val Period = com.github.nscala_java_time.time.StaticPeriod
}

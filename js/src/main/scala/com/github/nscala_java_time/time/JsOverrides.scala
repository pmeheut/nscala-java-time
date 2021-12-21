package com.github.nscala_java_time.time

import java.time.{Instant, LocalDate, LocalDateTime, LocalTime, MonthDay, YearMonth}

object JsStaticLocalDate extends JsStaticLocalDate

trait JsStaticLocalDate extends StaticLocalDate {
  override def now() = {
    val d = new scala.scalajs.js.Date()
    LocalDate.of(d.getFullYear().toInt, d.getMonth().toInt + 1, d.getDate().toInt)
  }
}

object JsStaticLocalDateTime extends JsStaticLocalDateTime

trait JsStaticLocalDateTime extends StaticLocalDateTime {
  override def now() = {
    val d = new scala.scalajs.js.Date()
    LocalDateTime.of(d.getFullYear().toInt, d.getMonth().toInt + 1, d.getDate().toInt,
      d.getHours().toInt, d.getMinutes().toInt, d.getSeconds().toInt)
  }
}

object JsStaticYearMonth extends JsStaticYearMonth

trait JsStaticYearMonth extends StaticYearMonth {
  override def now() = {
    val d = new scala.scalajs.js.Date()
    YearMonth.of(d.getFullYear().toInt, d.getMonth().toInt + 1)
  }
}

object JsStaticMonthDay extends JsStaticMonthDay

trait JsStaticMonthDay extends StaticMonthDay {
  override def now() = {
    val d = new scala.scalajs.js.Date()
    MonthDay.of(d.getMonth().toInt + 1, d.getDate().toInt)
  }
}

object JsStaticLocalTime extends JsStaticLocalTime

trait JsStaticLocalTime extends StaticLocalTime {
  override def now() = {
    val d = new scala.scalajs.js.Date()
    LocalTime.of(d.getHours().toInt, d.getMinutes().toInt, d.getSeconds().toInt)
  }
}

object JsStaticInstant extends JsStaticInstant

trait JsStaticInstant extends StaticInstant {
  override def now() = {
    val d = new scala.scalajs.js.Date()
    Instant.ofEpochMilli(d.getTime().toLong)
  }
}
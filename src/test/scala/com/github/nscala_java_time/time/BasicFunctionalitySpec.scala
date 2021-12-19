package com.github.nscala_java_time.time

import com.github.nscala_java_time.time.Implicits._
import org.scalacheck.{Prop, Properties}
import java.time._

object BasicFunctionalitySpec extends Properties("DateTime") {

  property("DateTime.now() == DateTime.now()") = Prop.secure {
    val now: ZonedDateTime = ZonedDateTime.now()
    now == now
  }

  property("DateTime.now() < (DateTime.now() + 1.hours)") = Prop.secure {
    val now: ZonedDateTime = ZonedDateTime.now()
    (now plusHours 1) isAfter now
  }

  property("have setters") = Prop.secure {
    val actual = ZonedDateTime.parse("2012-01-01T01:01:01.123+0900")
      .withYear(2013)
      .withMonth(3)
      .withDay(2)
      .withHour(7)
      .withMinute(8)
      .withSecond(9)
    val expected = ZonedDateTime.parse("2013-03-02T07:08:09.123+0900")
    actual == expected
  }

  property("have setters using millis") = Prop.secure {
    val actual = ZonedDateTime.parse("2012-01-01T01:01:01.123+0900")
      .withYear(2013)
      .withMonth(3)
      .withDay(2)
      .withHour(7)
      .withMinute(8)
      .withSecond(9)
      .withNano(500 * 1000000)
    val expected = ZonedDateTime.parse("2013-03-02T07:08:09.500+0900")
    actual == expected
  }

}

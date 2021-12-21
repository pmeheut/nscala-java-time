package com.github.nscala_java_time.time

import com.github.nscala_java_time.time.Implicits._
import java.time._

class BasicFunctionalitySuite extends munit.FunSuite {

  test("have setters") {
    val actual = ZonedDateTime.parse("2012-01-01T01:01:01.123+09:00")
      .withYear(2013)
      .withMonth(3)
      .withDay(2)
      .withHour(7)
      .withMinute(8)
      .withSecond(9)
    val expected = ZonedDateTime.parse("2013-03-02T07:08:09.123+09:00")
    assertEquals(actual, expected)
  }

  test("have setters using millis") {
    val actual = ZonedDateTime.parse("2012-01-01T01:01:01.123+09:00")
      .withYear(2013)
      .withMonth(3)
      .withDay(2)
      .withHour(7)
      .withMinute(8)
      .withSecond(9)
      .withNano(500 * 1000000)
    val expected = ZonedDateTime.parse("2013-03-02T07:08:09.500+09:00")
    assertEquals(actual, expected)
  }
}

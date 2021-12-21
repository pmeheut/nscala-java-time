package com.github.nscala_java_time.time

import java.time._
import com.github.nscala_java_time.time.Implicits._

class RichStringSuite extends munit.FunSuite {

  test("String to DateTime") {
    assertEquals("2012-08-08T00:00:00".toLocalDateTime(), LocalDateTime.parse("2012-08-08T00:00:00"))
  }

  test(""" "" yield None """) {
    assertEquals("".toDateTimeOption("dd/MM/yyycy"), None)
  }

  test(""" "2012-08-08" should parse""") {
    assertEquals("2012-08-08".toLocalDate(), LocalDate.parse("2012-08-08"))
  }

  test(""" "2012-08-08" should yield Some[LocalDate] """) {
    assertEquals("2012-08-08".toLocalDateOption(), Some(LocalDate.parse("2012-08-08")))
  }

  test(""" "" should yield None """) {
    assertEquals("".toLocalDateOption(), None)
  }
}

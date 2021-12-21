package com.github.nscala_java_time.time

import munit.BaseFunSuite


trait AbtractNowSuite extends BaseFunSuite {
  val LocalDateTime: StaticLocalDateTime
  val LocalDate: StaticLocalDate

  test("LocalDateTime.now() == LocalDateTime.now()") {
    val now = LocalDateTime.now()
    assertEquals(now, now)
  }

  test("LocalDateTime.now() < (LocalDateTime.now() + 1.hours)")  {
    val now = LocalDateTime.now()
    assert((now plusHours 1) isAfter now)
  }

  test("LocalDateTime")  {
    val now = LocalDateTime.now()
    val l = List(now.withSecond(0), now.withSecond(3), now.withSecond(10), now.withSecond(1))
    assertEquals(l.sorted, List(now.withSecond(0), now.withSecond(1), now.withSecond(3), now.withSecond(10)))
    assertEquals(l.max, now.withSecond(10))
  }

  test("LocalDate") {
    val today = LocalDate.now()
    val l = List(today.withDayOfMonth(1), today.withDayOfMonth(3), today.withDayOfMonth(10), today.withDayOfMonth(2))
    assertEquals(l.sorted, List(today.withDayOfMonth(1), today.withDayOfMonth(2), today.withDayOfMonth(3), today.withDayOfMonth(10)))
    assertEquals(l.max, today.withDayOfMonth(10))
  }
}

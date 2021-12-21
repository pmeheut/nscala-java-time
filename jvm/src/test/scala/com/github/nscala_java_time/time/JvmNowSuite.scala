package com.github.nscala_java_time.time

class JvmNowSuite extends munit.FunSuite with AbtractNowSuite {
  val LocalDateTime = Imports.LocalDateTime
  val LocalDate = Imports.LocalDate
}

package com.github.nscala_java_time.time

import com.github.nscala_java_time.time.Imports.LocalDateTime

class JsNowSuite extends munit.FunSuite with AbtractNowSuite {
  val LocalDateTime = Imports.LocalDateTime
  val LocalDate = Imports.LocalDate
}

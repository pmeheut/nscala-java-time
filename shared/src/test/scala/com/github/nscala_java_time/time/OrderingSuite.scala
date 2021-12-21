package com.github.nscala_java_time.time

import com.github.nscala_java_time.time.Implicits.*

class OrderingSuite extends munit.FunSuite {
  test("Duration")  {
    val l = List(1.second, 5.seconds, 2.seconds, 4.seconds)
    assert(l.sorted == List(1.second, 2.seconds, 4.seconds, 5.seconds))
    assertEquals(l.max, 5.seconds)
  }
}

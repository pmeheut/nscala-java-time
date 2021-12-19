package com.github.nscala_java_time.time

import com.github.nscala_java_time.time.Implicits._
import java.time._
import org.scalacheck.{Prop, Properties}

object OrderingSpec extends Properties("Ordering") {

  property("DateTime") = Prop.secure {
    val now = ZonedDateTime.now()
    val l = List(now.withSecond(0), now.withSecond(3), now.withSecond(10), now.withSecond(1))
    assert(l.sorted == List(now.withSecond(0), now.withSecond(1), now.withSecond(3), now.withSecond(10)))
    l.max == now.withSecond(10)
  }

  property("LocalDate") = Prop.secure {
    val today = LocalDate.now()
    val l = List(today.withDayOfMonth(1), today.withDayOfMonth(3), today.withDayOfMonth(10), today.withDayOfMonth(2))
    assert(l.sorted == List(today.withDayOfMonth(1), today.withDayOfMonth(2), today.withDayOfMonth(3), today.withDayOfMonth(10)))
    l.max == today.withDayOfMonth(10)
  }

  property("Duration") = Prop.secure {
    val l = List(1.second, 5.seconds, 2.seconds, 4.seconds)
    assert(l.sorted == List(1.second, 2.seconds, 4.seconds, 5.seconds))
    l.max == 5.seconds
  }

}

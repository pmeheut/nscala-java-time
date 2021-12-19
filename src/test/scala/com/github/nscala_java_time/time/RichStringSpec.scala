package com.github.nscala_java_time.time

import java.time._
import com.github.nscala_java_time.time.Implicits._
import org.scalacheck._

object RichStringSpec extends Properties("RichString") {

  property("String to DateTime") = Prop.secure {
    "2012-08-08".toLocalDateTime == LocalDateTime.parse("2012-08-08")
  }

  property(""" "2012-08-08" should yield Some[DateTime] """) = Prop.secure {
    "2012-08-08".toDateTimeOption == Some(ZonedDateTime.parse("2012-08-08"))
  }

  property(""" "" yield None """) = Prop.secure {
    "".toDateTimeOption == None
  }

  property(""" "2012-08-08" should parse""") = Prop.secure {
    "2012-08-08".toLocalDate == LocalDate.parse("2012-08-08")
  }

  property(""" "2012-08-08" should yield Some[LocalDate] """) = Prop.secure {
    "2012-08-08".toLocalDateOption == Some(LocalDate.parse("2012-08-08"))
  }

  property(""" "" should yield None """) = Prop.secure {
    "".toLocalDateOption == None
  }
}

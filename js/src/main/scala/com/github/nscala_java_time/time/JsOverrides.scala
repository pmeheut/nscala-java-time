package com.github.nscala_java_time.time

import java.time.LocalDate

object JsStaticLocalDate extends JsStaticLocalDate

trait JsStaticLocalDate extends StaticLocalDate {
  override def now() = LocalDate.now()
}

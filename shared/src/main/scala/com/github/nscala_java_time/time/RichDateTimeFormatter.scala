/**
 * Copyright 2021 Pascal Meheut
 * Copyright 2009 Jorge Ortiz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/
package com.github.nscala_java_time.time

import com.github.nscala_java_time.PimpedType
import scala.util.Try

import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor

class RichDateTimeFormatter(val underlying: DateTimeFormatter) extends AnyVal
  with PimpedType[DateTimeFormatter] {

  def locale = underlying.getLocale

  def zone = underlying.getZone

  def parseOption(text: String): Option[TemporalAccessor] = Try(underlying.parse(text)).toOption
}

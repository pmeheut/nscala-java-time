/**
  * Copyright 2021 Pascal Meheut
  * Copyright 2009 Jorge Ortiz
  * Copyright 2009 Barry Kaplan
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  *
  * */
package com.github.nscala_java_time.time

import java.time._
import java.time.format.DateTimeFormatter

object Implicits extends Implicits

object IntImplicits extends IntImplicits

object StringImplicits extends StringImplicits

object OrderingImplicits extends OrderingImplicits

object ScalaJavaTimeImplicits extends ScalaJavaTimeImplicits

trait Implicits extends IntImplicits with StringImplicits with OrderingImplicits with ScalaJavaTimeImplicits

trait IntImplicits {
  implicit def richInt(n: Int): RichInt = new com.github.nscala_java_time.time.RichInt(n)

  implicit def richLong(n: Long): RichLong = new com.github.nscala_java_time.time.RichLong(n)
}

trait StringImplicits {
  implicit def richString(s: String): RichString = new com.github.nscala_java_time.time.RichString(s)
}

trait OrderingImplicits {
  implicit val ZonedDateTimeOrdering: Ordering[ZonedDateTime] = (x: ZonedDateTime, y: ZonedDateTime) => x.compareTo(y)
  implicit val LocalDateOrdering: Ordering[LocalDate] = (x: LocalDate, y: LocalDate) => x.compareTo(y)
  implicit val LocalDateTimeOrdering: Ordering[LocalDateTime] = (x: LocalDateTime, y: LocalDateTime) => x.compareTo(y)
}


trait ScalaJavaTimeImplicits {
  implicit def richZonedDateTime(dt: ZonedDateTime): RichZonedDateTime = new RichZonedDateTime(dt)

  implicit def richDateTimeFormatter(fmt: DateTimeFormatter): RichDateTimeFormatter = new RichDateTimeFormatter(fmt)

  implicit def richDateTimeZone(zone: ZoneId): RichZoneId = new RichZoneId(zone)

  implicit def richDuration(dur: Duration): RichDuration = new RichDuration(dur)

  implicit def richInstant(in: Instant): RichInstant = new RichInstant(in)

  implicit def richLocalDate(ld: LocalDate): RichLocalDate = new RichLocalDate(ld)

  implicit def richLocalDateTime(dt: LocalDateTime): RichLocalDateTime = new RichLocalDateTime(dt)

  implicit def richLocalTime(lt: LocalTime): RichLocalTime = new RichLocalTime(lt)

  implicit def richPeriod(per: Period): RichPeriod = new RichPeriod(per)
}

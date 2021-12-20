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

import java.time._
import com.github.nscala_java_time.PimpedType

import java.time.temporal.ChronoUnit

class RichDuration(val underlying: Duration) extends AnyVal with Ordered[RichDuration] with PimpedType[Duration] {

  def days: Long = underlying.toDays

  def hours: Long = underlying.toHours

  def millis: Long = underlying.toMillis

  def minutes: Long = underlying.toMinutes

  def seconds: Long = underlying.toMillis/1000

  def unary_- : Duration = underlying.negated

  def -(amount: Long): Duration = underlying.minus(amount, ChronoUnit.MILLIS)

  def -(amount: Duration): Duration = underlying.minus(amount)

  def +(amount: Long): Duration = underlying.plus(amount, ChronoUnit.MILLIS)

  def +(amount: Duration): Duration = underlying.plus(amount)

  def /(divisor: Long): Duration = underlying.dividedBy(divisor)

  def *(multiplicand: Long): Duration = underlying.multipliedBy(multiplicand)

  override def compare(that: RichDuration): Int = underlying.compareTo(that.underlying)
}

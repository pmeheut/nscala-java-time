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

class RichPeriod(val underlying: Period) extends AnyVal with PimpedType[Period] {

  def days: Int = underlying.getDays

  def months: Int = underlying.getMonths

  def years: Int = underlying.getYears

  def unary_- : Period = underlying.negated

  def -(period: Period): Period = underlying.minus(period)

  def +(period: Period): Period = underlying.plus(period)

  def *(scalar: Int): Period = underlying.multipliedBy(scalar)

  def ago(): ZonedDateTime = StaticZonedDateTime.now().minus(underlying)

  def later(): ZonedDateTime = StaticZonedDateTime.now().plus(underlying)

  def from(dt: ZonedDateTime): ZonedDateTime = dt.plus(underlying)

  def before(dt: ZonedDateTime): ZonedDateTime = dt.minus(underlying)
}

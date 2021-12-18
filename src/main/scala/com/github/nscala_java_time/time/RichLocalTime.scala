/**
 * Copyright 2009 Barry Kaplan
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

class RichLocalTime(val underlying: LocalTime) extends AnyVal with PimpedType[LocalTime] {

  def -(period: Period): LocalTime = underlying.minus(period)

  def -(duration: Duration): LocalTime = underlying.minus(duration)

  def +(period: Period): LocalTime = underlying.plus(period)

  def +(duration: Duration): LocalTime = underlying.plus(duration)

  def withSecond(second: Int) = underlying.withSecond(second)

  def withMinute(minute: Int) = underlying.withMinute(minute)

  def withHour(hour: Int) = underlying.withHour(hour)
}

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

object StaticDuration extends StaticDuration

trait StaticDuration {
  def parse(str: String) = Duration.parse(str)
  def standardDays(days: Long) = Duration.ofDays(days)
  def standardHours(hours: Long) = Duration.ofHours(hours)
  def standardMinutes(minutes: Long) = Duration.ofMinutes(minutes)
  def standardSeconds(seconds: Long) = Duration.ofSeconds(seconds)
  def millis(millis: Long) = Duration.ofMillis(millis)
}

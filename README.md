# nscala-java-time
#[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.nscala-time/nscala-time_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.nscala-time/nscala-time_2.12)
#[![scaladoc](https://javadoc.io/badge2/com.github.nscala-time/nscala-time_3/javadoc.svg)](https://javadoc.io/doc/com.github.nscala-time/nscala-time_3)

A Scala wrapper for [cquiroz/scala-java-time]. This project forked from [nscala-time](https://github.com/nscala-time/nscala-time/ "scala-time") 
It was then adapted to support this Scala implementation of the Java 8 Time library instead of JodaTime hence supporting Scala.js. 


## Installation

Add the following to your sbt build:

```scala
libraryDependencies += "com.github.nscala-java-time" %% "nscala-java-time" % "0.1.0"
```

## Release Note

### 0.1.0
Creation from [nscala-time 2.3.0](https://github.com/nscala-time/nscala-time/tree/0eae4c573748317a600ff946c6f1823009b95a7f)

### Version Numbering Policy

`x.y.z`, each letter is digit, format is used as version number.  Meanings of `x` is not determined yet.  
`y` means major-version.  Note that `y` is even number in any version of released `nscala-time`.  If `y` is odd, 
it's development and/or SNAPSHOT version.  `z` is mainly used for bug fix releases.  Currently, the value of `z` is 0
in most cases.

## Usage

This is mostly a convenience wrapper around the Scala Java Time library, adding
more pleasant syntax like operators for addition, subtraction, and comparison.

### Import

```scala
import com.github.nscala_java_time.time.Imports._
```


### Date/Time Operations
```scala
LocalDateTime.now() + 2.months // returns org.joda.time.DateTime = 2009-06-27T13:25:59.195-07:00

LocalDateTime.nextMonth < LocalDateTime.now() + 2.months // returns Boolean = true

2.hours + 45.minutes + 10.seconds // returns java.time.Duration

(2.hours + 45.minutes + 10.seconds).millis // returns Long = 9910000

2.months + 3.days // returns Period
```


### Fluent interface
```scala
LocalDateTime.now() // returns java.time.LocalDateTime = 2009-04-27T13:25:42.659-07:00

LocalDateTime.now().withHour(2).withMinute(45).withSecond(10) // returns java.time.LocalDateTime = 2009-04-27T02:45:10.313-07:00
```


Please see the Java 8 time API for full explanation of key concepts or http://cquiroz.github.io/scala-java-time/


## Documents

# - [scaladoc (latest stable release)](https://javadoc.io/doc/com.github.nscala-time/nscala-time_3)

## Motivation

cquiroz/scala-java-time is a great library to use the same API in ScalaJS cross-projects, especially because this is the standard Java 8 API.
Adding idiomatic scala functions such as direct comparison with <, <=, etc and adding periods and durations with + is a big bonus.

val Scala213 = "2.13.7"
val unusedWarnings = "-Ywarn-unused" :: Nil

console / initialCommands += {
  Iterator("java.time._", "com.github.nscala_java_time.time.Imports._").map("import " +).mkString("\n")
}

ThisBuild / version := "0.1.1"
ThisBuild / sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
ThisBuild / organization := "io.github.pmeheut"
ThisBuild / sonatypeProfileName := "io.github.pmeheut"
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / publishConfiguration := publishConfiguration.value.withOverwrite(true)
ThisBuild / publishTo := sonatypePublishTo.value

publishMavenStyle := true

lazy val root = project
  .in(file("."))
  .settings(
    name := "nscala-java-time",
    publishArtifact := false
  )
  .aggregate(nscalaJavaTime.js, nscalaJavaTime.jvm)

lazy val nscalaJavaTime = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .jvmSettings(
  )
  .jsSettings(
  )
  .settings(
    name := "nscala-java-time",
    libraryDependencies ++= Seq(
      "io.github.cquiroz" %%% "scala-java-time" % "2.3.0",
      "org.scalameta" %%% "munit" % "1.0.0-M1" % Test
    ),
    scalaVersion := Scala213,
    crossScalaVersions := Seq("3.1.0"),
      pomExtra := (
      <url>https://github.com/nscala-java-time/nscala-java-time</url>
        <licenses>
          <license>
            <name>Apache</name>
            <url>http://www.opensource.org/licenses/Apache-2.0</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
        <scm>
          <url>git@github.com:pmeheut/nscala-java-time.git</url>
          <connection>scm:git:git@github.com:pmeheut/nscala-java-time.git</connection>
        </scm>
        <developers>
          <developer>
            <id>pmeheut</id>
            <name>Pascal Meheut</name>
            <url>https://github.com/pmeheut</url>
          </developer>
        </developers>
      )
  )


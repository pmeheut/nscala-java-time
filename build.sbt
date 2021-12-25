val isScala3 = Def.setting(
  CrossVersion.partialVersion(scalaVersion.value).exists(_._1 == 3)
)

val Scala213 = "2.13.7"
val unusedWarnings = "-Ywarn-unused" :: Nil

console / initialCommands += {
  Iterator("java.time._", "com.github.nscala_java_time.time.Imports._").map("import " +).mkString("\n")
}

def gitHashOrBranch: String = scala.util.Try(
  sys.process.Process("git rev-parse HEAD").lineStream_!.head
).getOrElse("master")

ThisBuild / sonatypeRepository := "https://s01.oss.sonatype.org/service/local"
ThisBuild / sonatypeCredentialHost := "s01.oss.sonatype.org"
ThisBuild / organization := "io.github.pmeheut"
ThisBuild / sonatypeProfileName := "io.github.pmeheut"
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / publishConfiguration := publishConfiguration.value.withOverwrite(true)
ThisBuild / publishTo := sonatypePublishToBundle.value
publishMavenStyle := true

lazy val root = project
  .in(file("."))
  .settings(
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
    // sbt "release cross"
    crossScalaVersions := Seq(Scala213, "3.1.0"),
    scalacOptions ++= {
      Seq(
        "-unchecked",
        "-deprecation",
        "-feature",
        "-language:implicitConversions,higherKinds",
      ) ++ (if (isScala3.value) Seq() else Seq("-Xlint")) ++
        (PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)) {
          case Some((2, v)) if v <= 12 => Seq("-Xfuture")
        }.toList.flatten) ++
        (PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)) {
          case Some((2, scalaMajor)) if scalaMajor >= 11 =>
            unusedWarnings ++ Seq(
              "-Xsource:3"
            )
        }.toList.flatten)
    },
    Seq(Compile, Test).flatMap(c =>
      c / console / scalacOptions ~= {
        _.filterNot(unusedWarnings.toSet)
      }
    ),
    Compile / doc / scalacOptions ++= {
      if (isScala3.value) {
        Nil
      } else {
        Seq(
          "-sourcepath", baseDirectory.value.getAbsolutePath,
          "-doc-source-url", s"https://github.com/nscala-time/nscala-time/tree/${gitHashOrBranch}€{FILE_PATH}.scala"
        )
      }
    },
    pomPostProcess := { node =>
      import scala.xml._
      import scala.xml.transform._
      def stripIf(f: Node => Boolean) = new RewriteRule {
        override def transform(n: Node) =
          if (f(n)) NodeSeq.Empty else n
      }

      val stripTestScope = stripIf { n => n.label == "dependency" && (n \ "scope").text == "test" }
      new RuleTransformer(stripTestScope).transform(node)(0)
    },
    pomExtra := (
      <url>https://github.com/nscala-time/nscala-time</url>
        <licenses>
          <license>
            <name>Apache</name>
            <url>http://www.opensource.org/licenses/Apache-2.0</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
        <scm>
          <url>git@github.com:nscala-time/nscala-time.git</url>
          <connection>scm:git:git@github.com:nscala-time/nscala-time.git</connection>
        </scm>
        <developers>
          <developer>
            <id>kmizu</id>
            <name>Pascal Meheut</name>
            <url>https://github.com/pmeheut</url>
          </developer>
        </developers>
      ),
    credentials ++= {
      val sonatype = ("Sonatype Nexus Repository Manager", "oss.sonatype.org")

      def loadMavenCredentials(file: java.io.File): Seq[Credentials] = {
        xml.XML.loadFile(file) \ "servers" \ "server" map (s => {
          val host = (s \ "id").text
          val realm = if (host == sonatype._2) sonatype._1 else "Unknown"
          Credentials(realm, host, (s \ "username").text, (s \ "password").text)
        })
      }

      val ivyCredentials = Path.userHome / ".ivy2" / ".credentials"
      val mavenCredentials = Path.userHome / ".m2" / "settings.xml"
      (ivyCredentials.asFile, mavenCredentials.asFile) match {
        case (ivy, _) if ivy.canRead => Credentials(ivy) :: Nil
        case (_, mvn) if mvn.canRead => loadMavenCredentials(mvn)
        case _ => Nil
      }
    }
  )


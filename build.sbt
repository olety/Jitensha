name := """play-java-starter-example"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.2"

libraryDependencies += guice

// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.194"

libraryDependencies += "com.stripe" % "stripe-java" % "5.24.0"

// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

// Postgres
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1201-jdbc41"

// Password encryption
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"

// Enable evolutions
libraryDependencies ++= Seq(evolutions, jdbc)

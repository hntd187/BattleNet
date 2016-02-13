name := "battlenet"
version := "0.1"
scalaVersion := "2.11.7"
organization := "com.github.scarman"
licenses +=("MIT", url("http://opensource.org/licenses/MIT"))
description := "A Scala interface for the Diablo 3 Leaderboards."

exportJars := true
resolvers += Resolver.jcenterRepo

bintrayVcsUrl := Some("https://github.com/hntd187/BattleNet")
scalacOptions ++= Seq("-language:implicitConversions", "-feature", "-unchecked", "-deprecation")

crossScalaVersions := Seq("2.10.6", "2.11.7")
libraryDependencies ++= Seq(
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
  "org.json4s" %% "json4s-native" % "3.3.0",
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)

    
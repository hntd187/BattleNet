name := "BattleNet"

version := "1.0"

scalaVersion := "2.11.7"

organization := "com.github.scarman"

libraryDependencies ++= Seq(
    "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
    "org.json4s" %% "json4s-native" % "3.3.0",
    "org.scalactic" %% "scalactic" % "2.2.6",
    "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  )

    
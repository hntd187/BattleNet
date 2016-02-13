name := "battlenet"
version := "0.1"
scalaVersion := "2.11.7"
organization := "com.github.scarman"
licenses +=("MIT", url("http://opensource.org/licenses/MIT"))

crossScalaVersions := Seq("2.10.6", "2.11.7")
resolvers += Resolver.jcenterRepo
scalacOptions ++= Seq("-language:implicitConversions", "-feature", "-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
  "org.json4s" %% "json4s-native" % "3.3.0",
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)

    
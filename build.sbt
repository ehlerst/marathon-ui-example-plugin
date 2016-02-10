lazy val root = (project in file(".")).enablePlugins().
  settings(
    name := "marathon-ui-example-plugin",
    organization := "mesosphere.marathon",
    version := "1.0",
    scalaVersion := "2.11.5"
  )

resolvers += Resolver.sonatypeRepo("releases")
resolvers += "Mesosphere Public Repo" at "http://downloads.mesosphere.io/maven"

libraryDependencies ++= Seq(
  "mesosphere.marathon" %% "plugin-interface" % "0.16.0-SNAPSHOT" % "provided",
  "log4j" % "log4j" % "1.2.17" % "provided",
  "org.slf4j" % "slf4j-api" % "1.7.12" % "provided"
)

lazy val build = taskKey[Unit]("Run npm build")

build := {
  "npm run build" !
}

packAutoSettings
packExcludeJars := Seq("scala-.*\\.jar")

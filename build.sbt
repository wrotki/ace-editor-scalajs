name := "scalajs-spa-starter"

version := "1.0"

scalaVersion in ThisBuild := Settings.versions.scala // "2.12.1"

val commonSettings = Seq(
)

// a special crossProject for configuring a JS/JVM/shared structure
lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared"))
  .settings(commonSettings: _*)
  .settings(
    scalaVersion := Settings.versions.scala,
    libraryDependencies ++= Settings.sharedDependencies.value
  )
  // set up settings specific to the JS project
  .jsConfigure(_ enablePlugins ScalaJSWeb)

lazy val sharedJVM = shared.jvm.settings(name := "sharedJVM")

lazy val sharedJS = shared.js.settings(name := "sharedJS")

lazy val server = (project in file("server")).settings(
  scalaVersion := Settings.versions.scala,
  libraryDependencies ++= Settings.jvmDependencies.value,
    scalaJSProjects := Seq(client),
  pipelineStages in Assets := Seq(scalaJSPipeline),
  pipelineStages := Seq(digest, gzip),
  // compress CSS
  LessKeys.compress in Assets := true
)
  .enablePlugins(SbtWeb)
  .enablePlugins(PlayScala)
  .disablePlugins(PlayLayoutPlugin) // use the standard directory layout instead of Play's custom
  .dependsOn(sharedJVM)

lazy val client = project.enablePlugins(ScalaJSPlugin, ScalaJSWeb)

// loads the Play server project at sbt startup
onLoad in Global := (Command.process("project server", _: State)) compose (onLoad in Global).value

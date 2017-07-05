//import scalajsbundler.sbtplugin.WebScalaJSBundlerPlugin

// https://github.com/scala-js/scala-js/issues/2797
// https://github.com/japgolly/misc/tree/webpack

name := "scalajs-spa-starter"

version := "1.0"

scalaVersion in ThisBuild := Settings.versions.scala // "2.12.1"

val commonSettings = Seq(
  libraryDependencies ++= Settings.sharedDependencies.value,
  skip in packageJSDependencies := false
)

lazy val root = (project in file("."))

// a special crossProject for configuring a JS/JVM/shared structure
lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared"))
  .settings(commonSettings: _*)
  .settings(
    scalaVersion := Settings.versions.scala
  )
  .jsConfigure(_.enablePlugins(ScalaJSWeb ,WebScalaJSBundlerPlugin))
  //.jsConfigure(_.enablePlugins(ScalaJSWeb ,WebScalaJSBundlerPlugin))
  // set up settings specific to the JS project
  //enablePlugins(WebScalaJSBundlerPlugin)

lazy val sharedJVM = shared.jvm.settings(name := "sharedJVM")

lazy val sharedJS = shared.js.settings(name := "sharedJS")

// lazy val client = project.enablePlugins(ScalaJSPlugin, ScalaJSWeb, ScalaJSBundlerPlugin)
lazy val client = (project in file("client"))
    .enablePlugins(ScalaJSBundlerPlugin, ScalaJSWeb)
    .settings(commonSettings: _*)
    .settings(
      scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
      //scalaJSLinkerConfig ~= { _.withRelativizeSourceMapBase(None) },
      scalaJSLinkerConfig ~= { _.withSourceMap(false) },
      //scalaJSModuleKind := ModuleKind.CommonJSModule,
      name := "client",
      version := Settings.version,
      scalaVersion := Settings.versions.scala,
      scalacOptions ++= Settings.scalacOptions,
      libraryDependencies ++= Settings.scalajsDependencies.value,
      jsDependencies ++= Settings.jsDependencies.value,
      useYarn := true,
      npmDependencies in Compile ++= Settings.npmDependencies,
      // Use a different Webpack configuration file for production
      webpackConfigFile in fastOptJS := Some(baseDirectory.value / "my.custom.webpack.config.js"),
      enableReloadWorkflow := false
  )

lazy val server = (project in file("server"))
  .enablePlugins(PlayScala, WebScalaJSBundlerPlugin)
  .disablePlugins(PlayLayoutPlugin) // use the standard directory layout instead of Play's custom
  .dependsOn(sharedJVM)
  .settings(commonSettings: _*)
  .settings(
  scalaVersion := Settings.versions.scala,
  libraryDependencies ++= Settings.jvmDependencies.value,
  // yes, we want to package JS dependencies
  skip in packageJSDependencies := false,
  scalaJSProjects := Seq(client),
  pipelineStages in Assets := Seq(scalaJSPipeline),
  pipelineStages := Seq(digest, gzip),
  npmAssets ++= NpmAssets.ofProject(client) { modules => (modules / "bootstrap").*** }.value,
  npmAssets ++= NpmAssets.ofProject(client) { modules => (modules / "font-awesome" ).*** }.value
  // compress CSS
  // LessKeys.compress in Assets := true
)


// loads the Play server project at sbt startup
onLoad in Global := (Command.process("project server", _: State)) compose (onLoad in Global).value

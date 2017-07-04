import sbt._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

/**
  * Created by mariusz on 6/15/17.
  */
object Settings {

  val version = "0.1.0"

  /** Options for the scala compiler */
  val scalacOptions = Seq(
    "-Xlint",
    "-unchecked",
    "-deprecation",
    "-feature"
  )

  object versions {
    // val scala = "2.12.1"
    val scala = "2.11.11"
    val autowire = "0.2.5"
    val booPickle = "1.2.5"
    val scalaJSReact = "1.0.1"
    val scalaDom = "0.9.2"

    val uTest = "0.4.4"
    val bootstrap = "3.3.7"
    val fontAwesome = "4.7.0"
    val scalajsScripts = "1.0.0"
    val react = "15.6.1"
    val log4javascript = "1.4.15"
    val mathjs = "3.13.3"
    val reactAce ="5.0.1"
    val brAce ="0.10.0"
  }

  /**
    * These dependencies are shared between JS and JVM projects
    * the special %%% function selects the correct version for each project
    */
  val sharedDependencies = Def.setting(Seq(
    // Uncomment below when Scala 2.12 versions are available
    "com.lihaoyi" %%% "autowire" % versions.autowire,
    "me.chrons" %%% "boopickle" % versions.booPickle
  ))
  /** Dependencies only used by the JVM project */

  val jvmDependencies = Def.setting(Seq(
    "com.vmunier" %% "scalajs-scripts" % versions.scalajsScripts,
    "com.lihaoyi" %% "utest" % versions.uTest % Test
  ))

  /** Dependencies only used by the JS project (note the use of %%% instead of %%) */
  val scalajsDependencies = Def.setting(Seq(
    "com.github.japgolly.scalajs-react" %%% "core" % versions.scalaJSReact,
//    "com.github.japgolly.scalajs-react" %%% "core" % versions.scalajsReact,
//    "com.github.japgolly.scalajs-react" %%% "extra" % versions.scalajsReact,
//    "com.github.japgolly.scalacss" %%% "ext-react" % versions.scalaCSS,
//    "me.chrons" %%% "diode" % versions.diode,
//    "me.chrons" %%% "diode-react" % versions.diode,
    "org.scala-js" %%% "scalajs-dom" % versions.scalaDom,
    "com.lihaoyi" %%% "utest" % versions.uTest % Test
  ))


  val jsDependencies = Def.setting(Seq(
//    "org.webjars" % "font-awesome" % versions.fontAwesome % Provided,
//    "org.webjars" % "bootstrap" % versions.bootstrap % Provided,
//    "org.webjars.bower" % "react" % versions.react / "react-with-addons.js" minified "react-with-addons.min.js" commonJSName "React",
//    "org.webjars.bower" % "react" % versions.react / "react-dom.js" minified "react-dom.min.js" dependsOn "react-with-addons.js" commonJSName "ReactDOM"
  ))

  val npmDependencies = Seq(
    "react" -> versions.react,
    "react-dom" -> versions.react,
    "log4javascript" -> versions.log4javascript,
    "bootstrap" -> versions.bootstrap,
    "font-awesome" -> versions.fontAwesome,
    "brace" -> versions.brAce,
    "react-ace" -> versions.reactAce
  )
}

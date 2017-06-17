import sbt._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

/**
  * Created by mariusz on 6/15/17.
  */
object Settings {

  object versions {
    //val scala = "2.12.1"
    val scala = "2.11.11"
    val autowire = "0.2.5"
    val booPickle = "1.2.5"

    val uTest = "0.4.4"
    val bootstrap = "3.3.6"
    val scalajsScripts = "1.0.0"
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
    "org.webjars" % "font-awesome" % "4.3.0-1" % Provided,
    "org.webjars" % "bootstrap" % versions.bootstrap % Provided,
    "com.lihaoyi" %% "utest" % versions.uTest % Test
  ))

}

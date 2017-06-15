import sbt._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

/**
  * Created by mariusz on 6/15/17.
  */
object Settings {

  object versions {
    val scala = "2.12.1"
    val autowire = "0.2.5"
    val booPickle = "1.2.5"
  }

  /**
    * These dependencies are shared between JS and JVM projects
    * the special %%% function selects the correct version for each project
    */
  val sharedDependencies = Def.setting(Seq(
    // Uncomment below when Scala 2.12 versions are available
//    "com.lihaoyi" %%% "autowire" % versions.autowire,
//    "me.chrons" %%% "boopickle" % versions.booPickle
  ))

}

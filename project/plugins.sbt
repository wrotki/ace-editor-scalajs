// repository for Typesafe plugins
//resolvers += "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"
//resolvers += Resolver.bintrayRepo("sbt", "sbt-plugin-releases")

// SERVER
// https://index.scala-lang.org/playframework/playframework/sbt-plugin/2.5.13
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.13")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.0")

// CLIENT
// https://index.scala-lang.org/vmunier/sbt-web-scalajs
// addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.4")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.17")

// addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.6")

addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.6.0")

addSbtPlugin("ch.epfl.scala" % "sbt-web-scalajs-bundler" % "0.6.0")

addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.5")



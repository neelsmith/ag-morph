name := "Allen-Greenough morphologicacl parser"
organization := "edu.holycross.shot"
version := "0.0.1"
licenses += ("GPL-3.0",url("https://opensource.org/licenses/gpl-3.0.html"))

crossScalaVersions in ThisBuild := Seq("2.11.8", "2.12.4")
scalaVersion := (crossScalaVersions in ThisBuild).value.last

resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("neelsmith", "maven")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",

  "edu.holycross.shot" %% "tabulae" % "1.0.0",
  "com.github.pathikrit" %% "better-files" % "3.5.0"

)

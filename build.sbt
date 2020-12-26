ThisBuild / scalaVersion := "2.12.6"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val lib = (project in file("lib"))
  .settings(
    libraryDependencies ++= commonDependencies,
    assemblyJarName in assembly := s"${name.value}.jar"
  )

lazy val client = (project in file("client"))
  .settings(
    libraryDependencies ++= commonDependencies ++ clientDependencies,
    assemblyJarName in assembly := s"${name.value}.jar"
  ).dependsOn(lib % "test->test;compile->compile")

lazy val server = (project in file("server"))
  .settings(
    libraryDependencies ++= commonDependencies ++ serverDependencies,
    assemblyJarName in assembly := s"${name.value}.jar"
  ).dependsOn(lib % "compile->compile")

lazy val commonDependencies = Seq(
  "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
)

lazy val clientDependencies = Seq(
  "org.apache.httpcomponents" % "httpclient" % "4.5.3" % "provided"
)

lazy val serverDependencies = Seq(
  "org.apache.commons" % "commons-pool2" % "2.7.0"
)
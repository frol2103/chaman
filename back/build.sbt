name := """back"""
organization := "be.frol"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .dependsOn(generated)
  .aggregate(generated)
  .settings(
    version := "1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.play" %% "play-slick" % "5.0.0",
      "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
      "com.typesafe.slick" %% "slick-codegen" % "3.3.2",
      "mysql" % "mysql-connector-java" % "5.1.44",
      "org.webjars" % "swagger-ui" % "3.36.2",
      "com.typesafe.play" %% "play-json" % "2.6.0",
      "com.github.jwt-scala" %% "jwt-play-json" % "9.0.2",
      "joda-time" % "joda-time" % "2.10.12",
      "com.google.zxing" % "javase" % "3.3.0",
      "com.google.zxing" % "core" % "3.3.0",
      "org.xhtmlrenderer" % "flying-saucer-pdf-openpdf" % "9.1.20",
      "org.imgscalr" % "imgscalr-lib" % "4.2",
      "com.github.etaty" %% "rediscala" % "1.8.0",
    )

  )

val generatedApiPath = file("modules/generated")
val angular = "modules/generated-api"

lazy val generated = (project in generatedApiPath).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "5.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
  "com.typesafe.slick" %% "slick-codegen" % "3.3.2",
  "mysql" % "mysql-connector-java" % "5.1.44",
)


lazy val slick = TaskKey[Seq[File]]("gen-tables")

slick := {
  val outputDir = file("app").getPath
  val url = "jdbc:mysql://db:3306/chaman?allowPublicKeyRetrieval=true&useSSL=false"
  val jdbcDriver = "com.mysql.jdbc.Driver"
  val slickDriver = "slick.jdbc.MySQLProfile"
  val pkg = "be.frol.chaman.tables"
  val fname = outputDir + "tables/Tables.scala"
  val user = "user"
  val password = "pass"

  val cp = (dependencyClasspath in Compile).value
  val r = (runner in Compile).value
  val s = streams.value

  r.run("slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg, user, password), s.log)
  Seq(file(fname))
}


scalaVersion := "2.12.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test


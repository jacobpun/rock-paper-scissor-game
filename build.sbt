val scala3Version = "3.0.2"
val Http4sVersion = "0.22.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "rock-paper-scisssor-game",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,  
    libraryDependencies ++= List(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "org.http4s"      %% "http4s-blaze-server" % "0.22.0",
      "org.http4s"      %% "http4s-dsl"          % "0.22.0",
      "ch.qos.logback"  %  "logback-classic"     % "1.2.3"
    ) 
  )

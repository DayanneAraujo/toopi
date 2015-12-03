

name := "harpia_server"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.10.5"


libraryDependencies ++= Seq(
  javaJdbc,
  javaCore,
  javaWs,
  cache,
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.hibernate" % "hibernate-core" % "5.0.2.Final",
  "org.hibernate" % "hibernate-entitymanager" % "5.0.2.Final",
  "com.google.code.gson" % "gson" % "2.4",
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

PlayKeys.externalizeResources := false

fork in run := true

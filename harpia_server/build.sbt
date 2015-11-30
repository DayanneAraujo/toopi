

name := "harpia_server"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.10.5"

libraryDependencies ++= Seq(
  javaJdbc,
  javaCore,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.37",
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.hibernate" % "hibernate-core" % "5.0.2.Final",
  "org.hibernate" % "hibernate-entitymanager" % "5.0.2.Final",
  "com.google.code.gson" % "gson" % "2.4",
  "asm" % "asm-all" % "3.1",
  "org.codehaus.jackson" % "jackson-core-asl" % "1.9.13",
  "org.codehaus.jackson" % "jackson-jaxrs" % "1.9.13",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.13",
  "org.codehaus.jackson" % "jackson-xc" % "1.9.13",
  "org.codehaus.jettison" % "jettison" % "1.3.7",
  "org.bouncycastle" % "bcprov-jdk15on" % "1.53",
  "com.sun.jersey" % "jersey-client" % "1.19",
  "com.sun.jersey" % "jersey-core" % "1.19",
  "com.sun.jersey" % "jersey-json" % "1.19",
  "com.sun.jersey" % "jersey-server" % "1.19",
  "com.sun.jersey" % "jersey-servlet" % "1.19",
  "com.sun.jersey.contribs" % "jersey-multipart" % "1.19"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

PlayKeys.externalizeResources := false

fork in run := true
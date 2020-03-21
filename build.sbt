name := "Overwatch"

organization := "com.databricks.labs"

version := "0.1"

scalaVersion := "2.11.12"
scalacOptions ++= Seq("-Xmax-classfile-name", "78")

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.6"
libraryDependencies += "com.databricks" % "dbutils-api_2.11" % "0.0.4"

assemblyExcludedJars in assembly := {
  val cp = (fullClasspath in assembly).value
  cp filter { f =>
    f.data.getName.contains("spark-core") ||
      f.data.getName.contains("spark-sql") ||
      f.data.getName.contains("com.databricks.backend")
  }
}
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
  kotlin("jvm") version "1.3.30"
}

allprojects {
  apply(plugin = "org.jetbrains.kotlin.jvm")

  group = "de.mosmann.bugs"
  version = "0.0.1-SNAPSHOT"

  repositories {
    mavenLocal()

    mavenCentral()

		jcenter()
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      apiVersion = "1.3"
      languageVersion = "1.3"
      jvmTarget = "1.8"
      // freeCompilerArgs = listOf("-XXLanguage:+NewInference")
    }
  }

  tasks.test {
    useJUnitPlatform()
  }

  dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib:1.3.30")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.30")
    compile("org.jetbrains.kotlin:kotlin-stdlib-common:1.3.30")

    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.2")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.3.2")

    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.3.2")
  }
}


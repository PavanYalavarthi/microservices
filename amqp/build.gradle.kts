plugins {
  kotlin("jvm")
}

group = "com.projects"
version = "1.0.0"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-amqp")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(21)
}
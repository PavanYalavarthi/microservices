plugins {
  kotlin("jvm")
}

group = "com.projects"
version = "unspecified"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-amqp")
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(21)
}
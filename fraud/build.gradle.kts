plugins {
  kotlin("jvm")
}

group = "com.projects"
version = "unspecified"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
  testImplementation(kotlin("test"))
  runtimeOnly("org.postgresql:postgresql")
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(21)
}
plugins {
  kotlin("jvm")
}

group = "com.projects"
version = "unspecified"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.cloud:spring-cloud-starter-gateway-server-webflux")
  implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
}

tasks.test {
  useJUnitPlatform()
}
kotlin {
  jvmToolchain(21)
}
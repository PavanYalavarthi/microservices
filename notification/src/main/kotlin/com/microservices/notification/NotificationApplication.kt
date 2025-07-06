package com.microservices.notification

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
  scanBasePackages = [
    "com.microservices.notification",
    "com.microservices.amqp"
  ],
)
class NotificationApplication

fun main(args: Array<String>) {
  runApplication<NotificationApplication>(*args)
}
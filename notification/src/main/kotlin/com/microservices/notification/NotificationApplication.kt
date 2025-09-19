package com.microservices.notification

import com.microservices.amqp.RabbitMQMessageProducer
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

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
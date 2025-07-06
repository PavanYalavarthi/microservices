package com.microservices.amqp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AMQPApplication

fun main(args: Array<String>) {
  runApplication<AMQPApplication>(*args)
}
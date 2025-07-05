package com.microservices.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(
  basePackages = ["com.microservices.clients"]
)
class CustomerApplication

fun main(args: Array<String>) {
  runApplication<CustomerApplication>(*args)
}

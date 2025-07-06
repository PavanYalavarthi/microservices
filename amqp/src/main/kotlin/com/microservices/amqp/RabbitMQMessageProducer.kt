package com.microservices.amqp

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class RabbitMQMessageProducer(val amqpTemplate: AmqpTemplate) {

  fun publish(payload: Any, exchange: String, routingKey: String) {
    log.info { "Publishing to $exchange with routingKey: $routingKey, with message: $payload" }
    amqpTemplate.convertAndSend(exchange, routingKey, payload)
    log.info { "Published to $exchange with routingKey: $routingKey, with message: $payload" }
  }
}
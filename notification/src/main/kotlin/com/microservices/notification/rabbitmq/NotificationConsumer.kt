package com.microservices.notification.rabbitmq

import com.microservices.clients.notification.NotificationRequest
import com.microservices.notification.NotificationService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class NotificationConsumer(val notificationService: NotificationService) {
  @RabbitListener(queues = ["\${rabbitmq.queue.notification}"])
  fun consumer(notificationRequest: NotificationRequest) {
    log.info { "Consumed $notificationRequest from queue"}
    notificationService.send(notificationRequest)
  }
}
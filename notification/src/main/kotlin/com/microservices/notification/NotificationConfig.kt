package com.microservices.notification

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NotificationConfig {

  @Value("\${rabbitmq.exchanges.internal}")
  lateinit var internalExchange: String

  @Value("\${rabbitmq.queue.notification}")
  lateinit var notificationQueue: String

  @Value("\${rabbitmq.routing-keys.internal-notification}")
  lateinit var internalNotificationRoutingKey: String

  @Bean
  fun internalTopicExchange(): TopicExchange {
    return TopicExchange(internalExchange )
  }

  @Bean
  fun notificationQueue(): Queue {
    return Queue(notificationQueue )
  }

  @Bean
  fun internalNotificationBinding(): Binding {
    return BindingBuilder
      .bind(notificationQueue())
      .to(internalTopicExchange())
      .with(internalNotificationRoutingKey)
  }
}
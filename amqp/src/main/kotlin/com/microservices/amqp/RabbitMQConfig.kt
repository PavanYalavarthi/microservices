package com.microservices.amqp

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableRabbit
class RabbitMQConfig(private val connectionFactory: ConnectionFactory) {
  @Bean
  fun amqpTemplate(): AmqpTemplate {
    val rabbitTemplate = RabbitTemplate(connectionFactory)
    rabbitTemplate.messageConverter = Jackson2JsonMessageConverter()
    return rabbitTemplate
  }

  @Bean
  fun simpleRabbitListenerFactory(): SimpleRabbitListenerContainerFactory {
    val factory = SimpleRabbitListenerContainerFactory()
    factory.setConnectionFactory(connectionFactory)
    factory.setMessageConverter(messageConverter())
    return factory
  }

  @Bean
  fun messageConverter(): MessageConverter {
    return Jackson2JsonMessageConverter()
  }
}
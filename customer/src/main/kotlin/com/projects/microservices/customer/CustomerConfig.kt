package com.projects.microservices.customer

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class CustomerConfig {
  @Bean
  fun restTemplate(): RestTemplate {
    return RestTemplate()
  }
}
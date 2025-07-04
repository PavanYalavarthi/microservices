package com.microservices.clients.fraud

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
  value = "fraud",
)
interface FraudClient {
  @GetMapping(path = ["/api/v1/fraud-check/{customerId}"])
  fun isFraudster(@PathVariable customerId: Int): FraudCheckResponse
}
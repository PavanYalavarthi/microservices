package com.microservices.fraud

import com.microservices.clients.fraud.FraudCheckResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/fraud-check")
class FraudController(private val fraudCheckService: FraudCheckService) {
  @GetMapping(path = ["{customerId}"])
  fun isFraudster(@PathVariable customerId: Int): FraudCheckResponse {
    return fraudCheckService.isCustomerFraudster(customerId)
  }
}
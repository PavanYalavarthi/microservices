package com.projects.microservices.fraud

import org.springframework.stereotype.Service

@Service
class FraudCheckService(val fraudCheckHistoryRepository: FraudCheckHistoryRepository) {
  fun isCustomerFraudster(customerId: Int): Boolean {
    val fraudCheckHistory = FraudCheckHistory(customerId = customerId)
    fraudCheckHistoryRepository.save(fraudCheckHistory)
    return false
  }
}
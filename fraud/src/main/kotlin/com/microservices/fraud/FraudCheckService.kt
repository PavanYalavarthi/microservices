package com.microservices.fraud

import com.microservices.clients.fraud.FraudCheckResponse
import org.springframework.stereotype.Service

@Service
class FraudCheckService(val fraudCheckHistoryRepository: FraudCheckHistoryRepository) {
  fun isCustomerFraudster(customerId: Int): FraudCheckResponse {
    val fraudCheckHistory = FraudCheckHistory(customerId = customerId)
    fraudCheckHistoryRepository.save(fraudCheckHistory)
    return FraudCheckResponse(false)
  }
}
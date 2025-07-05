package com.projects.microservices.fraud

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FraudCheckHistoryRepository: JpaRepository<FraudCheckHistory, Int> {
  fun save(fraudCheckHistory: FraudCheckHistory)
}
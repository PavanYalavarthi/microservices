package com.projects.microservices.fraud

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant

@Entity
data class FraudCheckHistory(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Int = 0,
  val customerId: Int,
  val isFraudster: Boolean = false,
  val createdAt: Instant = Instant.now(),
)
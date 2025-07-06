package com.microservices.notification

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant

@Entity
data class Notification(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Int = 0,
  val toCustomerId: Int,
  val toCustomerEmail: String,
  val sender: String,
  val message: String,
  val sentAt: Instant = Instant.now(),
)

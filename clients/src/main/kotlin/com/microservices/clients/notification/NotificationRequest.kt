package com.microservices.clients.notification

data class NotificationRequest(
  val customerId: Int,
  val customerEmail: String,
  val message: String
)
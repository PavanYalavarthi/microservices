package com.microservices.notification

import com.microservices.clients.notification.NotificationRequest
import org.springframework.stereotype.Service

@Service
class NotificationService(val repository: NotificationRepository) {
  fun send(request: NotificationRequest) {
    val notification = Notification(
      toCustomerId = request.customerId,
      toCustomerEmail = request.customerEmail,
      sender = "pavan@microservices.com",
      message = request.message,
    )
    repository.save(notification)
  }
}
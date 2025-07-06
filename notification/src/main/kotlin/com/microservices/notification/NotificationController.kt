package com.microservices.notification

import com.microservices.clients.notification.NotificationRequest
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
class NotificationController(val service: NotificationService) {
  @PostMapping
  fun sendNotification(@RequestBody notificationRequest: NotificationRequest) {
    service.send(notificationRequest)
  }
}
package com.microservices.notification

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NotificationRepository: JpaRepository<Notification, Int> {

}
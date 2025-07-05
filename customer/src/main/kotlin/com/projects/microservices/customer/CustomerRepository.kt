package com.projects.microservices.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Int> {
  fun save(customer: Customer)
}
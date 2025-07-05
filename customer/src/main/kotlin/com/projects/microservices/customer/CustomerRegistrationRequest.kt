package com.projects.microservices.customer

data class CustomerRegistrationRequest(
  val firstName: String,
  val lastName: String,
  val email: String,
)
package com.projects.microservices.customer

import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository) {

  fun registerCustomer(customerRegistrationRequest: CustomerRegistrationRequest): Customer {
    val customer = Customer(
      firstName = customerRegistrationRequest.firstName,
      lastName = customerRegistrationRequest.lastName,
      email = customerRegistrationRequest.email
    )
    customerRepository.save(customer)
    return customer
  }
}
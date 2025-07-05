package com.microservices.customer

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CustomerService(val customerRepository: CustomerRepository, val restTemplate: RestTemplate) {

  fun registerCustomer(customerRegistrationRequest: CustomerRegistrationRequest): Customer {
    val customer = Customer(
      firstName = customerRegistrationRequest.firstName,
      lastName = customerRegistrationRequest.lastName,
      email = customerRegistrationRequest.email
    )
    customerRepository.saveAndFlush(customer)
    val isFraudster = restTemplate.getForObject(
      "http://FRAUD/api/v1/fraud-check/{customerId}",
      Boolean::class.java,
      customer.id
    )

    if (isFraudster == true) {
      throw IllegalStateException("Customer is a Fraudster")
    }
    return customer
  }
}
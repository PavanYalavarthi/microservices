package com.microservices.customer

import com.microservices.clients.fraud.FraudClient
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository, val fraudClient: FraudClient) {

  fun  registerCustomer(customerRegistrationRequest: CustomerRegistrationRequest): Customer {
    val customer = Customer(
      firstName = customerRegistrationRequest.firstName,
      lastName = customerRegistrationRequest.lastName,
      email = customerRegistrationRequest.email
    )
    customerRepository.saveAndFlush(customer)
    val fraudCheckResponse = fraudClient.isFraudster(customer.id)
    if (fraudCheckResponse.isFraudster) {
      throw IllegalStateException("Customer is a Fraudster")
    }
    return customer
  }
}
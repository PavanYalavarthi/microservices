package com.microservices.customer

import com.microservices.amqp.RabbitMQMessageProducer
import com.microservices.clients.fraud.FraudClient
import com.microservices.clients.notification.NotificationRequest
import org.springframework.stereotype.Service

@Service
class CustomerService(
  val customerRepository: CustomerRepository,
  val fraudClient: FraudClient,
  val rabbitMQMessageProducer: RabbitMQMessageProducer
) {

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
    val notificationRequest = NotificationRequest(
      customer.id,
      customer.email,
      "Hi ${customer.firstName} ${customer.lastName}, welcome to project, ... "
    )
    rabbitMQMessageProducer.publish(notificationRequest,  "internal-exchange", "internal.notification.routing-key")
    return customer
  }
}
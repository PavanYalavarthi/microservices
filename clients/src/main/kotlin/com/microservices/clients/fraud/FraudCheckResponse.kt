package com.microservices.clients.fraud

import com.fasterxml.jackson.annotation.JsonProperty

data class FraudCheckResponse(
  @JsonProperty("isFraudster")
  val isFraudster: Boolean
)
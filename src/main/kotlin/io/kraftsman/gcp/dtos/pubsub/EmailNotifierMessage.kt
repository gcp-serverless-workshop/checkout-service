package io.kraftsman.gcp.dtos.pubsub

import com.fasterxml.jackson.annotation.JsonProperty
import io.kraftsman.gcp.contracts.NotifierMessageContract

data class EmailNotifierMessage(
    @JsonProperty("order_id")
    override val orderId: Long,

    @JsonProperty("message")
    override val message: String,

    @JsonProperty("email")
    val email: String,
): NotifierMessageContract

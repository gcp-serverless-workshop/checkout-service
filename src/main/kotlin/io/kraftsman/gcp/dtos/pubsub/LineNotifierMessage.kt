package io.kraftsman.gcp.dtos.pubsub

import com.fasterxml.jackson.annotation.JsonProperty
import io.kraftsman.gcp.contracts.NotifierMessageContract

data class LineNotifierMessage(
    @JsonProperty("order_id")
    override val orderId: Int,

    @JsonProperty("name")
    override val message: String,
): NotifierMessageContract

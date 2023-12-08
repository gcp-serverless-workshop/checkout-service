package io.kraftsman.gcp.dtos.requests

import com.fasterxml.jackson.annotation.JsonProperty
import io.kraftsman.gcp.models.NotifyChannel
import io.kraftsman.gcp.models.CartItem

data class CheckoutRequest(

    @JsonProperty("user_id")
    val userId: Int,

    @JsonProperty("cart")
    val cart: List<CartItem>,

    @JsonProperty("notify_channels")
    val notifyChannels: List<NotifyChannel>
)

package io.kraftsman.gcp.dtos.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class OrderResponse(

    @JsonProperty("id")
    val id: Int,

    @JsonProperty("user_display_name")
    val userDisplayName: String,

    @JsonProperty("products")
    val products: String,
)

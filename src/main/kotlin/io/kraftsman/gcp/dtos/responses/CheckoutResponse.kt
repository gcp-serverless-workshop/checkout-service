package io.kraftsman.gcp.dtos.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class CheckoutResponse(

    @JsonProperty("result")
    val result: Boolean,

    @JsonProperty("code")
    val code: Int,

    @JsonProperty("message")
    val message: String,
)

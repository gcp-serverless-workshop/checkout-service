package io.kraftsman.gcp.dtos.responses

data class CheckoutResponse(
    val result: Boolean,
    val code: Int,
    val message: String,
)

package io.kraftsman.gcp.dtos

data class CheckoutResponse(
    val result: Boolean,
    val code: Int,
    val message: String,
)

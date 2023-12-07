package io.kraftsman.gcp.models

data class Checkout(
    val userId: Int,
    val products: List<ProductItem>,
    val notifyChannels: List<NotifyChannel>
)

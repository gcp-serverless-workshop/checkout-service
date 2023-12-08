package io.kraftsman.gcp.models

data class Order(
    val id: Int,
    val user: User,
    val items: List<ProductItem>,
)

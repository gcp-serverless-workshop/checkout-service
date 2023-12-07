package io.kraftsman.gcp.models

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
)

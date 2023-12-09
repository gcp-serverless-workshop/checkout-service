package io.kraftsman.gcp.models

import com.fasterxml.jackson.annotation.JsonProperty

data class CartItem(

    @JsonProperty("product_id")
    val productId: Long,

    @JsonProperty("quantity")
    val quantity: Int,
)

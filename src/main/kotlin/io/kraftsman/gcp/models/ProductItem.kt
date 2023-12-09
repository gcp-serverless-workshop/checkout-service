package io.kraftsman.gcp.models

import jakarta.persistence.*

@Entity
@Table(name = "product_items")
data class ProductItem(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,

    @Column
    val quantity: Int
)

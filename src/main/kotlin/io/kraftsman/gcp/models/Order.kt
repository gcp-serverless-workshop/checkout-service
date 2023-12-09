package io.kraftsman.gcp.models

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "orders")
data class Order(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("id")
    val id: Long = 0,

    @JsonProperty("user")
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    @JsonProperty("items")
    var items: List<ProductItem> = mutableListOf()
)

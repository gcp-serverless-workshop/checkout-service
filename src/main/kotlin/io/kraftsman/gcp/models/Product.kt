package io.kraftsman.gcp.models

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "products")
data class Product(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("id")
    val id: Long = 0,

    @Column(name="name", length=255, nullable=false, unique=false)
    @JsonProperty("name")
    val name: String,

    @Column(name="description", length=255, nullable=false, unique=false)
    @JsonProperty("description")
    val description: String,

    @Column(name="price")
    @JsonProperty("price")
    val price: Int,
)

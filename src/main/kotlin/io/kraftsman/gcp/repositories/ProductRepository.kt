package io.kraftsman.gcp.repositories

import io.kraftsman.gcp.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>

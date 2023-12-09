package io.kraftsman.gcp.repositories

import io.kraftsman.gcp.models.ProductItem
import org.springframework.data.jpa.repository.JpaRepository

interface ProductItemRepository : JpaRepository<ProductItem, Long>

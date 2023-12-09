package io.kraftsman.gcp.repositories

import io.kraftsman.gcp.models.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Long>

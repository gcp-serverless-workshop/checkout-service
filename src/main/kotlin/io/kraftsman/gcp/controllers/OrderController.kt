package io.kraftsman.gcp.controllers

import io.kraftsman.gcp.dtos.responses.OrderResponse
import io.kraftsman.gcp.repositories.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class OrderController(
    private val orderRepository: OrderRepository,
) {

    @GetMapping("orders")
    fun index(): List<OrderResponse> =
        orderRepository.findAll().map { order ->
            OrderResponse(
                id = order.id.toInt(),
                userDisplayName = order.user.displayName,
                products = order.items.joinToString {
                    "${it.product.name} x ${it.quantity}"
                }
            )
        }
}

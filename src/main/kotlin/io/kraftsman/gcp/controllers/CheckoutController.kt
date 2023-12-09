package io.kraftsman.gcp.controllers

import io.kraftsman.gcp.dtos.requests.CheckoutRequest
import io.kraftsman.gcp.dtos.responses.CheckoutResponse
import io.kraftsman.gcp.models.Order
import io.kraftsman.gcp.models.ProductItem
import io.kraftsman.gcp.repositories.OrderRepository
import io.kraftsman.gcp.repositories.ProductItemRepository
import io.kraftsman.gcp.repositories.ProductRepository
import io.kraftsman.gcp.repositories.UserRepository
import io.kraftsman.gcp.services.OrderNotifierService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class CheckoutController(
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository,
    private val productItemRepository: ProductItemRepository,
    private val orderRepository: OrderRepository,
    private val notifier: OrderNotifierService
) {

    @PostMapping("checkout")
    fun create(
        @RequestBody request: CheckoutRequest
    ): CheckoutResponse {
        val user = userRepository.findById(request.userId).get()
        val order = orderRepository.save(Order(user = user))
        val productItems = request.cart.map { cartItem ->
            val productItem = ProductItem(
                order = order,
                product = productRepository.findById(cartItem.productId).get(),
                quantity = cartItem.quantity
            )

            productItemRepository.save(productItem)
        }

        order.items = productItems
        orderRepository.save(order)

        request.notifyChannels.forEach { channel ->
            notifier.send(order, channel)
        }

        return CheckoutResponse(
            result = true,
            code = 200,
            message = "Order created",
        )
    }
}

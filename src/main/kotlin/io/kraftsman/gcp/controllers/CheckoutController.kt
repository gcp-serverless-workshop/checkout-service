package io.kraftsman.gcp.controllers

import io.kraftsman.gcp.dtos.responses.CheckoutResponse
import io.kraftsman.gcp.dtos.requests.CheckoutRequest
import io.kraftsman.gcp.models.Order
import io.kraftsman.gcp.models.Product
import io.kraftsman.gcp.models.ProductItem
import io.kraftsman.gcp.models.User
import io.kraftsman.gcp.services.OrderNotifierService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping("api")
class CheckoutController(
    private val notifier: OrderNotifierService
) {

    @PostMapping("checkout")
    fun create(
        @RequestBody request: CheckoutRequest
    ): CheckoutResponse {
        val order = Order(
            1,
            User(
                id = 1,
                username = "user$1",
                password = "randompassword",
                displayName = "User $1",
                email = "user$1@example.com",
                mobile = "0911111111",
                profileImageUrl = "https://www.example.com",
            ),
            listOf (
                ProductItem(
                    Product(
                        id = 1,
                        name = "Product 1",
                        description = "product desc",
                        price = Random.nextInt(10, 1000),
                        imageUrl = "https://www.example.com/product",
                    ),
                    1
                )
            )
        )

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

package io.kraftsman.gcp.controllers

import io.kraftsman.gcp.dtos.CheckoutResponse
import io.kraftsman.gcp.models.Checkout
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class CheckoutController {

    @PostMapping("checkout")
    fun create(
        @RequestBody checkout: Checkout
    ): CheckoutResponse {


        return CheckoutResponse(
            result = true,
            code = 200,
            message = "Order created",
        )
    }
}
package io.kraftsman.gcp.controllers

import io.kraftsman.gcp.models.Product
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping("api")
class ProductController {

    @GetMapping("products")
    fun index(): List<Product> =
        (1..10).map {
            Product(
                id = it,
                name = "Product $it",
                description = "product desc",
                price = Random.nextInt(10, 1000),
                imageUrl = "https://www.example.com/product",
            )
        }
}

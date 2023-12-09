package io.kraftsman.gcp.controllers

import io.kraftsman.gcp.models.Product
import io.kraftsman.gcp.repositories.ProductRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping("api")
class ProductController(
    private val productRepository: ProductRepository,
) {

    @GetMapping("products")
    fun index(): List<Product> = productRepository.findAll()
}

package io.kraftsman.gcp.controllers

import io.kraftsman.gcp.models.User
import io.kraftsman.gcp.repositories.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class UserController(
    private val userRepository: UserRepository
) {

    @GetMapping("users")
    fun index(): List<User> =
        userRepository.findAll()
}

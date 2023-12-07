package io.kraftsman.gcp.controllers

import io.kraftsman.gcp.data.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class UserController {

    @GetMapping("users")
    fun index(): List<User> =
        (1..10).map {
            User(
                id = it,
                username = "user$it",
                password = "randompassword",
                displayName = "User $it",
                email = "user$it@example.com",
                mobile = "0911111111",
                profileImageUrl = "https://www.example.com",
            )
        }
}

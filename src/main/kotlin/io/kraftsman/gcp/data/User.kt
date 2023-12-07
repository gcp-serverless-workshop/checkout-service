package io.kraftsman.gcp.data

data class User(
    val id: Int,
    val username: String,
    val password: String,
    val displayName: String,
    val email: String,
    val mobile: String,
    val profileImageUrl: String,
)

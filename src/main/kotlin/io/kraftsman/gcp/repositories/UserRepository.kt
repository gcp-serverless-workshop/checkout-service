package io.kraftsman.gcp.repositories

import io.kraftsman.gcp.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>

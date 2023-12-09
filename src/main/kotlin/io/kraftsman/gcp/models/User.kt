package io.kraftsman.gcp.models

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty("id")
    val id: Long = 0,

    @Column(name="username", length=255, nullable=false, unique=false)
    @JsonProperty("username")
    val username: String,

    @Column(name="password", length=255, nullable=false, unique=false)
    @JsonProperty("password")
    val password: String,

    @Column(name="display_name", length=255, nullable=false, unique=false)
    @JsonProperty("display_name")
    val displayName: String,

    @Column(name="email", length=500, nullable=false, unique=false)
    @JsonProperty("email")
    val email: String,

    @Column(name="mobile", length=255, nullable=false, unique=false)
    @JsonProperty("mobile")
    val mobile: String,
)

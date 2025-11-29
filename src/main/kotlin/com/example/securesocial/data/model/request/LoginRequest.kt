package com.example.securesocial.data.model.request

data class LoginRequest(
    val email: String, // Changed from username to email for login
    val password: String
)
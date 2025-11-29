package com.example.securesocial.data.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(
    val username: String,
    val email: String,
    val hashedPassword: String?,
    @Id val id: ObjectId = ObjectId(),
    val createdAt: Long = System.currentTimeMillis(),
    var isVerified: Boolean = false
)
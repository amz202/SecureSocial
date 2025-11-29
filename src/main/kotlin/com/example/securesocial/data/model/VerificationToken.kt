package com.example.securesocial.data.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("verification_tokens")
data class VerificationToken(
    @Id val id: ObjectId = ObjectId(),
    val email: String,

    val hashedOtp: String,

    @Indexed(expireAfter = "300s")
    val createdAt: LocalDateTime = LocalDateTime.now()
)

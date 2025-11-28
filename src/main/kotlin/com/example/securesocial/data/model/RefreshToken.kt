package com.example.securesocial.data.model

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Document("refreshTokens")
data class RefreshToken @OptIn(ExperimentalTime::class) constructor(
    val hashedToken: String,
    val userId: ObjectId,
    @Indexed(expireAfter = "0s")
    val expiresAt: java.time.Instant?,
    val createdAt: Instant = Clock.System.now()
)

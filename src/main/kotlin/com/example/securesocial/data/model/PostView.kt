package com.example.securesocial.data.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class PostView(
    @Id val id: ObjectId= ObjectId(),
    val postId: ObjectId,
    val hashedViewToken: String,
    val viewedAt: Long = System.currentTimeMillis()
)

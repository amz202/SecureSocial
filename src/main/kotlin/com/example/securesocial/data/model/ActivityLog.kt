package com.example.securesocial.data.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("activity_log")
data class ActivityLog(
    @Id val id: ObjectId = ObjectId(),
    val userId: String,
    val action: LogType,
    val createdAt: Long = System.currentTimeMillis(),
    val details: String? = null
)

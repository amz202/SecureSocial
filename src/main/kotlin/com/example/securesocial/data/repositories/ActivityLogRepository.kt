package com.example.securesocial.data.repositories

import com.example.securesocial.data.model.ActivityLog
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ActivityLogRepository: MongoRepository<ActivityLog, ObjectId> {
    fun findByUserId(userId: String): List<ActivityLog>
}
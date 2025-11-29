package com.example.securesocial.data.repositories

import com.example.securesocial.data.model.VerificationToken
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface VerificationTokenRepository : MongoRepository<VerificationToken, ObjectId> {
    fun findByEmail(email: String): VerificationToken? // We find by Email, then verify hash in code
    fun deleteByEmail(email: String)
}
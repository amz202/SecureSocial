package com.example.securesocial.data.repositories

import com.example.securesocial.data.model.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, ObjectId> {
    fun findByUsername(username: String): User?
}
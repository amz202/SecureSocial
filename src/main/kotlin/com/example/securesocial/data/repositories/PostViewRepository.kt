package com.example.securesocial.data.repositories

import com.example.securesocial.data.model.PostView
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface PostViewRepository: MongoRepository<PostView, ObjectId> {
    fun countByPostId(postId: ObjectId): Long
    fun existsByPostIdAndHashedViewToken(postId: ObjectId, hashedViewToken: String): Boolean //if a user has already viewed the post
}
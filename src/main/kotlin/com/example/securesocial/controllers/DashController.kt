package com.example.securesocial.controllers

import com.example.securesocial.data.model.ActivityLog
import com.example.securesocial.data.repositories.ActivityLogRepository
import com.example.securesocial.security.AuthService
import com.example.securesocial.security.JwtService
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DashController(
    private val authService: AuthService,
    private val activityLogRepository: ActivityLogRepository,
    private val jwtService: JwtService
) {

    @GetMapping("/activity-log")
    fun getActivityLog(
        @RequestHeader("Authorization") token: String
    ): ResponseEntity<List<ActivityLog>> {

        val userId = jwtService.getUserIdFromToken(token)
        val logs = activityLogRepository.findByUserId(userId)

        return ResponseEntity.ok(logs)
    }

}
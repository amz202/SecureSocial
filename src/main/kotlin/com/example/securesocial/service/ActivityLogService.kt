package com.example.securesocial.service

import com.example.securesocial.data.model.ActivityLog
import com.example.securesocial.data.model.LogType
import com.example.securesocial.data.repositories.ActivityLogRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class ActivityLogService(private val activityLogRepository: ActivityLogRepository) {

    @Async
    fun log(userId: String, action: LogType, details: String?) {
        val log = ActivityLog(
            userId = userId,
            action = action,
            details = details,
        )
        activityLogRepository.save(log)
    }
}
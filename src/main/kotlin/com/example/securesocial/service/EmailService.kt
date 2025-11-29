package com.example.securesocial.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class EmailService(private val mailSender: JavaMailSender) {

    @Async
    fun sendVerificationEmail(toEmail: String, otp: String) {
        val message = SimpleMailMessage()
        message.setTo(toEmail)
        message.setSubject("SecureSocial Verification Code")
        message.setText("Your verification code is: $otp\n\nThis code expires in 5 minutes.")

        try {
            mailSender.send(message)
        } catch (e: Exception) {
            // Log error in production, print stack trace for dev
            e.printStackTrace()
        }
    }
}
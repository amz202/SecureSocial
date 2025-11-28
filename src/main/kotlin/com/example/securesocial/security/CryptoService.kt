package com.example.securesocial.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.util.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

@Service
class CryptoService(
    @Value("\${app.security.hmac-secret}") private val hmacSecret: String,
    @Value("\${app.security.view-pepper}") private val viewPepper: String
) {

    fun signLike(userId: String, postId: String, timestamp: Long): String {
        val data = "$userId:$postId:$timestamp"
        return calculateHmac(data, hmacSecret)
    }

    fun verifyLikeSignature(userId: String, postId: String, timestamp: Long, signature: String): Boolean {
        val expectedSignature = signLike(userId, postId, timestamp)
        return MessageDigest.isEqual(
            signature.toByteArray(StandardCharsets.UTF_8),
            expectedSignature.toByteArray(StandardCharsets.UTF_8)
        )
    }

    fun generateAnonymousViewToken(userId: String, postId: String): String {
        val input = "$userId:$postId:$viewPepper"
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(input.toByteArray(StandardCharsets.UTF_8))
        return Base64.getEncoder().encodeToString(hash)
    }

    private fun calculateHmac(data: String, secret: String): String {
        val sha256Hmac = Mac.getInstance("HmacSHA256")
        val secretKey = SecretKeySpec(secret.toByteArray(StandardCharsets.UTF_8), "HmacSHA256")
        sha256Hmac.init(secretKey)
        return Base64.getEncoder().encodeToString(sha256Hmac.doFinal(data.toByteArray(StandardCharsets.UTF_8)))
    }
}
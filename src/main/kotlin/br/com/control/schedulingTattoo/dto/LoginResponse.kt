package br.com.control.schedulingTattoo.dto

data class LoginResponse(
    val token: String,
    val expiresIn: Long
)

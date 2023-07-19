package com.alexmumo.domain.repository

interface AuthRepository {
    suspend fun registerUser(name: String, email:String, password: String)
    suspend fun loginUser(email: String, password: String)
    suspend fun logOutUser()
}
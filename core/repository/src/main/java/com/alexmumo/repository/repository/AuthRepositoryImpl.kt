package com.alexmumo.repository.repository

import com.alexmumo.domain.repository.AuthRepository

class AuthRepositoryImpl: AuthRepository {
    override suspend fun registerUser(name: String, email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun loginUser(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun logOutUser() {
        TODO("Not yet implemented")
    }
}
package com.alexmumo.presentation.state

import com.google.firebase.auth.AuthResult

data class AuthState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: AuthResult? = null
)

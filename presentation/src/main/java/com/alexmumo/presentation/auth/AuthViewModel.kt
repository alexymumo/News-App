package com.alexmumo.presentation.auth

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmumo.common.Resource
import com.alexmumo.domain.repository.AuthRepository
import com.alexmumo.domain.repository.AuthState
import com.alexmumo.presentation.state.TextFieldState
import kotlinx.coroutines.launch

class AuthViewModel constructor(private val authRepository: AuthRepository): ViewModel() {
    private val _loginState = mutableStateOf(AuthState())
    val loginState: State<AuthState> = _loginState

    private val _registerState = mutableStateOf(AuthState())
    val registerState: State<AuthState> = _registerState

    private val _forgotState = mutableStateOf(AuthState())
    val forgotState: State<AuthState> = _forgotState

    private val _emailState = mutableStateOf(TextFieldState())
    val emailState : State<TextFieldState> = _emailState

    private val _usernameState = mutableStateOf(TextFieldState())
    val usernameState: State<TextFieldState> = _usernameState

    private val _passwordState = mutableStateOf(TextFieldState())
    val passwordState: State<TextFieldState> =  _passwordState

    fun forgotPassword() {
        viewModelScope.launch {
            if (emailState.value.text.isEmpty()) {

            }
            when(
                val result = authRepository.forgotPassword(email = emailState.value.text.trim())
            ) {
                is Resource.Error -> {
                    _forgotState.value = forgotState.value.copy(
                        isLoading = false,
                        error = result.message ?: "An error occurred"
                    )

                }
                is Resource.Success -> {
                    _forgotState.value = forgotState.value.copy(
                        isLoading = false,
                        data = null
                    )

                }

                else -> {}
            }
        }
    }
    fun signInUser() {
        viewModelScope.launch {
            if (emailState.value.text.isEmpty()) {
            }
            if (passwordState.value.text.isEmpty()) {

            }
            when (
                val auth = authRepository.loginUser(email = emailState.value.text.trim(), password = passwordState.value.text.trim())
            ) {
                is Resource.Error -> {
                    _loginState.value = loginState.value.copy(
                        isLoading = false,
                        error = auth.message?: "Unknown error occurred"
                    )
                }
                is Resource.Success -> {
                    _loginState.value = loginState.value.copy(
                        isLoading = false,
                        data = auth.data
                    )
                }

                else -> {}
            }
        }
    }

    fun signUpUser() {
        viewModelScope.launch {
            if (passwordState.value.text.isEmpty()) {

            }
            if (usernameState.value.text.isEmpty()) {

            }
            if (emailState.value.text.isEmpty()) {

            }
            when(
                val result = authRepository.registerUser(
                    name = usernameState.value.text.trim(),
                    email = emailState.value.text.trim(),
                    password = passwordState.value.text.trim()
                )
            ) {
                is Resource.Success -> {
                    _registerState.value = registerState.value.copy(
                        isLoading = false,
                        data = result.data
                    )
                }
                is Resource.Error -> {
                    _registerState.value = registerState.value.copy(
                        isLoading = false,
                        data = result.data
                    )
                }

                else -> {}
            }

        }
    }
}
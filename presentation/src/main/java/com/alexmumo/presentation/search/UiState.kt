package com.alexmumo.presentation.search

sealed interface UiState<out T>{
  data class Success<T>(val data: T): UiState<T>
  data class Error<T>(val message: String): UiState<T>
  object Loading: UiState<Nothing>

}
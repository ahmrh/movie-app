package com.ahmrh.movieapp.core.state

sealed class UiState<out T: Any?> {
    data object Idle: UiState<Nothing>()
    data object Loading: UiState<Nothing>()

    data class Success<out T: Any>(val data: T) : UiState<T>()

    data class Error(val errorMessage: String) : UiState<Nothing>()
}
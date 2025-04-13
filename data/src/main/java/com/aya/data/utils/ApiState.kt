package com.aya.data.utils

sealed class ApiState<out T> {
    data object Loading : ApiState<Nothing>()
    data class Success<T>(val data: T) : ApiState<T>()
    data class Error(val exception: Throwable? = null) : ApiState<Nothing>()
}

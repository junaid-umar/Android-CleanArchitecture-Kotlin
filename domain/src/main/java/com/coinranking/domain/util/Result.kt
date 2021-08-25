package com.coinranking.domain.util

import com.coinranking.domain.util.Result.Success

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: String) : Result<Nothing>()
    data class Loading<out T>(val data: T? = null) : Result<T>()

}

fun <T, R> Result<T>.transform(
    transform: ((value: T) -> R),
): Result<R> = when (this) {
    is Success -> Success(transform.invoke(data))
    is Result.Error -> Result.Error(error)
    is Result.Loading -> Result.Loading(data?.let { transform.invoke(it) })
}


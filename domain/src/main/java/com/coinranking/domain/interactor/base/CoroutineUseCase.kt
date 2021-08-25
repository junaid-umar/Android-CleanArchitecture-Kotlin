package com.coinranking.domain.interactor.base

import com.coinranking.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class CoroutineUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    execute(parameters).let {
                        Result.Success(it)
                    }
                }
            }
        } catch (exception: Exception) {
            Result.Error(exception.localizedMessage)
        }
    }

    protected abstract suspend fun execute(parameters: P): R
}
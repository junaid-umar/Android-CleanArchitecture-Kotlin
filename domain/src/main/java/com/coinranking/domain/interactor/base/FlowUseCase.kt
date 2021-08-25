package com.coinranking.domain.interactor.base

import com.coinranking.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Flow<Result<R>> =
        execute(parameters)
            .catch { e -> emit(Result.Error(e.localizedMessage)) }.flowOn(coroutineDispatcher)


    abstract suspend fun execute(parameters: P): Flow<Result<R>>
}
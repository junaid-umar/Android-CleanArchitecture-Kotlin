package com.coinranking.data.remote.util

import com.coinranking.data.remote.util.NetworkUtils.getErrorMessage
import com.coinranking.data.remote.util.NetworkUtils.getNetworkErrorMessage
import com.coinranking.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

abstract class BaseRemoteDataSource {


    fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>,
    ): Flow<Result<T>> =
        flow {
            emit(Result.Loading())
            emit(safeApiResult(call.invoke()))

        }.catch { e ->
            emit(Result.Error(getNetworkErrorMessage(e)))
        }


    private fun <T> safeApiResult(response: Response<T>): Result<T> {
        return if (response.isSuccessful) Result.Success(response.body()!!)
        else Result.Error(getErrorMessage(response.code()))
    }

}
package com.coinranking.data.repository

import com.coinranking.data.cache.ExchangeCacheData
import com.coinranking.data.remote.exchange.ExchangeRemoteData
import com.coinranking.domain.model.Exchange
import com.coinranking.domain.repository.ExchangeRepository
import com.coinranking.domain.util.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class ExchangeRepositoryImpl
@Inject
constructor(
    private val exchangeRemoteData: ExchangeRemoteData,
    private val exchangeCacheData: ExchangeCacheData,
) : ExchangeRepository {
    override suspend fun getExchanges(): Flow<Result<List<Exchange>>> = flow {
        emit(Result.Loading())

        val data = exchangeCacheData.getExchanges()
        if (data.isNotEmpty()) {
            emit(Result.Loading(data))
        }

        exchangeRemoteData.getExchanges().collect { result ->
            if (result !is Result.Loading) {
                if (result is Result.Success) {
                    exchangeCacheData.insertOrReplace(result.data)
                    emit(Result.Success(exchangeCacheData.getExchanges()))
                } else if (result is Result.Error) {
                    emit(Result.Error(result.error))
                }
            }
        }
    }
}
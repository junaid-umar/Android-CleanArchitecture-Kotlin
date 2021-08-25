package com.coinranking.domain.repository

import com.coinranking.domain.model.Exchange
import com.coinranking.domain.util.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
interface ExchangeRepository {
    suspend fun getExchanges(): Flow<Result<List<Exchange>>>
}
package com.coinranking.data.remote.exchange

import com.coinranking.domain.model.Exchange
import com.coinranking.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface ExchangeRemoteData {
    suspend fun getExchanges(): Flow<Result<List<Exchange>>>
}
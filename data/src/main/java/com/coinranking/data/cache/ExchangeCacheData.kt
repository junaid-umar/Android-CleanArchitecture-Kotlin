package com.coinranking.data.cache

import com.coinranking.domain.model.Exchange
import kotlinx.coroutines.flow.Flow

interface ExchangeCacheData {
    suspend fun insertOrReplace(exchanges: List<Exchange>)
    suspend fun getExchanges(): List<Exchange>
}
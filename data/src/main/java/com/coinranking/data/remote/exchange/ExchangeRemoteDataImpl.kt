package com.coinranking.data.remote.exchange

import com.coinranking.data.remote.exchange.api.ExchangeService
import com.coinranking.data.remote.exchange.model.ExchangeDtoMapper
import com.coinranking.data.remote.util.BaseRemoteDataSource
import com.coinranking.domain.model.Exchange
import com.coinranking.domain.util.Result
import com.coinranking.domain.util.transform
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExchangeRemoteDataImpl
@Inject
constructor(
    private val exchangeService: ExchangeService,
    private val mapper: ExchangeDtoMapper,
) : ExchangeRemoteData, BaseRemoteDataSource() {
    override suspend fun getExchanges(): Flow<Result<List<Exchange>>> {
        return safeApiCall {
            exchangeService.getExchanges()
        }.map {
            it.transform {
                mapper.toDomainList(it.data.exchanges)
            }
        }
    }
}
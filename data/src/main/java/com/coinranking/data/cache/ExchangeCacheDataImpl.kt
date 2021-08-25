package com.coinranking.data.cache

import com.coinranking.data.cache.dao.ExchangeDao
import com.coinranking.data.cache.model.ExchangeEntityMapper
import com.coinranking.domain.model.Exchange
import javax.inject.Inject

class ExchangeCacheDataImpl
@Inject
constructor(
    private val exchangeDao: ExchangeDao,
    private val mapper: ExchangeEntityMapper,
) : ExchangeCacheData {
    override suspend fun insertOrReplace(exchanges: List<Exchange>) {
        exchangeDao.insertExchanges(mapper.fromDomainList(exchanges))
    }

    override suspend fun getExchanges(): List<Exchange> {
        return exchangeDao.getExchanges().map {
            mapper.toDomainModel(it)
        }

    }
}
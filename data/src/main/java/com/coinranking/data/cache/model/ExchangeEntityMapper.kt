package com.coinranking.data.cache.model

import com.coinranking.domain.model.Exchange
import com.coinranking.domain.util.DomainMapper
import java.math.BigDecimal

class ExchangeEntityMapper : DomainMapper<ExchangeEntity, Exchange> {
    override fun toDomainModel(model: ExchangeEntity): Exchange {
        return Exchange(
            exchangeId = model.exchangeId,
            rank = model.rank,
            name = model.name,
            iconUrl = model.iconUrl,
            verified = model.verified,
            recommended = model.recommended,
            numberOfMarkets = model.numberOfMarkets,
            numberOfCoins = model.numberOfCoins,
            marketShare = model.marketShare.toFloat(),
            coinRankingUrl = model.coinRankingUrl,
            volume = BigDecimal(model.volume)
        )
    }

    override fun fromDomainModel(domainModel: Exchange): ExchangeEntity {
        return ExchangeEntity(
            exchangeId = domainModel.exchangeId,
            rank = domainModel.rank,
            name = domainModel.name,
            iconUrl = domainModel.iconUrl,
            verified = domainModel.verified,
            recommended = domainModel.recommended,
            numberOfMarkets = domainModel.numberOfMarkets,
            numberOfCoins = domainModel.numberOfCoins,
            marketShare = domainModel.marketShare.toString(),
            coinRankingUrl = domainModel.coinRankingUrl,
            volume = domainModel.volume.toString()
        )
    }

    fun toDomainList(exchanges: List<ExchangeEntity>): List<Exchange> {
        return exchanges.map {
            toDomainModel(it)
        }
    }

    fun fromDomainList(exchanges: List<Exchange>): List<ExchangeEntity> {
        return exchanges.map {
            fromDomainModel(it)
        }
    }
}
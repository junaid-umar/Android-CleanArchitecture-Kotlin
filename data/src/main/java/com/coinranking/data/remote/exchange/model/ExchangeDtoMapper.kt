package com.coinranking.data.remote.exchange.model

import com.coinranking.domain.model.Exchange
import com.coinranking.domain.util.DomainMapper
import java.math.BigDecimal

class ExchangeDtoMapper : DomainMapper<ExchangeDto, Exchange> {
    override fun toDomainModel(model: ExchangeDto): Exchange {
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

    override fun fromDomainModel(domainModel: Exchange): ExchangeDto {
        return ExchangeDto(
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

    fun toDomainList(exchanges: List<ExchangeDto>): List<Exchange> {
        return exchanges.map {
            toDomainModel(it)
        }
    }

    fun fromDomainList(exchanges: List<Exchange>): List<ExchangeDto> {
        return exchanges.map {
            fromDomainModel(it)
        }
    }
}
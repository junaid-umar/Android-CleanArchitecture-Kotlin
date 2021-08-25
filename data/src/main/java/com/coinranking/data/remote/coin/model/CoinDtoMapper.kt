package com.coinranking.data.remote.coin.model

import com.coinranking.domain.model.Coin
import com.coinranking.domain.util.DomainMapper
import com.coinranking.domain.util.TimeUtils
import java.math.BigDecimal

class CoinDtoMapper : DomainMapper<CoinDto, Coin> {
    override fun toDomainModel(model: CoinDto): Coin {
        return Coin(
            uuid = model.coinId,
            symbol = model.symbol,
            name = model.name,
            iconUrl = model.iconUrl,
            marketCap = BigDecimal(model.marketCap),
            price = BigDecimal(model.price),
            listedTimestamp = TimeUtils.epochToDate(model.listedTimestamp),
            tier = model.tier,
            change = BigDecimal(model.change),
            rank = model.rank,
            sparkline = model.sparkline.toBigDecimal(),
            lowVolume = model.lowVolume,
            coinRankingUrl = model.coinRankingUrl,
            volume = BigDecimal(model.volume),
            btcPrice = BigDecimal(model.btcPrice),
            isFavourite = false

        )
    }

    override fun fromDomainModel(domainModel: Coin): CoinDto {
        return CoinDto(
            coinId = domainModel.uuid,
            symbol = domainModel.symbol,
            name = domainModel.name,
            iconUrl = domainModel.iconUrl,
            marketCap = domainModel.marketCap.toString(),
            price = domainModel.price.toString(),
            listedTimestamp = TimeUtils.dateToEpoch(domainModel.listedTimestamp),
            tier = domainModel.tier,
            change = domainModel.change.toString(),
            rank = domainModel.rank,
            sparkline = domainModel.sparkline.toStringList(),
            lowVolume = domainModel.lowVolume,
            coinRankingUrl = domainModel.coinRankingUrl,
            volume = domainModel.volume.toString(),
            btcPrice = domainModel.btcPrice.toString()
        )
    }

    fun toDomainList(coins: List<CoinDto>): List<Coin> {
        return coins.map {
            toDomainModel(it)
        }
    }

    fun fromDomainList(coins: List<Coin>): List<CoinDto> {
        return coins.map {
            fromDomainModel(it)
        }
    }

}

fun List<String>.toBigDecimal(): List<BigDecimal> {
    return this.map {
        BigDecimal(it)
    }
}

fun List<BigDecimal>.toStringList(): List<String> {
    return this.map {
        it.toString()
    }
}
package com.coinranking.domain.model

import java.math.BigDecimal
import java.time.ZonedDateTime

typealias CoinId = String

data class Coin(
    val uuid: CoinId,
    val symbol: String,
    val name: String,
    val iconUrl: String,
    val marketCap: BigDecimal,
    val price: BigDecimal,
    val listedTimestamp: ZonedDateTime,
    val tier: Int,
    val change: BigDecimal,
    val rank: Int,
    val sparkline: List<BigDecimal>,
    val lowVolume: Boolean,
    val coinRankingUrl: String,
    val volume: BigDecimal,
    val btcPrice: BigDecimal,
    val isFavourite: Boolean,
)

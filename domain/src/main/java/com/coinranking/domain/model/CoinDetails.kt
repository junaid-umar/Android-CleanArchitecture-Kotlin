package com.coinranking.domain.model

import java.math.BigDecimal
import java.time.ZonedDateTime

data class CoinDetails(
    val coinId: String,
    val volume: BigDecimal,
    val allTimeHigh: AllTimeHigh,
    val btcPrice: BigDecimal,
    val change: BigDecimal,
    val coinRankingUrl: String,
    val color: String,
    val description: String,
    val iconUrl: String,
    val links: List<Link>,
    val lowVolume: Boolean,
    val marketCap: BigDecimal,
    val name: String,
    val numberOfExchanges: Int,
    val numberOfMarkets: Int,
    val price: BigDecimal,
    val rank: Int,
    val sparkline: List<BigDecimal>,
    val supply: Supply,
    val symbol: String,
    val tier: Int,
    val websiteUrl: String,
)

data class AllTimeHigh(
    val price: BigDecimal,
    val timeStamp: ZonedDateTime,
)

data class Supply(
    val circulating: Long,
    val confirmed: Boolean,
    val total: Long,
)

data class Link(
    val name: String,
    val type: String,
    val url: String,
)
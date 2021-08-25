package com.coinranking.domain.model

import java.math.BigDecimal

typealias ExchangeId = String

data class Exchange(
    val exchangeId: ExchangeId,
    val rank: Int,
    val name: String,
    val iconUrl: String,
    val verified: Boolean,
    val recommended: Boolean,
    val numberOfMarkets: Int,
    val numberOfCoins: Int,
    val marketShare: Float,
    val coinRankingUrl: String,
    val volume: BigDecimal,
)

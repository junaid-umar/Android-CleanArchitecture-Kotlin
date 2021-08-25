package com.coinranking.data.remote.coin.response

import com.coinranking.data.remote.coin.model.CoinDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class CoinsResponse(
    @SerialName("status")
    var status: String,

    @SerialName("data")
    var data: DataDto,
)
@Serializable
data class DataDto(
    @SerialName("stats")
    var stats: StatsDto,
    @SerialName("coins")
    var coins: List<CoinDto>,
)
@Serializable
data class StatsDto(
    @SerialName("total")
    var total: Int,
    @SerialName("total24hVolume")
    var total24hVolume: String,
    @SerialName("totalExchanges")
    var totalExchanges: Int,
    @SerialName("totalMarketCap")
    var totalMarketCap: String,
    @SerialName("totalMarkets")
    var totalMarkets: Int
)
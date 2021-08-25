package com.coinranking.data.remote.coin.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDto(

    @SerialName("uuid")
    var coinId: String,
    @SerialName("symbol")
    var symbol: String,
    @SerialName("name")
    var name: String,
    @SerialName("iconUrl")
    var iconUrl: String,
    @SerialName("marketCap")
    var marketCap: String,
    @SerialName("price")
    var price: String,
    @SerialName("listedAt")
    var listedTimestamp: Long,
    @SerialName("tier")
    var tier: Int,
    @SerialName("change")
    var change: String,
    @SerialName("rank")
    var rank: Int,
    @SerialName("sparkline")
    var sparkline: List<String>,
    @SerialName("lowVolume")
    var lowVolume: Boolean,
    @SerialName("coinrankingUrl")
    var coinRankingUrl: String,
    @SerialName("24hVolume")
    var volume: String,
    @SerialName("btcPrice")
    var btcPrice: String,
)
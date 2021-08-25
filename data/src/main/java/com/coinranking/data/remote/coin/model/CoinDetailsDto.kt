package com.coinranking.data.remote.coin.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailsDto(
    @SerialName("uuid")
    val coinId: String,
    @SerialName("24hVolume")
    val volume: String,
    @SerialName("allTimeHigh")
    val allTimeHigh: AllTimeHighDto,
    @SerialName("btcPrice")
    val btcPrice: String,
    @SerialName("change")
    val change: String,
    @SerialName("coinrankingUrl")
    val coinRankingUrl: String,
    @SerialName("color")
    val color: String,
    @SerialName("description")
    val description: String,
    @SerialName("iconUrl")
    val iconUrl: String,
    @SerialName("links")
    val links: List<LinkDto>,
    @SerialName("lowVolume")
    val lowVolume: Boolean,
    @SerialName("marketCap")
    val marketCap: String,
    @SerialName("name")
    val name: String,
    @SerialName("numberOfExchanges")
    val numberOfExchanges: Int,
    @SerialName("numberOfMarkets")
    val numberOfMarkets: Int,
    @SerialName("price")
    val price: String,
    @SerialName("rank")
    val rank: Int,
    @SerialName("sparkline")
    val sparkline: List<String>,
    @SerialName("supply")
    val supply: SupplyDto,
    @SerialName("symbol")
    val symbol: String,
    @SerialName("tier")
    val tier: Int,
    @SerialName("websiteUrl")
    val websiteUrl: String,
)

@Serializable
data class AllTimeHighDto(
    @SerialName("price")
    val price: String,

    @SerialName("timestamp")
    val timeStamp: Long,
)

@Serializable
data class SupplyDto(
    @SerialName("circulating")
    val circulating: String,
    @SerialName("confirmed")
    val confirmed: Boolean,
    @SerialName("total")
    val total: String,
)

@Serializable
data class LinkDto(
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String,
    @SerialName("url")
    val url: String,
)


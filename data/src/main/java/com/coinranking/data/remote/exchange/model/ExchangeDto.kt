package com.coinranking.data.remote.exchange.model

import com.coinranking.domain.model.ExchangeId
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeDto(
    @SerialName("uuid")
    val exchangeId: ExchangeId,

    @SerialName("rank")
    val rank: Int,

    @SerialName("name")
    val name: String,

    @SerialName("iconUrl")
    val iconUrl: String,

    @SerialName("verified")
    val verified: Boolean,

    @SerialName("recommended")
    val recommended: Boolean,

    @SerialName("numberOfMarkets")
    val numberOfMarkets: Int,

    @SerialName("numberOfCoins")
    val numberOfCoins: Int,

    @SerialName("marketShare")
    val marketShare: String,

    @SerialName("coinrankingUrl")
    val coinRankingUrl: String,

    @SerialName("24hVolume")
    val volume: String,
)
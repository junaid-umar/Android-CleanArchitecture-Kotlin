package com.coinranking.data.remote.exchange.response

import com.coinranking.data.remote.exchange.model.ExchangeDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeResponse(
    val status: String,

    val data: ExchangeData,
)

@Serializable
data class ExchangeData(
    val stats: ExchangeStatsData,

    val exchanges: List<ExchangeDto>,
)

@Serializable
data class ExchangeStatsData(
    @SerialName("24hVolume")
    val volume: String,

    val total: Int,
)
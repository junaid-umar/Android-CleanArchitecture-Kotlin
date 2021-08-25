package com.coinranking.data.remote.coin.response

import com.coinranking.data.remote.coin.model.CoinDetailsDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailsResponse(
    @SerialName("status")
    val status: String,

    @SerialName("data")
    val data: Data,
)

@Serializable
data class Data(
    @SerialName("coin")
    val coinDetails: CoinDetailsDto,
)






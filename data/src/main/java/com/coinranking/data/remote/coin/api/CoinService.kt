package com.coinranking.data.remote.coin.api

import com.coinranking.data.remote.coin.response.CoinDetailsResponse
import com.coinranking.data.remote.coin.response.CoinsResponse
import com.coinranking.domain.model.CoinId
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CoinService {
    @GET("/v2/coins")
    suspend fun getCoins(
        @Query("timePeriod") timePeriod: String,
        @Query("orderBy") orderBy: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): Response<CoinsResponse>

    @GET("/v2/coin/{coinId}")
    suspend fun getCoinDetails(
        @Path("coinId") coinId: CoinId,
        @Query("timePeriod") timePeriod: String,
    ): Response<CoinDetailsResponse>
}
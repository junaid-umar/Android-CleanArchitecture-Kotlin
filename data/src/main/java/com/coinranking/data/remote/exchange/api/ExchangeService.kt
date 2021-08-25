package com.coinranking.data.remote.exchange.api

import com.coinranking.data.remote.exchange.response.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ExchangeService {
    @GET("/v2/exchanges")
    suspend fun getExchanges(): Response<ExchangeResponse>
}
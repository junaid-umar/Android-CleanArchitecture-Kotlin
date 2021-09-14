package com.coinranking.data.remote.util

import com.coinranking.data.MockResponseFileReader
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class CustomDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/v2/exchanges" -> {
                MockResponse().setResponseCode(MockNetworkConfig.STATUS)
                    .setBody(MockResponseFileReader("exchange.json").content)
            }
            "/v2/coins?timePeriod=7d&orderBy=24hVolume&limit=100&offset=1" -> {
                MockResponse().setResponseCode(MockNetworkConfig.STATUS)
                    .setBody(MockResponseFileReader("coin.json").content)
            }
            "/v2/coin/Qwsogvtv82FCd?timePeriod=7d" -> {
                MockResponse().setResponseCode(MockNetworkConfig.STATUS)
                    .setBody(MockResponseFileReader("coindetail.json").content)
            }
            else -> throw Exception("Unable to find ${request.path}")
        }
    }
}
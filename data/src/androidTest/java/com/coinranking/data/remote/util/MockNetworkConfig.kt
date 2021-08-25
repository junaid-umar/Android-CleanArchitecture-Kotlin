package com.coinranking.data.remote.util

import java.net.HttpURLConnection

object MockNetworkConfig {
    const val TEST_BASE_URL = "https://api.coinranking.com/"
    const val RANDOM_BASE_URL = "https://unabletoresolvehost.com/"
    const val STATUS = HttpURLConnection.HTTP_CLIENT_TIMEOUT
}
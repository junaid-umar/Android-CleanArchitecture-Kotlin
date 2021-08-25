package com.coinranking.data

import com.coinranking.domain.model.Exchange
import java.io.InputStreamReader
import java.math.BigDecimal

object FakeDataUtil {
    object FakeExchange {
        val exchange1 = Exchange(
            exchangeId = "Qwsogvtv82FCd",
            rank = 1,
            name = "Binance",
            iconUrl = "test.png",
            verified = true,
            recommended = true,
            numberOfMarkets = 1,
            numberOfCoins = 1,
            marketShare = 25.0f,
            coinRankingUrl = "test.com",
            volume = BigDecimal(22),
        )
        val exchange2 = Exchange(
            exchangeId = "Qwsogvtv82FCd2",
            rank = 2,
            name = "Binance2",
            iconUrl = "test2.png",
            verified = true,
            recommended = true,
            numberOfMarkets = 2,
            numberOfCoins = 2,
            marketShare = 25.0f,
            coinRankingUrl = "test.com",
            volume = BigDecimal(33),
        )

        val exchanges = mutableListOf(exchange1, exchange2)
    }
}

class MockResponseFileReader(path: String) {
    val content: String

    init {
        val reader = InputStreamReader(this.javaClass.classLoader!!.getResourceAsStream(path))
        content = reader.readText()
        reader.close()
    }
}
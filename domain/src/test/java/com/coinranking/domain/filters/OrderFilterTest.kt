package com.coinranking.domain.filters

import org.junit.Assert
import org.junit.Test

class OrderFilterTest {

    private val uiValueMarket = "MarketCap"
    private val uiValueRandom = "random"
    private val filterMarket = OrderFilter.MarketCap
    private val filterPrice = OrderFilter.Price

    @Test
    fun givenUiValue_returnsFilter() {
        val result = getOrderFilter(uiValueMarket)
        Assert.assertEquals(result, filterMarket)
    }

    @Test
    fun givenRandomUiValue_returnsPriceFilter() {
        val result = getOrderFilter(uiValueRandom)
        Assert.assertEquals(result, filterPrice)
    }

}
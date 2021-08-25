package com.coinranking.domain.filters

import org.junit.Assert
import org.junit.Test

class TimeFilterTest {

    private val uiValueDays = "7 days"
    private val uiValueRandom = "random"
    private val filterDays = TimeFilter.Days7
    private val filterHour = TimeFilter.Hours24

    @Test
    fun givenUiValue_returnsFilter() {
        val result = getTimeFilter(uiValueDays)
        Assert.assertEquals(result, filterDays)
    }

    @Test
    fun givenRandomUiValue_returnsPriceFilter() {
        val result = getTimeFilter(uiValueRandom)
        Assert.assertEquals(result, filterHour)
    }

}
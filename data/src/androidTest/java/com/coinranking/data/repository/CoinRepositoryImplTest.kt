package com.coinranking.data.repository

import com.coinranking.domain.filters.OrderFilter
import com.coinranking.domain.filters.TimeFilter
import com.coinranking.domain.interactor.GetCoinDetailsParams
import com.coinranking.domain.interactor.GetCoinsParams
import com.coinranking.domain.repository.CoinRepository
import com.coinranking.domain.util.Result
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.Assert.assertTrue
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
class CoinRepositoryImplTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)


    @Inject
    lateinit var mockServer: MockWebServer


    @Inject
    lateinit var coinRepository: CoinRepository

    private val coinId = "Qwsogvtv82FCd"

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun getCoin() = runBlocking {

        val output = coinRepository.getCoins(GetCoinsParams(
            1, OrderFilter.Hours24Volume, TimeFilter.Days7
        )).toList()

        assertTrue(output.get(0) is (Result.Loading))
        val result = (output[1] as Result.Success).data

        Assert.assertEquals(result.get(0).uuid, coinId)
    }

    @Test
    fun getCoinsDetailsSuccess() = runBlocking {

        val output = coinRepository.getCoinDetails(GetCoinDetailsParams(
            coinId, TimeFilter.Days7
        )).toList()

        assertTrue(output.get(0) is (Result.Loading))
        val result = (output[1] as Result.Success).data
        Assert.assertEquals(result.coinId, coinId)
    }

    @Test
    fun getCoinsDetailsError() = runBlocking {

        val output = coinRepository.getCoinDetails(GetCoinDetailsParams(
            "", TimeFilter.Days7
        )).toList()

        assertTrue(output.get(0) is (Result.Loading))
        assertTrue(output.get(1) is (Result.Error))
    }
}

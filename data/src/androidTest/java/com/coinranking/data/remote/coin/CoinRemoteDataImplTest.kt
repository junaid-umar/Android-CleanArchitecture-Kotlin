package com.coinranking.data.remote.coin

import com.coinranking.domain.filters.OrderFilter
import com.coinranking.domain.filters.TimeFilter
import com.coinranking.domain.interactor.GetCoinDetailsParams
import com.coinranking.domain.interactor.GetCoinsParams
import com.coinranking.domain.util.Result
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
class CoinRemoteDataImplTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)


    @Inject
    lateinit var mockServer: MockWebServer


    @Inject
    lateinit var coinRemoteData: CoinRemoteData

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

        val output = coinRemoteData.getCoin(GetCoinsParams(
            1, OrderFilter.Hours24Volume, TimeFilter.Days7
        )).toList()

        assertTrue(output.get(0) is (Result.Loading))
        val result = (output[1] as Result.Success).data

        assertEquals(result.get(0).uuid, coinId)
    }

    @Test
    fun getCoinsDetailsSuccess() = runBlocking {

        val output = coinRemoteData.getCoinDetails(GetCoinDetailsParams(
            coinId, TimeFilter.Days7
        )).toList()

        assertTrue(output.get(0) is (Result.Loading))
        val result = (output[1] as Result.Success).data
        assertEquals(result.coinId, coinId)
    }

    @Test
    fun getCoinsDetailsError() = runBlocking {

        val output = coinRemoteData.getCoinDetails(GetCoinDetailsParams(
            "", TimeFilter.Days7
        )).toList()

        assertTrue(output.get(0) is (Result.Loading))
        assertTrue(output.get(1) is (Result.Error))
    }
}

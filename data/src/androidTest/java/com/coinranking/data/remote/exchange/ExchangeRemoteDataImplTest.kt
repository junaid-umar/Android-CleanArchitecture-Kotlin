package com.coinranking.data.remote.exchange

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.coinranking.data.MainCoroutineRule
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
class ExchangeRemoteDataImplTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @get:Rule(order = 1)
    val coroutineTestRule = MainCoroutineRule()

    val exchangeId = "-zdvbieRdZ"

    @Inject
    lateinit var mockServer: MockWebServer


    @Inject
    lateinit var exchangeRemoteData: ExchangeRemoteData


    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun getExchanges() = runBlocking {


        val output = exchangeRemoteData.getExchanges().toList()

        assertTrue(output.get(0) is (Result.Loading))
        val result = (output[1] as Result.Success).data

        Assert.assertEquals(result.get(0).exchangeId, exchangeId)

    }
}


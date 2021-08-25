package com.coinranking.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.coinranking.data.MainCoroutineRule
import com.coinranking.data.remote.exchange.ExchangeRemoteData
import com.coinranking.domain.repository.ExchangeRepository
import com.coinranking.domain.util.Result
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
class ExchangeRepositoryImplTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @get:Rule(order = 1)
    val coroutineTestRule = MainCoroutineRule()


    @Inject
    lateinit var mockServer: MockWebServer


    @Inject
    lateinit var exchangeRepository: ExchangeRepository


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


        val output = exchangeRepository.getExchanges().toList()

        assertTrue(output.get(0) is (Result.Loading))
        assertTrue(output.get(1) is (Result.Success))

    }
}

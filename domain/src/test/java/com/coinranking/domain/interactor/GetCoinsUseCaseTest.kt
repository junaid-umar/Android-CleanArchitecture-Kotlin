package com.coinranking.domain.interactor

import com.coinranking.domain.filters.OrderFilter
import com.coinranking.domain.filters.TimeFilter
import com.coinranking.domain.repository.CoinRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetCoinsUseCaseTest {

    @RelaxedMockK
    lateinit var coinRepository: CoinRepository

    private lateinit var coinsUseCase: GetCoinsUseCase

    private val coinParams = GetCoinsParams(
        1, OrderFilter.Price, TimeFilter.Days7
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        coinsUseCase = GetCoinsUseCase(coinRepository, TestCoroutineDispatcher())
    }

    @Test
    fun getCoins() {
        runBlockingTest {
            coinsUseCase.invoke(
                coinParams
            )
            coVerify {
                coinRepository.getCoins(coinParams)
            }
        }
    }
}
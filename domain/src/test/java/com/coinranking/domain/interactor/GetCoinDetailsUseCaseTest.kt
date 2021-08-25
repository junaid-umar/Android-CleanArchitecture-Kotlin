package com.coinranking.domain.interactor

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
class GetCoinDetailsUseCaseTest {

    @RelaxedMockK
    lateinit var coinRepository: CoinRepository

    private lateinit var coinDetailsUseCase: GetCoinDetailsUseCase

    private val coinParams = GetCoinDetailsParams(
        "testId", TimeFilter.Days7
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        coinDetailsUseCase = GetCoinDetailsUseCase(coinRepository, TestCoroutineDispatcher())
    }

    @Test
    fun getCoinDetails() {
        runBlockingTest {
            coinDetailsUseCase.invoke(
                coinParams
            )
            coVerify {
                coinRepository.getCoinDetails(coinParams)
            }
        }
    }
}
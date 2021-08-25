package com.coinranking.domain.interactor

import com.coinranking.domain.repository.ExchangeRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetExchangesUseCaseTest {

    @RelaxedMockK
    lateinit var exchangeRepository: ExchangeRepository

    private lateinit var exchangesUseCase: GetExchangesUseCase


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        exchangesUseCase = GetExchangesUseCase(exchangeRepository, TestCoroutineDispatcher())
    }

    @Test
    fun getCoins() {
        runBlockingTest {
            exchangesUseCase.invoke(
                Unit
            )
            coVerify {
                exchangeRepository.getExchanges()
            }
        }
    }
}
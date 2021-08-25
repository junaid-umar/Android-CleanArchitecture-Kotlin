package com.coinranking.domain.interactor.base

import com.coinranking.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class FlowUseCaseTest {


    private val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun whenDataUseCase_returnsData() = testDispatcher.runBlockingTest {
        val useCase = DataUseCase(testDispatcher)
        val result = useCase(Unit)
        Assert.assertEquals(result.first(), Result.Success("data"))
    }

    class DataUseCase(dispatcher: CoroutineDispatcher) :
        FlowUseCase<Unit, String>(dispatcher) {
        override suspend fun execute(parameters: Unit): Flow<Result<String>> = flow {
            emit(Result.Success("data"))
        }
    }
}
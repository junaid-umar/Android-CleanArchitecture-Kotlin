package com.coinranking.domain.interactor

import com.coinranking.domain.interactor.base.FlowUseCase
import com.coinranking.domain.model.Exchange
import com.coinranking.domain.repository.ExchangeRepository
import com.coinranking.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class GetExchangesUseCase
@Inject
constructor(
    private val exchangeRepository: ExchangeRepository,
    dispatcher: CoroutineDispatcher,
) : FlowUseCase<Unit, List<Exchange>>(dispatcher) {
    override suspend fun execute(parameters: Unit): Flow<Result<List<Exchange>>> {
        return exchangeRepository.getExchanges()
    }
}

package com.coinranking.domain.interactor

import com.coinranking.domain.filters.OrderFilter
import com.coinranking.domain.filters.TimeFilter
import com.coinranking.domain.interactor.base.FlowUseCase
import com.coinranking.domain.model.Coin
import com.coinranking.domain.repository.CoinRepository
import com.coinranking.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class GetCoinsParams(
    val page: Int,
    val orderFilter: OrderFilter,
    val timeFilter: TimeFilter,
)

class GetCoinsUseCase
@Inject
constructor(
    private val coinRepository: CoinRepository,
    dispatcher: CoroutineDispatcher,
) : FlowUseCase<GetCoinsParams, List<Coin>>(dispatcher) {
    override suspend fun execute(parameters: GetCoinsParams): Flow<Result<List<Coin>>> {
        return coinRepository.getCoins(
            parameters
        )
    }

}



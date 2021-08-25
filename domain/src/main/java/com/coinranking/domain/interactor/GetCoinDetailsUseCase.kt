package com.coinranking.domain.interactor

import com.coinranking.domain.filters.TimeFilter
import com.coinranking.domain.interactor.base.FlowUseCase
import com.coinranking.domain.model.CoinDetails
import com.coinranking.domain.model.CoinId
import com.coinranking.domain.repository.CoinRepository
import com.coinranking.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class GetCoinDetailsParams(
    val coinId: CoinId,
    val timeFilter: TimeFilter,
)

class GetCoinDetailsUseCase
@Inject
constructor(
    private val coinRepository: CoinRepository,
    dispatcher: CoroutineDispatcher,
) : FlowUseCase<GetCoinDetailsParams, CoinDetails>(dispatcher) {
    override suspend fun execute(parameters: GetCoinDetailsParams): Flow<Result<CoinDetails>> {
        return coinRepository.getCoinDetails(parameters)
    }

}

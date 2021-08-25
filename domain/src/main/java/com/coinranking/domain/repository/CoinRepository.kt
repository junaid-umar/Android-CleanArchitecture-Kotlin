package com.coinranking.domain.repository

import com.coinranking.domain.interactor.GetCoinDetailsParams
import com.coinranking.domain.interactor.GetCoinsParams
import com.coinranking.domain.model.Coin
import com.coinranking.domain.model.CoinDetails
import com.coinranking.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getCoins(
        coinsParams: GetCoinsParams,
    ): Flow<Result<List<Coin>>>

    suspend fun getCoinDetails(coinDetailsParams: GetCoinDetailsParams): Flow<Result<CoinDetails>>
}
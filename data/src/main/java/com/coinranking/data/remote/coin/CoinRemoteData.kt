package com.coinranking.data.remote.coin

import com.coinranking.domain.interactor.GetCoinDetailsParams
import com.coinranking.domain.interactor.GetCoinsParams
import com.coinranking.domain.model.Coin
import com.coinranking.domain.model.CoinDetails
import com.coinranking.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface CoinRemoteData {
    suspend fun getCoin(
        coinsParams: GetCoinsParams,
    ): Flow<Result<List<Coin>>>

    suspend fun getCoinDetails(
        coinDetailsParams: GetCoinDetailsParams,
    ): Flow<Result<CoinDetails>>


}
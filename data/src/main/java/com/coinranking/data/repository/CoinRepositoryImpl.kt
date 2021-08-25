package com.coinranking.data.repository

import com.coinranking.data.remote.coin.CoinRemoteData
import com.coinranking.domain.interactor.GetCoinDetailsParams
import com.coinranking.domain.interactor.GetCoinsParams
import com.coinranking.domain.model.Coin
import com.coinranking.domain.model.CoinDetails
import com.coinranking.domain.repository.CoinRepository
import com.coinranking.domain.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinRepositoryImpl
@Inject
constructor(
    private val coinRemoteData: CoinRemoteData,
) : CoinRepository {
    override suspend fun getCoins(
        coinsParams: GetCoinsParams,
    ): Flow<Result<List<Coin>>> {
        return coinRemoteData.getCoin(
            coinsParams
        )
    }

    override suspend fun getCoinDetails(
        coinDetailsParams: GetCoinDetailsParams,
    ): Flow<Result<CoinDetails>> {
        return coinRemoteData.getCoinDetails(coinDetailsParams)
    }


}
package com.coinranking.data.remote.coin

import com.coinranking.data.remote.coin.api.CoinService
import com.coinranking.data.remote.coin.model.CoinDetailsDtoMapper
import com.coinranking.data.remote.coin.model.CoinDtoMapper
import com.coinranking.data.remote.util.BaseRemoteDataSource
import com.coinranking.data.remote.util.NetworkUtils
import com.coinranking.domain.interactor.GetCoinDetailsParams
import com.coinranking.domain.interactor.GetCoinsParams
import com.coinranking.domain.model.Coin
import com.coinranking.domain.model.CoinDetails
import com.coinranking.domain.util.Result
import com.coinranking.domain.util.transform
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CoinRemoteDataImpl
@Inject
constructor(
    private val coinService: CoinService,
    private val mapper: CoinDtoMapper,
    private val detailsMapper: CoinDetailsDtoMapper,
) : CoinRemoteData, BaseRemoteDataSource() {

    override suspend fun getCoin(
        coinsParams: GetCoinsParams,
    ): Flow<Result<List<Coin>>> {
        return safeApiCall {
            coinService.getCoins(
                timePeriod = coinsParams.timeFilter.abbreviation,
                orderBy = coinsParams.orderFilter.abbreviations,
                limit = NetworkUtils.PAGE_SIZE,
                offset = coinsParams.page
            )
        }.map {
            it.transform {
                mapper.toDomainList(it.data.coins)
            }
        }
    }


    override suspend fun getCoinDetails(
        coinDetailsParams: GetCoinDetailsParams,
    ): Flow<Result<CoinDetails>> {

        return safeApiCall {
            coinService.getCoinDetails(
                coinDetailsParams.coinId,
                coinDetailsParams.timeFilter.abbreviation
            )
        }.map {
            it.transform {
                detailsMapper.toDomainModel(it.data.coinDetails)
            }
        }
    }
}
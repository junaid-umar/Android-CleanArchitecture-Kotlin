package com.coinranking.data.di

import com.coinranking.data.cache.ExchangeCacheData
import com.coinranking.data.remote.coin.CoinRemoteData
import com.coinranking.data.remote.exchange.ExchangeRemoteData
import com.coinranking.data.repository.CoinRepositoryImpl
import com.coinranking.data.repository.ExchangeRepositoryImpl
import com.coinranking.domain.interactor.GetExchangesUseCase
import com.coinranking.domain.repository.CoinRepository
import com.coinranking.domain.repository.ExchangeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi


@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [InteractorsModule::class]
)
object InteractorsModuleTest {

    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @ExperimentalCoroutinesApi
    @Provides
    fun provideGetExchangeUseCase(
        exchangeRepository: ExchangeRepository,
        dispatcher: CoroutineDispatcher,
    ): GetExchangesUseCase {
        return GetExchangesUseCase(
            exchangeRepository, dispatcher
        )
    }

    @Provides
    fun provideCoinRepository(
        coinRemoteData: CoinRemoteData,
    ): CoinRepository {
        return CoinRepositoryImpl(
            coinRemoteData
        )
    }


    @ExperimentalCoroutinesApi
    @Provides
    fun provideExchangeRepository(
        exchangeRemoteData: ExchangeRemoteData,
        exchangeCacheData: ExchangeCacheData,
    ): ExchangeRepository {
        return ExchangeRepositoryImpl(
            exchangeRemoteData, exchangeCacheData
        )
    }
}
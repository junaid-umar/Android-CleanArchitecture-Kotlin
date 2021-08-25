package com.coinranking.data.di

import com.coinranking.data.remote.coin.CoinRemoteData
import com.coinranking.data.remote.coin.CoinRemoteDataImpl
import com.coinranking.data.remote.coin.api.CoinService
import com.coinranking.data.remote.coin.model.CoinDetailsDtoMapper
import com.coinranking.data.remote.coin.model.CoinDtoMapper
import com.coinranking.data.remote.exchange.ExchangeRemoteData
import com.coinranking.data.remote.exchange.ExchangeRemoteDataImpl
import com.coinranking.data.remote.exchange.api.ExchangeService
import com.coinranking.data.remote.exchange.model.ExchangeDtoMapper
import com.coinranking.data.remote.util.CustomDispatcher
import com.coinranking.data.remote.util.MockNetworkConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [RemoteModule::class]
)
object RemoteModuleTest {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

    }


    @Singleton
    @Provides
    fun provideMockServer(): MockWebServer {
        val mockWebServer = MockWebServer()
        mockWebServer.dispatcher = CustomDispatcher()

        return mockWebServer
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, mockWebServer: MockWebServer): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url(MockNetworkConfig.TEST_BASE_URL).toString())
            .client(okHttpClient)
            .addConverterFactory(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }.asConverterFactory(contentType)
            )
            .build()
    }


    @Provides
    fun provideCoinService(retrofit: Retrofit): CoinService {
        return retrofit.create(CoinService::class.java)
    }

    @Provides
    fun provideExchangeService(retrofit: Retrofit): ExchangeService {
        return retrofit.create(ExchangeService::class.java)
    }


    @Provides
    fun provideCoinDtoMapper(): CoinDtoMapper {
        return CoinDtoMapper()
    }

    @Provides
    fun provideCoinPriceDtoMapper(): CoinDetailsDtoMapper {
        return CoinDetailsDtoMapper()
    }

    @Provides
    fun provideExchangeDtoMapper(): ExchangeDtoMapper {
        return ExchangeDtoMapper()
    }


    @Provides
    fun provideCoinRemoteData(
        coinService: CoinService,
        mapper: CoinDtoMapper,
        detailsDtoMapper: CoinDetailsDtoMapper,
    ): CoinRemoteData {
        return CoinRemoteDataImpl(coinService, mapper, detailsDtoMapper)
    }


    @Provides
    fun provideExchangeRemoteData(
        exchangeService: ExchangeService,
        mapper: ExchangeDtoMapper,
    ): ExchangeRemoteData {
        return ExchangeRemoteDataImpl(
            exchangeService, mapper
        )
    }
}

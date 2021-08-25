package com.coinranking.data.di

import com.coinranking.data.BuildConfig
import com.coinranking.data.remote.coin.CoinRemoteData
import com.coinranking.data.remote.coin.CoinRemoteDataImpl
import com.coinranking.data.remote.exchange.ExchangeRemoteDataImpl
import com.coinranking.data.remote.coin.api.CoinService
import com.coinranking.data.remote.exchange.api.ExchangeService
import com.coinranking.data.remote.coin.model.CoinDtoMapper
import com.coinranking.data.remote.coin.model.CoinDetailsDtoMapper
import com.coinranking.data.remote.exchange.ExchangeRemoteData
import com.coinranking.data.remote.exchange.model.ExchangeDtoMapper
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        httpLoggingInterceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.BODY


        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

    }

    @ExperimentalSerializationApi
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
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
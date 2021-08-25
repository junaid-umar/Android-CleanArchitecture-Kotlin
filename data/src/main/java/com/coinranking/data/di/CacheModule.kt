package com.coinranking.data.di

import android.content.Context
import androidx.room.Room
import com.coinranking.data.cache.ExchangeCacheData
import com.coinranking.data.cache.ExchangeCacheDataImpl
import com.coinranking.data.cache.dao.ExchangeDao
import com.coinranking.data.cache.db.AppDatabase
import com.coinranking.data.cache.model.ExchangeEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideExchangeDao(appDatabase: AppDatabase): ExchangeDao {
        return appDatabase.getExchangeDao()
    }

    @Provides
    fun provideExchangeEntityMapper(): ExchangeEntityMapper {
        return ExchangeEntityMapper()
    }

    @Provides
    fun provideExchangeCacheData(
        exchangeDao: ExchangeDao,
        exchangeEntityMapper: ExchangeEntityMapper,
    ): ExchangeCacheData {
        return ExchangeCacheDataImpl(exchangeDao, exchangeEntityMapper)
    }
}
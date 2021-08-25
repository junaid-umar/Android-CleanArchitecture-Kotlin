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
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CacheModule::class]
)
object CacheModuleTest {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).allowMainThreadQueries().build()


    @Provides
    fun provideExchangeDao(db: AppDatabase): ExchangeDao {
        return db.getExchangeDao()
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
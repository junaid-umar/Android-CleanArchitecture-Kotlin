package com.coinranking.data.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coinranking.data.cache.dao.ExchangeDao
import com.coinranking.data.cache.model.ExchangeEntity

@Database(entities = [ExchangeEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getExchangeDao(): ExchangeDao

    companion object {
        val DATABASE_NAME: String = "crypto_db"
    }
}
package com.coinranking.data.cache.dao

import androidx.room.*
import com.coinranking.data.cache.model.ExchangeEntity

@Dao
interface ExchangeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchanges(exchanges: List<ExchangeEntity>)

    @Update
    suspend fun updateExchanges(exchanges: List<ExchangeEntity>)

    @Transaction
    suspend fun upsert(exchanges: List<ExchangeEntity>) {
        insertExchanges(exchanges)
        updateExchanges(exchanges)
    }

    @Query("SELECT * FROM exchange")
    suspend fun getExchanges(): List<ExchangeEntity>

}

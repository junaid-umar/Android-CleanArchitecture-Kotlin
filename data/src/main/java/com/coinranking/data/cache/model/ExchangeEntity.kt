package com.coinranking.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coinranking.domain.model.ExchangeId

@Entity(tableName = "exchange")
data class ExchangeEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "uuid")
    val exchangeId: ExchangeId,

    @ColumnInfo(name = "rank")
    val rank: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "icon_url")
    val iconUrl: String,

    @ColumnInfo(name = "verified")
    val verified: Boolean,

    @ColumnInfo(name = "recommended")
    val recommended: Boolean,

    @ColumnInfo(name = "number_of_markets")
    val numberOfMarkets: Int,

    @ColumnInfo(name = "number_of_coins")
    val numberOfCoins: Int,

    @ColumnInfo(name = "market_share")
    val marketShare: String,

    @ColumnInfo(name = "coin_ranking_url")
    val coinRankingUrl: String,

    @ColumnInfo(name = "volume")
    val volume: String,

    )
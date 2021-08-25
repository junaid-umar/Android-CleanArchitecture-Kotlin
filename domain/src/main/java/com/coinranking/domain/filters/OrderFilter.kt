package com.coinranking.domain.filters

sealed class OrderFilter(
    val uiValue: String,
    val abbreviations: String,
) {
    object Price : OrderFilter(
        uiValue = "Price",
        abbreviations = "price"
    )

    object MarketCap : OrderFilter(
        uiValue = "MarketCap",
        abbreviations = "marketCap"
    )

    object Hours24Volume : OrderFilter(
        uiValue = "24h Volume",
        abbreviations = "24hVolume"
    )

    object Change : OrderFilter(
        uiValue = "Change",
        abbreviations = "change"
    )

    object ListedAt : OrderFilter(
        uiValue = "ListedAt",
        abbreviations = "listedAt"
    )
}

fun getOrderFilter(uiValue: String): OrderFilter {
    return when (uiValue) {
        OrderFilter.Price.uiValue -> OrderFilter.Price
        OrderFilter.MarketCap.uiValue -> OrderFilter.MarketCap
        OrderFilter.Hours24Volume.uiValue -> OrderFilter.Hours24Volume
        OrderFilter.Change.uiValue -> OrderFilter.Change
        OrderFilter.ListedAt.uiValue -> OrderFilter.ListedAt
        else -> OrderFilter.Price
    }
}
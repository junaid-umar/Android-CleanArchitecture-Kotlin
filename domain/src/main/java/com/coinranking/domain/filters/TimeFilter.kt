package com.coinranking.domain.filters

sealed class TimeFilter(
    val uiValue: String,
    val abbreviation: String,
) {
    object Hours24 : TimeFilter(
        uiValue = "24 hours",
        abbreviation = "24h"
    )

    object Days7 : TimeFilter(
        uiValue = "7 days",
        abbreviation = "7d"
    )

    object Days30 : TimeFilter(
        uiValue = "30 days",
        abbreviation = "30d"
    )

    object Year1 : TimeFilter(
        uiValue = "1 Year",
        abbreviation = "1y"
    )

    object Year5 : TimeFilter(
        uiValue = "5 years",
        abbreviation = "5y"
    )

}

fun getTimeFilter(uiValue: String): TimeFilter {
    return when (uiValue) {
        TimeFilter.Hours24.uiValue -> TimeFilter.Hours24
        TimeFilter.Days7.uiValue -> TimeFilter.Days7
        TimeFilter.Days30.uiValue -> TimeFilter.Days30
        TimeFilter.Year1.uiValue -> TimeFilter.Year1
        TimeFilter.Year5.uiValue -> TimeFilter.Year5
        else -> TimeFilter.Hours24
    }
}
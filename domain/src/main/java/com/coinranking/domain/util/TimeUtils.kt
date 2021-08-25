package com.coinranking.domain.util

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object TimeUtils {

    fun epochToDate(epoch: Long): ZonedDateTime {
        return Instant.ofEpochMilli(
            epoch
        ).atZone(ZoneId.systemDefault())
    }

    fun dateToEpoch(zonedDateTime: ZonedDateTime): Long {
        return zonedDateTime.toEpochSecond()
    }

    fun dateToString(zonedDateTime: ZonedDateTime): String {
        return DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a").format(zonedDateTime)
    }

    fun dateToStringFormat(zonedDateTime: ZonedDateTime, format: String): String {
        return DateTimeFormatter.ofPattern(format).format(zonedDateTime)
    }

}
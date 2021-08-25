package com.coinranking.domain.util

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.time.ZonedDateTime


class TimeUtilsTest {

    private lateinit var zonedDateTime: ZonedDateTime
    private var epoch: Long = 1629766
    private var dateString: String = "Jan 19 1970, 9:42 pm"
    private var stringFormat: String = "MMM d yyyy, h:mm a"

    @Before
    fun setUp() {
        zonedDateTime = ZonedDateTime.parse("1970-01-19T21:42:46.695+01:00[Europe/Berlin]")
    }

    @Test
    fun dateToEpoch() {
        val result = TimeUtils.dateToEpoch(
            zonedDateTime
        )
        assertEquals(
            result, epoch
        )
    }

    @Test
    fun dateToString() {
        val result = TimeUtils.dateToString(
            zonedDateTime
        )
        assertEquals(
            result, dateString
        )
    }

    @Test
    fun dateToStringFormat() {
        val result = TimeUtils.dateToStringFormat(
            zonedDateTime,
            stringFormat
        )
        assertEquals(
            result, dateString
        )
    }

}
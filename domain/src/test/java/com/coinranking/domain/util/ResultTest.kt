package com.coinranking.domain.util

import org.junit.Assert
import org.junit.Test


class ResultTest {

    @Test
    fun givenResultSuccess_returnTransformedResult() {
        val input = Result.Success("data")
        val output = input.transform { "data" + "data" }
        Assert.assertEquals((output as Result.Success).data, "datadata")
    }

    @Test
    fun givenResultError_returnTransformedResult() {
        val input = Result.Error("message")
        val output = input.transform { "message" }
        Assert.assertEquals((output as Result.Error).error, "message")
    }

    @Test
    fun givenResultLoading_returnTransformedResult() {
        val input = Result.Loading("data")
        val output = input.transform { "data" }
        Assert.assertEquals((output as Result.Loading).data, "data")
    }
}
package com.coinranking.data.cache

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.coinranking.data.FakeDataUtil
import com.coinranking.data.cache.db.AppDatabase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class ExchangeCacheDataImplTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var appDatabase: AppDatabase

    @Inject
    lateinit var exchangeCacheData: ExchangeCacheDataImpl

    @Before
    fun setUp() {
        hiltRule.inject()

    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Test
    fun insertBlog_searchBlog(): Unit = runBlocking {

        launch {
            val input = FakeDataUtil.FakeExchange.exchanges

            exchangeCacheData.insertOrReplace(input)
            val result = exchangeCacheData.getExchanges()

            assertEquals(result, input)
        }

    }


}
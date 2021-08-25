package com.coinranking.sample.presentation.coin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinranking.domain.filters.OrderFilter
import com.coinranking.domain.filters.TimeFilter
import com.coinranking.domain.interactor.GetCoinsParams
import com.coinranking.domain.interactor.GetCoinsUseCase
import com.coinranking.domain.model.Coin
import com.coinranking.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel
@Inject
constructor(
    private val coinsUseCase: GetCoinsUseCase,
) : ViewModel() {
    private var _coins = MutableLiveData<Result<List<Coin>>>()

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            coinsUseCase.invoke(
                GetCoinsParams(
                    1,
                    OrderFilter.MarketCap,
                    TimeFilter.Days7
                )
            ).collect {
                _coins.postValue(it)
            }
        }
    }

    val coinsList: LiveData<Result<List<Coin>>>
        get() = _coins
}
package com.coinranking.sample.presentation.exchange

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coinranking.domain.interactor.GetExchangesUseCase
import com.coinranking.domain.model.Exchange
import com.coinranking.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class ExchangeViewModel
@Inject
constructor(
    private val exchangesUseCase: GetExchangesUseCase,
) : ViewModel() {
    private var _exchanges = MutableLiveData<Result<List<Exchange>>>()

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            exchangesUseCase.invoke(
                Unit
            ).collect {
                _exchanges.postValue(it)
            }
        }
    }

    val exchanges: LiveData<Result<List<Exchange>>>
        get() = _exchanges
}
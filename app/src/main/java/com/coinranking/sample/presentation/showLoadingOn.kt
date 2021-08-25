package com.coinranking.sample.presentation

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coinranking.domain.model.Coin
import com.coinranking.domain.model.Exchange
import com.coinranking.domain.util.Result
import com.coinranking.sample.presentation.coin.CoinAdapter
import com.coinranking.sample.presentation.exchange.ExchangeAdapter
import com.coinranking.sample.presentation.util.Utils
import com.google.android.material.snackbar.Snackbar
import java.math.BigDecimal

@BindingAdapter("bind:showLoadingOn")
fun showLoadingOn(view: View, item: Result<Any>?) {
    view.visibility = if (item is Result.Loading) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("bind:showErrorOn")
fun showErrorOn(view: View, item: Result<Any>?) {
    if (item is Result.Error) {
        Snackbar.make(
            view,
            item.error,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}

@BindingAdapter("bind:showChange")
fun showChange(view: TextView, amount: BigDecimal) {
    view.text = Utils.scaleBigDecimal(amount).toString()
}


@BindingAdapter("bind:showAmount")
fun showAmount(view: TextView, amount: BigDecimal) {
    view.text = "$" + Utils.scaleBigDecimal(amount)
}

@BindingAdapter(value = ["bind:imageUrl", "placeholder"], requireAll = false)
fun showImage(
    imageView: ImageView,
    url: String?,
    placeholder: Drawable?,
) {
    if (url == null) {
        imageView.setImageDrawable(placeholder)
    } else {
        Utils.loadImageWithGlide(imageView, url)
    }
}


@BindingAdapter("bind:bound_items_exchange")
fun setRecyclerViewExchangeItems(
    recyclerView: RecyclerView,
    items: Result<List<Exchange>>?,
) = setupExchangeAdapter(recyclerView, items?.let { getExchangeData(items) } ?: emptyList())

fun getExchangeData(items: Result<List<Exchange>>) = when (items) {
    is Result.Success -> items.data
    is Error -> emptyList()
    is Result.Loading -> items.data
    else -> emptyList()
}

fun setupExchangeAdapter(
    recyclerView: RecyclerView,
    items: List<Exchange>,
) {
    var adapter = (recyclerView.adapter as? ExchangeAdapter)

    if (adapter == null) {
        adapter = ExchangeAdapter()
        recyclerView.adapter = adapter
    }

    if (!items.isEmpty()) {
        adapter.submitList(items.toMutableList())
    }
}


@BindingAdapter("bind:bound_items")
fun setRecyclerViewResourceItems(
    recyclerView: RecyclerView,
    items: Result<List<Coin>>?,
) = setupCoinAdapter(recyclerView, items?.let { getData(items) } ?: emptyList())

fun getData(items: Result<List<Coin>>) = when (items) {
    is Result.Success -> items.data
    is Error -> emptyList()
    is Result.Loading -> items.data
    else -> emptyList()
}

fun setupCoinAdapter(
    recyclerView: RecyclerView,
    items: List<Coin>,
) {
    var adapter = (recyclerView.adapter as? CoinAdapter)

    if (adapter == null) {
        adapter = CoinAdapter()
        recyclerView.adapter = adapter
    }

    if (!items.isEmpty()) {
        adapter.submitList(items.toMutableList())
    }
}
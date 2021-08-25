package com.coinranking.sample.presentation.exchange

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coinranking.domain.model.Exchange
import com.coinranking.sample.R
import com.coinranking.sample.databinding.ListExchangeBinding


class ExchangeAdapter :
    ListAdapter<Exchange, ExchangeAdapter.ExchangeHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Exchange>() {
        override fun areItemsTheSame(oldItem: Exchange, newItem: Exchange): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Exchange, newItem: Exchange): Boolean {
            return oldItem.exchangeId == newItem.exchangeId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeHolder {
        return ExchangeHolder(
            androidx.databinding.DataBindingUtil.inflate(
                android.view.LayoutInflater.from(parent.context),
                R.layout.list_exchange,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExchangeAdapter.ExchangeHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = currentList.size


    inner class ExchangeHolder(private val exchangeBinding: ListExchangeBinding) :
        RecyclerView.ViewHolder(exchangeBinding.root) {
        fun bind(exchange: Exchange) {
            exchangeBinding.exchange = exchange
            exchangeBinding.executePendingBindings()
        }
    }


}
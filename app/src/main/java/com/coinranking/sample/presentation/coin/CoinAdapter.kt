package com.coinranking.sample.presentation.coin

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coinranking.domain.model.Coin
import com.coinranking.sample.R
import com.coinranking.sample.databinding.ListCoinBinding


class CoinAdapter :
    ListAdapter<Coin, CoinAdapter.CoinHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Coin>() {
        override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
            return oldItem.uuid == newItem.uuid
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinHolder {
        return CoinHolder(
            androidx.databinding.DataBindingUtil.inflate(
                android.view.LayoutInflater.from(parent.context),
                R.layout.list_coin,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinAdapter.CoinHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = currentList.size


    inner class CoinHolder(private val coinBinding: ListCoinBinding) :
        RecyclerView.ViewHolder(coinBinding.root) {
        fun bind(coin: Coin) {
            coinBinding.coin = coin
            coinBinding.executePendingBindings()
        }
    }


}
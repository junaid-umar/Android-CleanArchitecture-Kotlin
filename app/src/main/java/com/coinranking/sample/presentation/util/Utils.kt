package com.coinranking.sample.presentation.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.coinranking.sample.R
import java.math.BigDecimal

object Utils {
    fun loadImageWithGlide(iv: ImageView, url: String) {
        iv.apply {

            Glide.with(context)
                .load(url)
                .error(R.drawable.ic_bytecoin)
                .centerCrop()
                .into(this)
        }
    }

    fun scaleBigDecimal(amount: BigDecimal): Double {
        return amount.setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
    }

}
package com.deneb.criptocompose.features.coin

import com.deneb.criptocompose.features.coin.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)

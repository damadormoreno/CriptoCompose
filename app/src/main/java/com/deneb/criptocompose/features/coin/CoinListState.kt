package com.deneb.criptocompose.features.coin

import com.deneb.criptocompose.features.coin.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

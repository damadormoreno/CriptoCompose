package com.deneb.criptocompose.features.coin.model


import com.google.gson.annotations.SerializedName

data class CoinDto(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("symbol")
    val symbol: String = "",
    @SerializedName("rank")
    val rank: Int = 0,
    @SerializedName("is_new")
    val isNew: Boolean = false,
    @SerializedName("is_active")
    val isActive: Boolean = false,
    @SerializedName("type")
    val type: String = ""
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}
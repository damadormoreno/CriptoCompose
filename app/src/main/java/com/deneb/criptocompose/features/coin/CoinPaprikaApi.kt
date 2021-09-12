package com.deneb.criptocompose.features.coin

import com.deneb.criptocompose.features.coin.model.CoinDetailDto
import com.deneb.criptocompose.features.coin.model.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}
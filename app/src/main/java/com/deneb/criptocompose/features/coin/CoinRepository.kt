package com.deneb.criptocompose.features.coin

import com.deneb.criptocompose.core.common.Resource
import com.deneb.criptocompose.features.coin.model.Coin
import com.deneb.criptocompose.features.coin.model.CoinDetail
import com.deneb.criptocompose.features.coin.model.toCoin
import com.deneb.criptocompose.features.coin.model.toCoinDetail
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface CoinRepository {

    suspend fun getCoins(): Resource<List<Coin>>

    suspend fun getCoinById(coinId: String): Resource<CoinDetail>

    class CoinRepositoryImpl @Inject constructor(
        private val api: CoinPaprikaApi
    ) : CoinRepository {
        override suspend fun getCoins(): Resource<List<Coin>> {
            return try {
                Resource.Success(api.getCoins().map { it.toCoin() })
            } catch (e: HttpException) {
                Resource.Error(e.localizedMessage?: "Server Error")
            } catch (e: IOException) {
                Resource.Error(e.localizedMessage?: "No network")
            }
        }

        override suspend fun getCoinById(coinId: String): Resource<CoinDetail> {
            return try {
                Resource.Success(api.getCoinById(coinId).toCoinDetail())
            } catch (e: HttpException) {
                Resource.Error(e.localizedMessage?: "Server Error")
            } catch (e: IOException) {
                Resource.Error(e.localizedMessage?: "No network")
            }
        }
    }
}


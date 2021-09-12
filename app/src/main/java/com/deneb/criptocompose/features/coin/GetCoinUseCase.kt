package com.deneb.criptocompose.features.coin

import com.deneb.criptocompose.core.common.Resource
import com.deneb.criptocompose.features.coin.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())
        emit(repository.getCoinById(coinId))
    }
}
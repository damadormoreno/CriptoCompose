package com.deneb.criptocompose.features.coin

import com.deneb.criptocompose.core.common.Resource
import com.deneb.criptocompose.features.coin.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        emit(repository.getCoins())
    }
}
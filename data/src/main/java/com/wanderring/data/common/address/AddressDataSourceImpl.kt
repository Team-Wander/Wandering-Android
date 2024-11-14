package com.wanderring.data.common.address

import com.wanderring.data.BuildConfig
import com.wanderring.domain.model.model.address.AddressResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface AddressDataSource {
    suspend fun getAddress(
        currentPage: Int,
        countPerPage: Int,
        keyword: String,
    ): Flow<AddressResponse>
}

class AddressDataSourceImpl @Inject constructor(
    private val addressApi: AddressApi,
) : AddressDataSource {

    override suspend fun getAddress(
        currentPage: Int,
        countPerPage: Int,
        keyword: String,
    ): Flow<AddressResponse> = flow {
        emit(
            withContext(Dispatchers.IO) {
                addressApi.getAddress(
                    confmKey = BuildConfig.ADDRESS_API_KEY,
                    currentPage = currentPage,
                    countPerPage = countPerPage,
                    keyword = keyword,
                    resultType = "json"
                )
            }
        )
    }.flowOn(Dispatchers.IO)
}
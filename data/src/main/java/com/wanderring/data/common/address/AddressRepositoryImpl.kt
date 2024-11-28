package com.wanderring.data.common.address

import com.wanderring.domain.model.address.AddressModel
import com.wanderring.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AddressRepositoryImpl @Inject constructor(
    private val addressDataSource: AddressDataSource
) : AddressRepository {
    override suspend fun getAddress(
        currentPage: Int,
        countPerPage: Int,
        keyword: String
    ): Flow<AddressModel> =
        addressDataSource.getAddress(
            countPerPage = countPerPage,
            currentPage = currentPage,
            keyword = keyword
        ).map {
            AddressModel(
                juso = it.results.juso?.map { juso -> juso.toJuso() } ?: emptyList()
            )
        }
}
package com.wanderring.data.common.address

import com.wanderring.domain.model.model.address.AddressResponse
import com.wanderring.domain.model.repository.address.AddressRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddressRepositoryImpl @Inject constructor(
    private val addressDataSource: AddressDataSource
) : AddressRepository {
    override suspend fun getAddress(
        currentPage: Int,
        countPerPage: Int,
        keyword: String
    ): Flow<AddressResponse> =
        addressDataSource.getAddress(
            countPerPage = countPerPage,
            currentPage = currentPage,
            keyword = keyword
        )
}
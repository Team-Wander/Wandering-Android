package com.wanderring.domain.model.repository.address

import com.wanderring.domain.model.model.address.AddressResponse
import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    suspend fun getAddress(
        currentPage: Int,
        countPerPage: Int,
        keyword: String,
    ): Flow<AddressResponse>
}
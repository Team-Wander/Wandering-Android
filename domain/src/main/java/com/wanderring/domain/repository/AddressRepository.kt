package com.wanderring.domain.repository

import com.wanderring.domain.model.address.JusoModel
import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    suspend fun getAddress(
        currentPage: Int,
        countPerPage: Int,
        keyword: String,
    ): Flow<List<JusoModel>>
}
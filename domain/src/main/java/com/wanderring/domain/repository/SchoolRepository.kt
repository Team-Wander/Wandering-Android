package com.wanderring.domain.repository

import kotlinx.coroutines.flow.Flow

interface SchoolRepository {
    suspend fun getSchool(
        searchSchulNm: String,
        gubun: String,
    ): Flow<List<String>>
}
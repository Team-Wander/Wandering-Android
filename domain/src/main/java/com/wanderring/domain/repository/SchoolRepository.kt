package com.wanderring.domain.repository

import kotlinx.coroutines.flow.Flow

interface SchoolRepository {
    suspend fun getSchoolList(
        searchSchulNm: String,
        gubun: String,
    ): Flow<List<String>>
}
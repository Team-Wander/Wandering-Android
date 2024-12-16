package com.wanderring.data.common.school

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface SchoolDataSource {
    suspend fun getSchoolList(
        searchSchulNm: String = "",
        gubun: String = "high_list",
    ): Flow<SchoolResponse>
}

class SchoolDataSourceImpl @Inject constructor(
    private val schoolApi: SchoolApi,
) : SchoolDataSource {

    override suspend fun getSchoolList(
        searchSchulNm: String,
        gubun: String,
    ): Flow<SchoolResponse> = flow {
        emit(
            schoolApi.getSchools(
                apiKey = "BuildConfig.SCHOOL_API_KEY",
                searchSchulNm = searchSchulNm,
                svcType = "api",
                svcCode = "SCHOOL",
                contentType = "json",
                gubun = gubun
            )
        )
    }.flowOn(Dispatchers.IO)
}

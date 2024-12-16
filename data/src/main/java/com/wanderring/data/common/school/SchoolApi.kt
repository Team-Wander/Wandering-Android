package com.wanderring.data.common.school

import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolApi {
    @GET("cnet/openapi/getOpenApi")
    suspend fun getSchools(
        @Query("apiKey") apiKey: String,
        @Query("svcType") svcType: String,
        @Query("svcCode") svcCode: String,
        @Query("contentType") contentType: String,
        @Query("gubun") gubun: String,
        @Query("searchSchulNm") searchSchulNm: String,
    ): SchoolResponse
}

data class SchoolResponse(
    val dataSearch: DataSearch?,
    val result: Result?
)

data class DataSearch(
    val content: List<School>?,
    val totalCount: String?
)

data class School(
    val schoolName: String?,
    val schoolGubun: String?,
    val schoolType: String?,
    val estType: String?,
    val region: String?,
    val adres: String?,
    val collegeinfourl: String?,
    val link: String?
)

data class Result(
    val code: String?,
    val message: String?
)
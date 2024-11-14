package com.wanderring.data.common.address

import retrofit2.http.GET
import retrofit2.http.Query


interface AddressApi {
    @GET("addrlink/addrLinkApi.do")
    suspend fun getAddress(
        @Query("confmKey") confmKey: String,
        @Query("currentPage") currentPage: Int,
        @Query("countPerPage") countPerPage: Int,
        @Query("keyword") keyword: String,
        @Query("resultType") resultType: String,
    ): AddressResponse
}

data class AddressResponse(
    val results: Results
)

data class Results(
    val common: Common,
    val juso: List<Juso>
)

data class Common(
    val totalCount: String,
    val errorMessage: String,
    val errorCode: String
)

data class Juso(
    val roadAddr: String,
    val jibunAddr: String,
    val zipNo: String
)

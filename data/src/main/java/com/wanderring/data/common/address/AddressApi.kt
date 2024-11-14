package com.wanderring.data.common.address

import com.wanderring.domain.model.model.address.AddressResponse
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

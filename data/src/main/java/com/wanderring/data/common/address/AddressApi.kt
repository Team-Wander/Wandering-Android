package com.wanderring.data.common.address

import com.wanderring.domain.model.address.JusoModel
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
    val juso: List<Juso>?
)

data class Common(
    val totalCount: String,
    val currentPage: String,
    val countPerPage: String,
    val errorCode: String,
    val errorMessage: String
)

data class Juso(
    val roadAddr: String,
    val roadAddrPart1: String,
    val roadAddrPart2: String?,
    val jibunAddr: String,
    val engAddr: String,
    val zipNo: String,
    val admCd: String,
    val rnMgtSn: String,
    val bdMgtSn: String,
    val detBdNmList: String?,
    val bdNm: String?,
    val bdKdcd: String?,
    val siNm: String,
    val sggNm: String,
    val emdNm: String,
    val liNm: String?,
    val rn: String,
    val udrtYn: String?,
    val buldMnnm: String?,
    val buldSlno: String?,
    val mtYn: String?,
    val lnbrMnnm: String?,
    val lnbrSlno: String?,
    val emdNo: String?
)

fun Juso.toJuso() = JusoModel(roadAddr = roadAddr, jibunAddr = jibunAddr)

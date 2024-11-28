package com.wanderring.data.common.auth

import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST

interface AuthApi {
    @POST("/auth")
    suspend fun login(@Body loginBody: LoginBody): TokenResponse

    @DELETE("/auth")
    suspend fun logout()

    @PATCH("/auth")
    suspend fun tokenRefresh(): TokenResponse

    @POST("/auth/info")
    suspend fun submitExtraData(@Body extraDataBody: ExtraDataBody): TokenResponse
}

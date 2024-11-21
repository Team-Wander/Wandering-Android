package com.wanderring.data.common.tokenData

interface EncryptedSharedPreferencesDataSource {
    fun getAccessToken(): String
    fun setAccessToken(accessToken: String)
    fun deleteAccessToken()

    fun getAccessTime(): String
    fun setAccessTime(accessTime: String)
    fun deleteAccessTime()

    fun getRefreshToken(): String
    fun setRefreshToken(refreshToken: String)
    fun deleteRefreshToken()

    fun getRefreshTime(): String
    fun setRefreshTime(refreshTime: String)
    fun deleteRefreshTime()

    fun getIsOnBoardingFinished(): Boolean?
    fun setIsOnBoardingFinished()
    fun deleteIsOnBoardingFinished()
}
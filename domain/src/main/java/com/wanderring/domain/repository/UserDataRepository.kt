package com.wanderring.domain.repository

interface UserDataRepository {
    fun getAccessToken(): String
    fun getAccessTime(): String

    fun getRefreshToken(): String
    fun getRefreshTime(): String

    fun setAccess(accessToken: String, accessTime: String)
    fun setRefresh(refreshToken: String, refreshTime: String)

    fun deleteAccess()
    fun deleteRefresh()

    fun getIsOnBoardingFinished(): Boolean

    fun setIsOnBoardingFinished()

    fun logOut()
}

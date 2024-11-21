package com.wanderring.data.common.tokenData

import com.wanderring.domain.model.repository.userData.UserDataRepository
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val encryptedSharedPreferencesDataSource: EncryptedSharedPreferencesDataSource
) : UserDataRepository {
    override fun getAccessToken(): String = encryptedSharedPreferencesDataSource.getAccessToken()

    override fun getAccessTime(): String = encryptedSharedPreferencesDataSource.getAccessTime()

    override fun getRefreshToken(): String = encryptedSharedPreferencesDataSource.getRefreshToken()

    override fun getRefreshTime(): String = encryptedSharedPreferencesDataSource.getRefreshTime()

    override fun setAccess(accessToken: String, accessTime: String) {
        with(encryptedSharedPreferencesDataSource) {
            setAccessToken(accessToken)
            setAccessTime(accessTime)
        }
    }

    override fun setRefresh(refreshToken: String, refreshTime: String) {
        with(encryptedSharedPreferencesDataSource) {
            setRefreshTime(refreshTime)
            setRefreshToken(refreshToken)
        }
    }

    override fun deleteAccess() {
        with(encryptedSharedPreferencesDataSource) {
            deleteAccessToken()
            deleteAccessTime()
        }
    }

    override fun deleteRefresh() {
        with(encryptedSharedPreferencesDataSource) {
            deleteRefreshToken()
            deleteRefreshTime()
        }
    }

    override fun getIsOnBoardingFinished(): Boolean =
        encryptedSharedPreferencesDataSource.getIsOnBoardingFinished() ?: true

    override fun setIsOnBoardingFinished() =
        encryptedSharedPreferencesDataSource.setIsOnBoardingFinished()

    override fun logOut() {
        with(encryptedSharedPreferencesDataSource) {
            deleteAccessToken()
            deleteAccessTime()
            deleteRefreshToken()
            deleteRefreshTime()
            deleteIsOnBoardingFinished()
        }
    }

}
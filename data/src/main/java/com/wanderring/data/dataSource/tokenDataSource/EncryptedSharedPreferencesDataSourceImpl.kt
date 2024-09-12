package com.wanderring.data.dataSource.tokenDataSource

import android.content.SharedPreferences
import com.squareup.moshi.JsonAdapter
import com.wanderring.data.dataSource.EncryptedSharedPreferencesDataSource
import javax.inject.Inject

class EncryptedSharedPreferencesDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val tokenAdapter: JsonAdapter<String>
) : EncryptedSharedPreferencesDataSource {
    companion object {
        private const val ACCESS_TOKEN = "access_token"
        private const val ACCESS_TIME = "access_time"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val REFRESH_TIME = "access_time"
        private const val ONBOARDING_FINISH = "onboarding_finished"
    }

    private val editor = sharedPreferences.edit()

    override fun getAccessToken(): String? {
        val json = sharedPreferences.getString(ACCESS_TOKEN, null)
        return tokenAdapter?.fromJson(json)
    }

    override fun setAccessToken(accessToken: String) {
        val json = tokenAdapter.toJson(accessToken)
        editor.putString(ACCESS_TOKEN, json).apply()
    }

    override fun deleteAccessToken() {
        sharedPreferences.edit().remove(ACCESS_TOKEN).apply()
    }

    override fun getAccessTime(): String? {
        val json = sharedPreferences.getString(ACCESS_TIME, null)
        return tokenAdapter?.fromJson(json)
    }

    override fun setAccessTime(accessTime: String) {
        val json = tokenAdapter.toJson(accessTime)
        editor.putString(ACCESS_TIME, json).apply()
    }

    override fun deleteAccessTime() {
        sharedPreferences.edit().remove(ACCESS_TIME).apply()
    }

    override fun getRefreshToken(): String? {
        val json = sharedPreferences.getString(REFRESH_TOKEN, null)
        return tokenAdapter?.fromJson(json)
    }

    override fun setRefreshToken(refreshToken: String) {
        val json = tokenAdapter.toJson(refreshToken)
        editor.putString(REFRESH_TOKEN, json).apply()
    }

    override fun deleteRefreshToken() {
        sharedPreferences.edit().remove(REFRESH_TOKEN).apply()
    }


    override fun getRefreshTime(): String? {
        val json = sharedPreferences.getString(REFRESH_TIME, null)
        return tokenAdapter?.fromJson(json)
    }

    override fun setRefreshTime(refreshTime: String) {
        val json = tokenAdapter.toJson(refreshTime)
        editor.putString(REFRESH_TIME, json).apply()
    }

    override fun deleteRefreshTime() {
        sharedPreferences.edit().remove(REFRESH_TIME).apply()
    }

    override fun getIsOnBoardingFinished(): Boolean? {
        val json = sharedPreferences.getString(ONBOARDING_FINISH, null)
        return tokenAdapter?.fromJson(json).toBoolean()
    }

    override fun setIsOnBoardingFinished() {
        val json = tokenAdapter.toJson(false.toString())
        editor.putString(ONBOARDING_FINISH, json).apply()
    }

    override fun deleteIsOnBoardingFinished() {
        sharedPreferences.edit().remove(ONBOARDING_FINISH).apply()
    }
}
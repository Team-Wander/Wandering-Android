package com.wanderring.data.common.tokenData

import android.content.SharedPreferences
import com.squareup.moshi.JsonAdapter
import javax.inject.Inject

class EncryptedSharedPreferencesDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val tokenAdapter: JsonAdapter<String>
) : EncryptedSharedPreferencesDataSource {

    companion object {
        private const val ACCESS_TOKEN = "access_token"
        private const val ACCESS_TIME = "access_time"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val REFRESH_TIME = "refresh_time"
        private const val ONBOARDING_FINISH = "onboarding_finished"
    }

    private val editor = sharedPreferences.edit()

    private inline fun <reified T> getValue(key: String, adapter: JsonAdapter<T>, defaultValue: T): T {
        val json = sharedPreferences.getString(key, null)
        return json?.let { adapter.fromJson(it) } ?: defaultValue
    }

    private fun <T> setValue(key: String, value: T, adapter: JsonAdapter<T>) {
        val json = adapter.toJson(value)
        editor.putString(key, json).apply()
    }

    private fun deleteValue(key: String) {
        editor.remove(key).apply()
    }

    override fun getAccessToken(): String = getValue(ACCESS_TOKEN, tokenAdapter, defaultValue = "")
    override fun setAccessToken(accessToken: String) = setValue(ACCESS_TOKEN, accessToken, tokenAdapter)
    override fun deleteAccessToken() = deleteValue(ACCESS_TOKEN)

    override fun getAccessTime(): String = getValue(ACCESS_TIME, tokenAdapter, defaultValue = "")
    override fun setAccessTime(accessTime: String) = setValue(ACCESS_TIME, accessTime, tokenAdapter)
    override fun deleteAccessTime() = deleteValue(ACCESS_TIME)

    override fun getRefreshToken(): String = getValue(REFRESH_TOKEN, tokenAdapter, defaultValue = "")
    override fun setRefreshToken(refreshToken: String) = setValue(REFRESH_TOKEN, refreshToken, tokenAdapter)
    override fun deleteRefreshToken() = deleteValue(REFRESH_TOKEN)

    override fun getRefreshTime(): String = getValue(REFRESH_TIME, tokenAdapter, defaultValue = "")
    override fun setRefreshTime(refreshTime: String) = setValue(REFRESH_TIME, refreshTime, tokenAdapter)
    override fun deleteRefreshTime() = deleteValue(REFRESH_TIME)

    override fun getIsOnBoardingFinished(): Boolean = sharedPreferences.getBoolean(ONBOARDING_FINISH, false)
    override fun setIsOnBoardingFinished() = editor.putBoolean(ONBOARDING_FINISH, true).apply()
    override fun deleteIsOnBoardingFinished() = deleteValue(ONBOARDING_FINISH)
}
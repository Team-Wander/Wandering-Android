package com.wanderring.data.utill

import com.wanderring.domain.model.repository.userData.UserDataRepository
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val dataSource: UserDataRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        // 액세스 토큰을 헤더에 추가
        val accessToken = dataSource.getAccessToken()
        val request = chain.request().newBuilder()
            .apply {
                if (!accessToken.isNullOrEmpty()) {
                    addHeader("Authorization", "Bearer $accessToken")
                }
            }
            .build()

        // 요청을 실행
        var response: Response = chain.proceed(request)

        // 액세스 토큰 만료 시
        if (response.code == 401) {
            val refreshToken = dataSource.getRefreshToken()
            if (!refreshToken.isNullOrEmpty()) {
                // 리프레시 토큰으로 새로운 액세스 토큰 요청 (TODO)
                // 새로운 액세스 토큰 발급 후 리트라이
                val newAccessToken = "NEW_ACCESS_TOKEN" // 새로운 토큰을 받았다고 가정
                val newRequest = request.newBuilder()
                    .addHeader("Authorization", "Bearer $newAccessToken")
                    .build()

                // 이전 응답을 닫고 새로운 요청을 보냄
                response.close()  // 반드시 이전 응답을 닫고
                response = chain.proceed(newRequest)  // 새로운 요청으로 응답 받기
            }
        }

        return response
    }
}
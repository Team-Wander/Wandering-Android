package com.wanderring.data.utill

import com.wanderring.domain.model.repository.UserDataRepository
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val dataSource: UserDataRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()

        // 액세스 토큰을 헤더에 추가
        val accessToken = dataSource.getAccessToken()

        if (!accessToken.isNullOrEmpty()) {
            request = builder
                .addHeader("Authorization", "Bearer $accessToken")
                .build()
        }

        // 요청을 실행
        val response = chain.proceed(request)

        // 액세스 토큰 만료 시
        if (response.code == 401) {
            val refreshToken = dataSource.getRefreshToken()
            if (!refreshToken.isNullOrEmpty()) {
                // TODO: 리프레시 토큰으로 새로운 액세스 토큰 요청

                // TODO: 발급받은 토큰으로 리트라이
            }
        }

        // TODO: 리프레시 토큰도 만료되면 토큰 모두 삭제

        return chain.proceed(builder.build())
    }
}
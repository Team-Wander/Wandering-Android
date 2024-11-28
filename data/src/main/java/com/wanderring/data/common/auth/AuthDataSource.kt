package com.wanderring.data.common.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface AuthDataSource {
    fun login(loginBody: LoginBody): Flow<TokenResponse>
    fun logout(): Flow<Unit>
    fun tokenRefresh(): Flow<TokenResponse>
    fun submitExtraData(extraDataBody: ExtraDataBody): Flow<Unit>
}

class AuthDataSourceImpl @Inject constructor(
    private val authApi: AuthApi,
) : AuthDataSource {
    override fun login(loginBody: LoginBody): Flow<TokenResponse> = flow {
        emit(authApi.login(loginBody = loginBody))
    }.flowOn(Dispatchers.IO)

    override fun logout(): Flow<Unit> = flow {
        emit(authApi.logout())
    }.flowOn(Dispatchers.IO)


    override fun tokenRefresh(): Flow<TokenResponse> = flow {
        emit(authApi.tokenRefresh())
    }.flowOn(Dispatchers.IO)

    override fun submitExtraData(extraDataBody: ExtraDataBody): Flow<Unit> = flow {
        emit(authApi.submitExtraData(extraDataBody = extraDataBody))
    }.flowOn(Dispatchers.IO)

}
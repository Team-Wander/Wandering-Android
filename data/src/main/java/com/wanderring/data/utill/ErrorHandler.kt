package com.wanderring.data.utill

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorHandler<T> {
    companion object {
        private val TAG = ErrorHandler::class.java.simpleName
    }

    private lateinit var httpRequest: (suspend () -> T)

    fun httpRequest(httpRequest: suspend () -> T) = apply {
        this.httpRequest = httpRequest
    }

    suspend fun sendRequest(): T =
        try {
            Log.d(TAG, "Request started")
            withContext(Dispatchers.IO) {
                httpRequest.invoke()
            }.also {
                Log.d(TAG, "Request succeeded")
            }
        } catch (e: Exception) {
            handleException(e)
        }

    private fun handleException(exception: Exception): Nothing {
        val message = exception.message.orEmpty()
        Log.e(TAG, "Request failed: $message", exception)

        throw when (exception) {
            is HttpException -> when (exception.code()) {
                400 -> BadRequestException(message)
                401 -> UnauthorizedException(message)
                403 -> ForBiddenException(message)
                404 -> NotFoundException(message)
                409 -> ConflictException(message)
                in 500..503 -> ServerException(message)
                else -> OtherHttpException(message = message, code = exception.code())
            }

            is SocketTimeoutException -> TimeOutException(message)
            is UnknownHostException -> NoInternetException()
            is NeedLoginException -> NeedLoginException()
            else -> UnKnownException(message)
        }
    }
}

sealed class BaseHttpException(override val message: String?) : RuntimeException(message)

data class BadRequestException(
    override val message: String?
) : BaseHttpException(message)

data class UnauthorizedException(
    override val message: String?
) : BaseHttpException(message)

data class ForBiddenException(
    override val message: String?
) : BaseHttpException(message)

data class NotFoundException(
    override val message: String?
) : BaseHttpException(message)

data class ConflictException(
    override val message: String?
) : BaseHttpException(message)

data class ServerException(
    override val message: String?
) : BaseHttpException(message)

data class OtherHttpException(
    override val message: String?,
    val code: Int
) : BaseHttpException(message)

data class TimeOutException(
    override val message: String?
) : BaseHttpException(message)

data class UnKnownException(
    override val message: String?
) : RuntimeException(message)

class NoInternetException : RuntimeException("네트워크가 불안정합니다, 데이터나 와이파이 연결 상태를 확인해주세요.")

class NeedLoginException : RuntimeException("토큰이 만료되었습니다. 다시 로그인 해주세요.")
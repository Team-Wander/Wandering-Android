package com.wanderring.data.utill

import java.text.SimpleDateFormat
import java.util.*

fun String?.isExpire(): Boolean =
    try {
        // 문자열을 해당 형식으로 파싱
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val parsedDate = dateFormat.parse(this)

        // 현재 시간과 비교
        parsedDate?.let {
            it.before(Date()) // 현재보다 이전이면 true 반환
        } ?: false // 파싱 실패 시 false 반환
    } catch (e: Exception) {
        e.printStackTrace()
        false // 예외 발생 시 false 반환
    }

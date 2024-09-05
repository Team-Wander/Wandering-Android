package com.wanderring.presentation.component.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.wanderring.presentation.R

// 앱 전반에서 사용할 글꼴 스타일 모음을 정의하는 객체

object DoTypography {
    val h1 = TextStyle( // headlineLarge
        fontSize = 32.sp,
        fontFamily = pretendard,
        lineHeight = 38.4.sp
    )

    val h2 = TextStyle( // headlineMedium
        fontSize = 28.sp,
        fontFamily = pretendard,
        lineHeight = 33.6.sp
    )

    val h3 = TextStyle( // headlineSmall
        fontSize = 24.sp,
        fontFamily = pretendard,
        lineHeight = 31.2.sp
    )

    val m1 = TextStyle( // bodyLarge
        fontSize = 20.sp,
        fontFamily = pretendard,
        lineHeight = 30.sp
    )

    val m2 = TextStyle( // bodyMedium
        fontSize = 18.sp,
        fontFamily = pretendard,
        lineHeight = 27.sp
    )

    val m3 = TextStyle( // bodySmall
        fontSize = 16.sp,
        fontFamily = pretendard,
        lineHeight = 24.sp
    )

    val lable = TextStyle( // labelLarge
        fontSize = 14.sp,
        fontFamily = pretendard,
        lineHeight = 21.sp
    )
}

val pretendard = FontFamily(
    Font(R.font.pretendard),
    Font(R.font.pretendard_regular),
    Font(R.font.pretendard_semi_bold)
)
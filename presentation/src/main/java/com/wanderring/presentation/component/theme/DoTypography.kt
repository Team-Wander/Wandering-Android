package com.wanderring.presentation.component.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.wanderring.presentation.R

object DoTypography {
    val h1 = TextStyle( //h1
        fontSize = 32.sp,
        fontFamily = pretendard,
        lineHeight = 38.4.sp
    )

    val h2 = TextStyle( //h2
        fontSize = 28.sp,
        fontFamily = pretendard,
        lineHeight = 33.6.sp
    )

    val h3 = TextStyle( //h3
        fontSize = 24.sp,
        fontFamily = pretendard,
        lineHeight = 31.2.sp
    )

    val m1 = TextStyle( //m1
        fontSize = 20.sp,
        fontFamily = pretendard,
        lineHeight = 30.sp
    )

    val m2 = TextStyle( //m2
        fontSize = 18.sp,
        fontFamily = pretendard,
        lineHeight = 27.sp
    )

    val m3 = TextStyle( //m3
        fontSize = 16.sp,
        fontFamily = pretendard,
        lineHeight = 24.sp
    )

    val lable = TextStyle( //lable
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
package com.wanderring.presentation.section.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanderring.presentation.R
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview
import kotlinx.collections.immutable.immutableListOf
import okhttp3.internal.immutableListOf

@Composable
fun IntroCard(modifier: Modifier = Modifier) {
    val gradientColors = listOf(Color(0xFF9DFFB8), Color(0xFF58D47B))

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = gradientColors, // 그라데이션 색상 리스트
                    end = androidx.compose.ui.geometry.Offset(0f, 0f), // 그라데이션 시작점 (왼쪽)
                    start = androidx.compose.ui.geometry.Offset(
                        Float.POSITIVE_INFINITY,
                        0f
                    ) // 그라데이션 끝점 (오른쪽)
                ), shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 32.dp, horizontal = 52.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Let’s",
                style = DoTypography.h1,
                fontWeight = FontWeight(400),
                color = DoColor.WHITE,
            )
            Text(
                text = "DO",
                style = DoTypography.h1,
                fontWeight = FontWeight(400),
                color = DoColor.WHITE,
            )
            Text(
                text = "IT",
                style = DoTypography.h1,
                fontWeight = FontWeight(400),
                color = DoColor.WHITE,
            )
        }
        Text(
            text = "원하는 것을 원하는 사람과",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 19.2.sp,
                fontFamily = FontFamily(Font(R.font.pretendard)),
                fontWeight = FontWeight(600),
                color = DoColor.WHITE,
            )
        )
    }
}

@DoPreview
@Composable
fun IntroCardPreview() {
    IntroCard()
}
package com.wanderring.presentation.section.my.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanderring.presentation.R
import com.wanderring.presentation.component.Success_FailIcon
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview

data class AlamListItemState(
    val isSuccess: Boolean,
    val titleText: String,
    val detailText: String,
)

@Composable
fun AlamListItem(
    modifier: Modifier = Modifier,
    state: AlamListItemState,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = DoColor.GRAY100,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .fillMaxWidth()
            .background(color = DoColor.WHITE, shape = RoundedCornerShape(size = 8.dp))
            .padding(horizontal = 18.dp, vertical = 13.dp)
    ) {
        Success_FailIcon(isSuccess = state.isSuccess)
        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = state.titleText,
                style = DoTypography.lable,
                fontWeight = FontWeight(600),
                color = DoColor.GRAY900,
            )
            Text(
                text = state.detailText,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard)),
                    fontWeight = FontWeight(400),
                    color = DoColor.GRAY600,
                )
            )
        }
    }
}

@DoPreview
@Composable
fun AlamListItemSuccessPreview() {
    AlamListItem(
        state = AlamListItemState(
            isSuccess = true,
            titleText = "1명이 신청했어요",
            detailText = "마이페이지에서 확인해 주세요.",
        )
    )
}

@DoPreview
@Composable
fun AlamListItemFailPreview() {
    AlamListItem(
        state = AlamListItemState(
            isSuccess = false,
            titleText = "1명이 신청을 취소했어요",
            detailText = "마이페이지에서 확인해 주세요.",
        )
    )
}

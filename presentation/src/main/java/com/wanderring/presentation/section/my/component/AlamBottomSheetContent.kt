package com.wanderring.presentation.section.my.component

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.LogoutIcon
import com.wanderring.presentation.component.PhotoIcon
import com.wanderring.presentation.component.XIcon
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview

@Composable
fun AlamBottomSheetContent(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(36.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 44.dp, vertical = 20.dp)
            .background(
                color = DoColor.WHITE,
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                )
            )

    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PhotoIcon()
            Text(
                text = "프로필 변경",
                style = DoTypography.lable,
                fontWeight = FontWeight(400),
                color = DoColor.GRAY500,
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LogoutIcon()
            Text(
                text = "로그아웃",
                style = DoTypography.lable,
                fontWeight = FontWeight(400),
                color = DoColor.RED,
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            XIcon()
            Text(
                text = "취소",
                style = DoTypography.lable,
                fontWeight = FontWeight(400),
                color = DoColor.GRAY500,
            )
        }
    }
}

@DoPreview
@Composable
fun AlamBottomSheetContentPreview() {
    AlamBottomSheetContent(modifier = Modifier.fillMaxWidth())
}
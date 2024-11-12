package com.wanderring.presentation.section.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.pretendard
import com.wanderring.presentation.utill.DoPreview

@Composable
fun SeekGrayTag(
    modifier: Modifier = Modifier,
    text: String,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = DoColor.GRAY300,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(
                horizontal = 12.dp,
                vertical = 4.dp,
            )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight(400),
                color = DoColor.GRAY400,
            )
        )
    }
}

@DoPreview
@Composable
fun SeekTagPreview() {
    SeekGrayTag(text = "#고민")
}
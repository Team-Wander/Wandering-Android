package com.wanderring.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.modifier.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview

@Composable
fun DoButton(
    modifier: Modifier = Modifier,
    color: Color = DoColor.MAIN,
    text: String,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = color,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .clickableSingle(onClick = onClick)
            .then(modifier) // modifer는 순차적으로 적용되기 때문에 padding을 나중에 적용시키기 위해 사용한 코드
    ) {
        Text(
            text = text,
            style = DoTypography.m3,
            fontWeight = FontWeight(600),
            textAlign = TextAlign.Center,
            color = DoColor.WHITE
        )
    }
}

@DoPreview
@Composable
private fun Preview() {
    DoButton(
        onClick = {},
        text = "텍스트입니다",
        modifier = Modifier
            .height(70.dp)
            .width(400.dp)
    )
}
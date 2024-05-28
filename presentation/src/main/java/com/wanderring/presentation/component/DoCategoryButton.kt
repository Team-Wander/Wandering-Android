package com.wanderring.presentation.component

import androidx.compose.foundation.border
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun DoCategoryButton(
    modifier: Modifier = Modifier,
    color: Color,
    text: String,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.border(
            width = 1.dp,
            color = color,
            shape = RoundedCornerShape(size = 8.dp)
        )
    ) {
        Text(
            text = text,
            style = DoTypography.labelLarge,
            fontWeight = FontWeight(600),
            color = color
        )
    }
}

@Preview
@Composable
private fun Preview() {
    DoCategoryButton(
        color = DoColor.CAT_RED,
        text = "텍스트입니다",
        modifier = Modifier
            .height(70.dp)
            .width(400.dp)
    )
}
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview


@Composable
fun SeekInfoTag(
    modifier: Modifier = Modifier,
    text: String,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = DoColor.MAIN,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 4.dp,
            )
    ) {
        Text(
            text = text,
            style = DoTypography.m3,
            fontWeight = FontWeight(400),
            color = DoColor.MAIN,
        )
    }
}

@DoPreview
@Composable
fun SeekInfoTagPreview() {
    SeekInfoTag(text = "1학년")
}
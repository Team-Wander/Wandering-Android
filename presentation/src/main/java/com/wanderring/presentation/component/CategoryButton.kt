package com.wanderring.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun CategoryButton(
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
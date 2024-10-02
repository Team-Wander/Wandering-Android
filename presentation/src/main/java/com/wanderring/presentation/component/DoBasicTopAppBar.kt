package com.wanderring.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun DoBasicTopAppBar(
    modifier: Modifier = Modifier,
    startIcon: @Composable () -> Unit = { Spacer(modifier = Modifier.size(24.dp)) },
    middleText: String = "",
    middleTextColor: Color = DoColor.Black,
    endIcon: @Composable () -> Unit = { Spacer(modifier = Modifier.size(24.dp)) }
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth(),
    ) {
        startIcon()
        Text(
            text = middleText,
            style = DoTypography.h3,
            fontWeight = FontWeight(600),
            color = middleTextColor,
            textAlign = TextAlign.Center,
        )
        endIcon()
    }
}
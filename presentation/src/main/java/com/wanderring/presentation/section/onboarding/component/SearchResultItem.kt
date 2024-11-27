package com.wanderring.presentation.section.onboarding.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanderring.domain.model.model.address.JusoModel
import com.wanderring.presentation.R
import com.wanderring.presentation.component.modifier.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun SearchResultItem(result: JusoModel, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickableSingle(onClick = onClick)
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = result.roadAddr,
            style = DoTypography.lable,
            fontWeight = FontWeight(400),
            color = DoColor.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = result.jibunAddr,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontFamily = FontFamily(Font(R.font.pretendard)),
                fontWeight = FontWeight(400),
                color = DoColor.GRAY500,
                textAlign = TextAlign.End,
            ),
            modifier = Modifier.weight(1f), // 남은 공간을 균등 분배
        )
    }
}

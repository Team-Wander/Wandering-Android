package com.wanderring.presentation.section.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.FilterIcon
import com.wanderring.presentation.component.MapPinIcon
import com.wanderring.presentation.component.modifier.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun FilterBar(
    modifier: Modifier = Modifier,
    location: String,
    resetLocation: () -> Unit,
    filterOnClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            MapPinIcon()
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = location,
                style = DoTypography.m2,
                fontWeight = FontWeight(600),
                color = DoColor.Black
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                modifier = Modifier.clickableSingle { resetLocation() },
                text = "위치 재설정",
                style = DoTypography.lable,
                fontWeight = FontWeight(400),
                color = DoColor.GRAY800,
                textDecoration = TextDecoration.Underline,
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(
                    color = DoColor.GRAY100,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(all = 8.dp)
        ) {
            FilterIcon(modifier = Modifier.clickableSingle { filterOnClick() })
            Text(
                text = "필터",
                style = DoTypography.lable,
                fontWeight = FontWeight(400),
                color = DoColor.GRAY400,
            )
        }
    }
}

@DoPreview
@Composable
private fun Preview() {
    FilterBar(
        modifier = Modifier.fillMaxWidth(),
        location = "여기는 부산입니다",
        resetLocation = { },
        filterOnClick = { }
    )
}
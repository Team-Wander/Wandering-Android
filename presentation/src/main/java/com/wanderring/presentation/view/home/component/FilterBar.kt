package com.wanderring.presentation.view.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.wanderring.presentation.component.FilterIcon
import com.wanderring.presentation.component.MapPinIcon
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun FilterBar(
    modifier: Modifier = Modifier,
    location: String,
    filterOnClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,) {
            MapPinIcon()
            Spacer(modifier = Modifier.fillMaxWidth(0.02439f))
            Text(
                text = location,
                style = DoTypography.bodyMedium,
                fontWeight = FontWeight(600),
                color = DoColor.Black
            )
        }
        FilterIcon(modifier = Modifier.clickableSingle { filterOnClick() })
    }
}

@Preview
@Composable
private fun Preview() {
    FilterBar(
        location = "여기는 부산입니다",
        filterOnClick = {}
    )
}
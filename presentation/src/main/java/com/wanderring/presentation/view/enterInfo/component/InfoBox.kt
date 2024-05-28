package com.wanderring.presentation.view.enterInfo.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.ChevronRightIcon
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun InfoBox(
    title: String,
    content: String,
    contentComposable: @Composable () -> Unit,
    navigateToBack: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            ChevronRightIcon(modifier = Modifier.clickableSingle { navigateToBack() })
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = title,
                    style = DoTypography.headlineMedium,
                    fontWeight = FontWeight(600),
                    color = DoColor.Black
                )
                Text(
                    text = content,
                    style = DoTypography.labelLarge,
                    fontWeight = FontWeight(400),
                    color = DoColor.GRAY600,
                )
            }
            contentComposable()
        }
    }
}

@Preview
@Composable
private fun Preview() {
    InfoBox(
        title = "제목",
        content = "내용입니다",
        contentComposable = { DoTextField(value = remember { mutableStateOf("") }) },
        navigateToBack = {}
    )
}
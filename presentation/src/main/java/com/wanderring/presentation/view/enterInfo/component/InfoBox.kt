package com.wanderring.presentation.view.enterInfo.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
    modifier: Modifier = Modifier,
    innerSpacerValue: Float = 0.04552f,
    title: String,
    content: String,
    contentComposable: @Composable () -> Unit,
    navigateToBack: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            ChevronRightIcon(modifier = Modifier.clickableSingle { navigateToBack() })
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.0789f))
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = DoTypography.headlineMedium,
                    fontWeight = FontWeight(600),
                    color = DoColor.Black
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.0214f))
                Text(
                    text = content,
                    style = DoTypography.labelLarge,
                    fontWeight = FontWeight(400),
                    color = DoColor.GRAY600,
                )
            }
            Spacer(modifier = Modifier.fillMaxHeight(innerSpacerValue))
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
package com.wanderring.presentation.view.onboarding.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.ChevronRightIcon
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview

@Composable
fun InfoBox(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    contentComposable: @Composable () -> Unit,
    navigateToBack: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(48.dp),
        horizontalAlignment = Alignment.Start,
        modifier = modifier,
    ) {
        ChevronRightIcon(modifier = Modifier
            .clickableSingle { navigateToBack() }
            .padding(vertical = 12.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = DoTypography.m1,
                    fontWeight = FontWeight(600),
                    color = DoColor.Black
                )
                Text(
                    text = content,
                    style = DoTypography.lable,
                    fontWeight = FontWeight(400),
                    color = DoColor.GRAY600,
                )
            }
            contentComposable()
        }
    }
}

@DoPreview
@Composable
private fun Preview() {
    InfoBox(
        title = "제목",
        content = "내용입니다",
        contentComposable = { DoTextField(value = "", onValueChange = { _ -> }, placeholder = "학교를 입력해주세여") },
        navigateToBack = {}
    )
}
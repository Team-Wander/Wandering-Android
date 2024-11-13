package com.wanderring.presentation.section.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wanderring.domain.model.enumType.Gender
import com.wanderring.presentation.component.DoCategoryButton
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview

@Composable
fun SeekTagForm(
    modifier: Modifier = Modifier,
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "구해요 - $title",
                style = DoTypography.m2,
                fontWeight = FontWeight(400),
                color = DoColor.Black,
            )
            Text(
                text = "(부분 중복 선택 가능) ",
                style = DoTypography.lable,
                fontWeight = FontWeight(400),
                color = DoColor.GRAY400,
            )
        }
        content()
    }
}

@DoPreview
@Composable
fun SeekTagFormPreview() {
    SeekTagForm(
        title = "성별",
        content = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Gender.entries.forEach {
                    DoCategoryButton(
                        tag = it.description
                    ) {

                    }
                }
            }
        }
    )
}
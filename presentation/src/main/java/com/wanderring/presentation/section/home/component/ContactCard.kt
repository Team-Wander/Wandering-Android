package com.wanderring.presentation.section.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.CheckIcon
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview

@Composable
fun ContactCard(
    modifier: Modifier = Modifier,
    type: String,
    content: @Composable () -> Unit,
) {
    val isSelected = remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.Start,
        modifier = modifier,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickableSingle(onClick = { isSelected.value = !isSelected.value }),
        ) {
            CheckIcon(isSelected = isSelected.value)
            Text(
                text = type,
                style = DoTypography.m3,
                fontWeight = FontWeight(400),
                color = DoColor.Black,
                textAlign = TextAlign.Right,
            )
        }
        if (isSelected.value) {
            content()
        }
    }
}

@DoPreview
@Composable
fun ContactCardPreview() {
    ContactCard(
        type = "안스타그램",
        content = {
            DoTextField(value = "아니") { }
        }
    )
}
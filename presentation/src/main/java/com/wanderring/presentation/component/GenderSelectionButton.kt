package com.wanderring.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.domain.model.enum.Gender
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun GenderSelectionButton(
    modifier: Modifier = Modifier,
    gender: Gender,
    isSelected: Boolean = false,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .then(
                if (isSelected) Modifier.background(
                    color = DoColor.MAIN,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                else Modifier
            )
            .border(
                width = 1.dp,
                color = if (isSelected) DoColor.MAIN else DoColor.GRAY300,
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Text(
            text = gender.description,
            style = DoTypography.labelLarge,
            fontWeight = FontWeight(700),
            textAlign = TextAlign.Center,
            color = if (isSelected) DoColor.WHITE else DoColor.GRAY500
        )
    }
}

@Preview
@Composable
private fun PreviewSelected() {
    GenderSelectionButton(
        gender = Gender.WOMEN,
        isSelected = true,
        modifier = Modifier
            .height(70.dp)
            .width(400.dp)
    )
}

@Preview
@Composable
private fun PreviewNotSelected() {
    GenderSelectionButton(
        gender = Gender.WOMEN,
        isSelected = false,
        modifier = Modifier
            .height(70.dp)
            .width(400.dp)
    )
}
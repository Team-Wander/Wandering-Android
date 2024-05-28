package com.wanderring.presentation.view.enterInfo.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.domain.model.enum.Grade
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun GradeSelectionItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    grade: Grade,
) {
    val color = if (isSelected) DoColor.WHITE else DoColor.GRAY800

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                if (isSelected) DoColor.MAIN else DoColor.WHITE,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = grade.description,
            style = DoTypography.labelLarge,
            fontWeight = FontWeight(700),
            textAlign = TextAlign.Center,
            color = color
        )
    }
}

@Preview
@Composable
private fun PreviewSelected() {
    GradeSelectionItem(
        grade = Grade.TWO,
        isSelected = true,
    )
}

@Preview
@Composable
private fun PreviewNotSelected() {
    GradeSelectionItem(
        grade = Grade.TWO,
        isSelected = false,
    )
}
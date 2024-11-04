package com.wanderring.presentation.section.onboarding.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.OptionIcon
import com.wanderring.presentation.component.ProfileIcon
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    name: String,
    schoolGrade: String,
    optionOnClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.background(DoColor.WHITE)
    ) {
        ProfileIcon()
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = name,
                style = DoTypography.lable,
                fontWeight = FontWeight(600),
                color = Color(0xFF333333),
            )
            Text(
                text = schoolGrade,
                style = DoTypography.lable,
                fontWeight = FontWeight(400),
                color = Color(0xFF333333),
            )
        }
        OptionIcon(
            modifier = Modifier.clickable { optionOnClick() }
        )
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    ProfileCard(
        modifier = Modifier.fillMaxWidth(),
        name = "김진원",
        schoolGrade = "광주소프트웨어마이스터고등학교 1학년",
        optionOnClick = { },
    )
}
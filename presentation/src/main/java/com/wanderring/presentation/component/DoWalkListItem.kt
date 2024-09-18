package com.wanderring.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wanderring.domain.model.enumType.Gender
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.domain.model.enumType.Tag
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.section.home.component.SeekInfoTag
import com.wanderring.presentation.section.home.component.SeekTag
import com.wanderring.presentation.utill.DoPreview
import kotlinx.collections.immutable.ImmutableList

@Composable
fun DoWalkListItem(
    modifier: Modifier = Modifier,
    gradeTag: Grade,
    genderTag: Gender,
    recruiterName: String,
    recruiterGrade: String,
    recruiterGender: String,
    intro: String,
    typeTag: ImmutableList<Tag>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .border(
                width = 1.dp,
                color = DoColor.GRAY200,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .padding(
                horizontal = 18.dp,
                vertical = 16.dp
            ),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            SeekInfoTag(text = gradeTag.description)
            SeekInfoTag(text = genderTag.description)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = recruiterName,
                style = DoTypography.lable,
                fontWeight = FontWeight(400),
                color = DoColor.GRAY700,
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .width(1.dp)
                    .background(DoColor.GRAY300)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = recruiterGrade,
                    style = DoTypography.lable,
                    fontWeight = FontWeight(400),
                    color = DoColor.GRAY500,
                )
                Spacer(
                    modifier = Modifier
                        .size(2.dp)
                        .background(
                            color = DoColor.GRAY500,
                            shape = RoundedCornerShape(8.dp),
                        )
                )
                Text(
                    text = recruiterGender,
                    style = DoTypography.lable,
                    fontWeight = FontWeight(400),
                    color = DoColor.GRAY500,
                )
            }
        }
        Text(
            text = intro,
            style = DoTypography.m1,
            fontWeight = FontWeight(600),
            color = DoColor.Black,
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
            verticalAlignment = Alignment.Top,
        ) {
            typeTag.forEach {
                SeekTag(text = it.name)
            }
        }
    }
}

@DoPreview
@Composable
private fun Preview() {
    DoWalkListItem(
        recruiterName = "이름",
        gradeTag = Grade.ONE,
        recruiterGrade = "2007.11.15",
        typeTag = kotlinx.collections.immutable.immutableListOf(Tag.CHAT),
        intro = "산택할 인간 구합니다",
        genderTag = Gender.WOMEN,
        recruiterGender = "광주소프트웨어마이스터고등학교 1학년"
    )
}
package com.wanderring.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanderring.domain.model.enumType.Tag
import com.wanderring.presentation.R
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun DoWalkListItem(
    modifier: Modifier = Modifier,
    name: String,
    title: String,
    info: String,
    tag0: Tag = Tag.NONE,
    tag0OnClick: () -> Unit,
    tag1: Tag = Tag.NONE,
    tag1OnClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = modifier
            .shadow(
                elevation = 20.dp,
                spotColor = DoColor.SHADOW,
                ambientColor = DoColor.SHADOW
            )
            .background(color = DoColor.WHITE, shape = RoundedCornerShape(size = 12.dp))
            .padding(
                horizontal = 18.dp,
                vertical = 19.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard)),
                    fontWeight = FontWeight(400),
                    color = DoColor.GRAY800,
                )
            )
            Text(
                text = title,
                style = DoTypography.bodySmall,
                fontWeight = FontWeight(600),
            )
            Text(text = info)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(18.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (tag0 != Tag.NONE) {
                DoCategoryButton(
                    tag = tag0,
                    onClick = tag0OnClick,
                    modifier = Modifier
                        .width(45.dp)
                        .height(26.dp),
                )
                if (tag1 != Tag.NONE) {
                    DoCategoryButton(
                        tag = tag1,
                        onClick = tag1OnClick,
                        modifier = Modifier
                            .width(45.dp)
                            .height(26.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    DoWalkListItem(
        modifier = Modifier
            .width(328.dp)
            .height(121.dp),
        name = "이름",
        title = "제목",
        info = "2007.11.15",
        tag0 = Tag.CHAT,
        tag0OnClick = {},
        tag1 = Tag.WORRY,
        tag1OnClick = {},
    )
}
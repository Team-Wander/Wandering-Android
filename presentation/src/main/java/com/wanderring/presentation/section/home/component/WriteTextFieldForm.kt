package com.wanderring.presentation.section.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview

@Composable
fun WriteTextFieldForm(
    modifier: Modifier = Modifier,
    title: String,
    textLengthLimit: Int = 0,
    currentTextLength: Int = 0,
    content: @Composable () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row {
                Text(
                    text = title,
                    style = DoTypography.m2,
                    fontWeight = FontWeight(400),
                    color = DoColor.Black,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "*",
                    style = DoTypography.m2,
                    fontWeight = FontWeight(400),
                    color = DoColor.MAIN,
                )
            }
            if (currentTextLength != 0) {
                Row {
                    Text(
                        text = currentTextLength.toString(),
                        style = DoTypography.lable,
                        color = DoColor.MAIN,
                        textAlign = TextAlign.Right,
                    )
                    Text(
                        text = "/",
                        style = DoTypography.lable,
                        color = DoColor.GRAY400,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = textLengthLimit.toString(),
                        style = DoTypography.lable,
                        color = DoColor.GRAY400,
                        textAlign = TextAlign.Left,
                    )
                }
            }
        }
        content()
    }
}

@DoPreview
@Composable
fun WriteTextFieldFormNonLimitPreview() {
    WriteTextFieldForm(
        title = "제목"
    ){
        DoTextField(value = "입력중") {
            
        }
    }
}

@DoPreview
@Composable
fun WriteTextFieldFormPreview() {
    WriteTextFieldForm(
        textLengthLimit = 30,
        currentTextLength = 12,
        title = "제목"
    ){
        DoTextField(value = "입력중") {

        }
    }
}
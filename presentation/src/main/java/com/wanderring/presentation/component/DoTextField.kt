package com.wanderring.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

@Composable
fun DoTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    isSearch: Boolean = false,
    value: MutableState<String>,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val focusRequester by remember { mutableStateOf(FocusRequester()) }

    BasicTextField(
        value = value.value,
        onValueChange = { newText -> value.value = newText },
        visualTransformation = visualTransformation,
        textStyle = DoTypography.bodySmall.copy(
            fontWeight = FontWeight.Normal,
            color = DoColor.Black,
            textAlign = TextAlign.Start,
        ),
        cursorBrush = SolidColor(DoColor.MAIN),
        modifier = modifier
            .focusRequester(focusRequester)
            .border(
                width = 1.dp,
                color = DoColor.MAIN,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(12.dp),
        decorationBox = { innerTextField ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier) {
                    innerTextField()
                    if (value.value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = DoTypography.bodySmall,
                            fontWeight = FontWeight(400),
                            color = DoColor.GRAY400
                        )
                    }
                }
                if (isSearch) {
                    SearchIcon()
                }
            }
        }
    )
}


@Preview
@Composable
private fun Preview() {
    DoTextField(value = remember { mutableStateOf("") })
}
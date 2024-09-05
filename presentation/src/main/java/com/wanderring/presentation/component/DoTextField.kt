package com.wanderring.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
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
    value: String,
    placeholder: String = "",
    trailingIcon: @Composable () -> Unit = { Spacer(modifier = Modifier) },
    outlineColor: Color = DoColor.MAIN,
    focusRequester: FocusRequester = FocusRequester(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit,
) {
    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        textStyle = DoTypography.m3.copy(
            fontWeight = FontWeight.Normal,
            color = DoColor.Black,
            textAlign = TextAlign.Start,
        ),
        cursorBrush = SolidColor(DoColor.MAIN),
        modifier = modifier
            .focusRequester(focusRequester)
            .border(
                width = 1.dp,
                color = outlineColor,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .padding(12.dp),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    innerTextField()
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = DoTypography.m3,
                            fontWeight = FontWeight(400),
                            color = DoColor.GRAY400
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        trailingIcon()
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    DoTextField(value = "안녕하세요", onValueChange = { _ -> }, trailingIcon = { SearchIcon() })
}
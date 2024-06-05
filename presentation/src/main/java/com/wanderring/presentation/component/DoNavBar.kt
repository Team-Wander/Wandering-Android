package com.wanderring.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography

enum class DoNavBarEnum(val description: String) {
    HOME(description = "홈"),
    SEARCH(description = "검색"),
    SETTING(description = "설정"),
    MY(description = "마이")
}

@Composable
fun DoNavBar(
    modifier: Modifier = Modifier,
    currentItem: MutableState<DoNavBarEnum>,
    navigateToHome: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToTimeSchedule: () -> Unit,
    navigateToMy: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 7.dp)
    ) {
        listOf(
            DoNavBarEnum.HOME,
            DoNavBarEnum.SEARCH,
            DoNavBarEnum.SETTING,
            DoNavBarEnum.MY
        ).forEach { enum ->
            DoNavBarItem(
                text = enum.description,
                isSelected = currentItem.value == enum,
                onClick = {
                    when (enum) {
                        DoNavBarEnum.HOME -> { navigateToHome() }
                        DoNavBarEnum.SEARCH -> { navigateToSearch() }
                        DoNavBarEnum.SETTING -> { navigateToTimeSchedule() }
                        DoNavBarEnum.MY -> { navigateToMy() }
                    }
                },
                icon = {
                    when (enum) {
                        DoNavBarEnum.HOME -> { HomeIcon(isSelected = currentItem.value == enum) }
                        DoNavBarEnum.SEARCH -> { SearchIcon(isSelected = currentItem.value == enum) }
                        DoNavBarEnum.SETTING -> { TimeScheduleIcon(isSelected = currentItem.value == enum) }
                        DoNavBarEnum.MY -> { MyIcon(isSelected = currentItem.value == enum) }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val currentIndex = remember {
        mutableStateOf(DoNavBarEnum.HOME)
    }
    DoNavBar(
        currentItem = currentIndex,
        navigateToHome = {currentIndex.value = DoNavBarEnum.HOME },
        navigateToSearch = {currentIndex.value = DoNavBarEnum.SEARCH },
        navigateToTimeSchedule = {currentIndex.value = DoNavBarEnum.SETTING },
        navigateToMy = {currentIndex.value = DoNavBarEnum.MY }
    )
}

@Composable
fun DoNavBarItem(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
) {
    val color = if (isSelected) DoColor.MAIN else DoColor.GRAY400

    Column(
        verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickableSingle(enabled = !isSelected) { onClick() }
    ) {
        icon()
        Text(
            modifier = Modifier.height(20.dp),
            text = text,
            style = DoTypography.labelLarge,
            color = color
        )
    }
}
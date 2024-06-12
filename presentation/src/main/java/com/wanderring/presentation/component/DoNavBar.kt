package com.wanderring.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
    currentItem: Int,
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
        ).forEachIndexed {  index ,enum ->
            DoNavBarItem(
                text = enum.description,
                isSelected = currentItem == index,
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
                        DoNavBarEnum.HOME -> { HomeIcon(isSelected = currentItem == index) }
                        DoNavBarEnum.SEARCH -> { SearchIcon(isSelected = currentItem == index) }
                        DoNavBarEnum.SETTING -> { TimeScheduleIcon(isSelected = currentItem == index) }
                        DoNavBarEnum.MY -> { MyIcon(isSelected = currentItem == index) }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    DoNavBar(
        currentItem = 1,
        navigateToHome = {  },
        navigateToSearch = {  },
        navigateToTimeSchedule = {  },
        navigateToMy = {  }
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
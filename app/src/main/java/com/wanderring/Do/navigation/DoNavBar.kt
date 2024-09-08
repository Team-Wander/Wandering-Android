package com.wanderring.Do.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.Do.navigation.TopLevelDestination.Home
import com.wanderring.Do.navigation.TopLevelDestination.MY
import com.wanderring.Do.navigation.TopLevelDestination.Schedule
import com.wanderring.Do.navigation.TopLevelDestination.Search
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import okhttp3.internal.immutableListOf

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
        immutableListOf(
            Home,
            Search,
            Schedule,
            MY
        ).forEachIndexed { index, type ->
            DoNavBarItem(
                text = type.destinationName,
                isSelected = currentItem == index,
                onClick = {
                    when (type) {
                        Home -> navigateToHome
                        Search -> navigateToSearch
                        Schedule -> navigateToSchedule
                        MY -> navigateToMy
                    }
                },
                icon = { type.icon() }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    DoNavBar(
        currentItem = 1,
        navigateToHome = { },
        navigateToSearch = { },
        navigateToSchedule = { },
        navigateToMy = { }
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
    val color = remember { if (isSelected) DoColor.MAIN else DoColor.GRAY400 }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickableSingle(enabled = !isSelected) { onClick() }
    ) {
        icon()
        Text(
            modifier = Modifier.height(20.dp),
            text = text,
            style = DoTypography.lable,
            color = color
        )
    }
}
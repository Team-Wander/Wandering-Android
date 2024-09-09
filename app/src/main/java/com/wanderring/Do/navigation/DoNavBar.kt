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
import androidx.compose.ui.unit.dp
import com.wanderring.Do.navigation.TopLevelDestination.Home
import com.wanderring.Do.navigation.TopLevelDestination.My
import com.wanderring.Do.navigation.TopLevelDestination.Schedule
import com.wanderring.Do.navigation.TopLevelDestination.Search
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import okhttp3.internal.immutableListOf

@Composable
fun DoNavBar(
    modifier: Modifier = Modifier,
    currentDestination: String,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit
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
            My
        ).forEach { type ->
            DoNavBarItem(
                text = type.destinationName,
                isSelected = currentDestination == type.name,
                onClick = { navigateToTopLevelDestination(type) },
                icon = { type.icon() }
            )
        }
    }
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
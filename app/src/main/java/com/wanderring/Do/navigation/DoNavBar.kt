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
import com.wanderring.presentation.component.modifier.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.utill.DoPreview
import com.wanderring.presentation.section.home.HomeRoute

@Composable
fun DoNavBar(
    modifier: Modifier = Modifier,
    currentDestination: String,
    topLevelDestinations: List<TopLevelDestination>,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 7.dp)
    ) {
        topLevelDestinations.forEach { type ->
            DoNavBarItem(
                text = type.destinationName,
                isSelected = currentDestination == type.name,
                onClick = { navigateToTopLevelDestination(type) },
                icon = { type.icon() }
            )
        }
    }
}

@DoPreview
@Composable
fun DoNavBarPreview() {
    DoNavBar(
        currentDestination = HomeRoute,
        topLevelDestinations = TopLevelDestination.entries,
        navigateToTopLevelDestination = { _ -> }
    )
}

@Composable
fun DoNavBarItem(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickableSingle(enabled = !isSelected) { onClick() }
    ) {
        icon()
        Text(
            modifier = Modifier.height(20.dp),
            text = text,
            style = DoTypography.lable,
            color = textColor
        )
    }
}
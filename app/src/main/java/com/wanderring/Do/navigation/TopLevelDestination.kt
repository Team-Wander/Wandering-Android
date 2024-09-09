package com.wanderring.Do.navigation

import androidx.compose.runtime.Composable

enum class TopLevelDestination(
    val icon: @Composable () -> Unit,
    val destinationName: String,
) {
    Home(
        icon = { com.wanderring.presentation.component.HomeIcon() },
        destinationName = "홈"
    ),
    Search(
        icon = { com.wanderring.presentation.component.SearchIcon() },
        destinationName = "검색"
    ),
    Schedule(
        icon = { com.wanderring.presentation.component.TimeScheduleIcon() },
        destinationName = "시간표"
    ),
    My(
        icon = { com.wanderring.presentation.component.MyIcon() },
        destinationName = "마이"
    ),
}

package com.wanderring.Do.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.wanderring.presentation.component.HomeIcon
import com.wanderring.presentation.component.MyIcon
import com.wanderring.presentation.component.SearchIcon
import com.wanderring.presentation.component.TimeScheduleIcon
import com.wanderring.presentation.section.home.HomeRoute
import com.wanderring.presentation.section.my.MyRoute
import com.wanderring.presentation.section.schedule.ScheduleRoute
import com.wanderring.presentation.section.search.SearchRoute

enum class TopLevelDestination(
    val icon: @Composable (Color) -> Unit,
    val destinationName: String,
    val routeName: String,
) {
    TopLevelHomeRoute(
        icon = { tint -> HomeIcon(tint = tint) },
        destinationName = "홈",
        routeName = HomeRoute
    ),
    TopLevelSearchRoute(
        icon = { tint -> SearchIcon(tint = tint) },
        destinationName = "검색",
        routeName = SearchRoute
    ),
    TopLevelScheduleRoute(
        icon = { tint -> TimeScheduleIcon(tint = tint) },
        destinationName = "시간표",
        routeName = ScheduleRoute
    ),
    TopLevelMyRoute(
        icon = { tint -> MyIcon(tint = tint) },
        destinationName = "마이",
        routeName = MyRoute
    ),
}

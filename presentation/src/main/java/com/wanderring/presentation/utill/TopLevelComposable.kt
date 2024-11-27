package com.wanderring.presentation.utill

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wanderring.presentation.section.home.HomeRoute
import com.wanderring.presentation.section.my.MyRoute
import com.wanderring.presentation.section.schedule.ScheduleRoute
import com.wanderring.presentation.section.search.SearchRoute
import kotlinx.collections.immutable.immutableListOf

fun NavGraphBuilder.topLevelComposable(
    route: String,
    currentDestination: String,
    content: @Composable () -> Unit
) {
    val screenOrder = immutableListOf(HomeRoute, SearchRoute, ScheduleRoute, MyRoute)

    composable(
        route = route,
    ) {
        content() // 해당 화면의 Composable을 호출
    }
}
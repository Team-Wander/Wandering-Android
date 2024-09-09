package com.wanderring.presentation.view.schedule

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val ScheduleRoute = "ScheduleRoute"

fun NavController.navigateToScheduleRoute(navOptions: NavOptions? = null) {
    this.navigate(ScheduleRoute, navOptions)
}

fun NavGraphBuilder.scheduleRoute() {
    composable(ScheduleRoute) {

    }
}
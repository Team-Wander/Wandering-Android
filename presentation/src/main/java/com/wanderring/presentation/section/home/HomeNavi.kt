package com.wanderring.presentation.section.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wanderring.presentation.section.home.screen.HomeRoute
import com.wanderring.presentation.section.home.screen.WriteRoute

const val HomeRoute = "HomeRoute"
const val WriteRoute = "WriteRoute"

fun NavController.navigateToHomeRoute(navOptions: NavOptions? = null) {
    this.navigate(HomeRoute, navOptions)
}

fun NavController.navigateToWriteRoute(navOptions: NavOptions? = null) {
    this.navigate(WriteRoute, navOptions)
}

fun NavGraphBuilder.homeRoute() {
    composable(HomeRoute) {
        HomeRoute()
    }
}


fun NavGraphBuilder.writeRoute() {
    composable(WriteRoute) {
        WriteRoute()
    }
}
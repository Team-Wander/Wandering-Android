package com.wanderring.presentation.section.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wanderring.presentation.section.home.screen.HomeRoute

const val HomeRoute = "HomeRoute"

fun NavController.navigateToHomeRoute(navOptions: NavOptions? = null) {
    this.navigate(HomeRoute, navOptions)
}

fun NavGraphBuilder.homeRoute() {
    composable(HomeRoute) {
        HomeRoute()
    }
}
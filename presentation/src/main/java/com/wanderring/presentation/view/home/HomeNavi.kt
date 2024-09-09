package com.wanderring.presentation.view.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val HomeRoute = "HomeRoute"

fun NavController.navigationToOnBoarding(navOptions: NavOptions? = null) {
    this.navigate(HomeRoute, navOptions)
}

fun NavGraphBuilder.onBoarding() {
    composable(HomeRoute) {

    }
}
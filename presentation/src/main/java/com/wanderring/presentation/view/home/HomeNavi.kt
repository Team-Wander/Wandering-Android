package com.wanderring.presentation.view.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val HomeRoute = "HomeRoute"

fun NavController.navigateToHomeRoute(navOptions: NavOptions? = null) {
    this.navigate(HomeRoute, navOptions)
}

fun NavGraphBuilder.homeRoute() {
    composable(HomeRoute) {

    }
}
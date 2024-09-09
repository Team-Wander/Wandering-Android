package com.wanderring.presentation.view.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val SearchRoute = "SearchRoute"

fun NavController.navigateToSearchRoute(navOptions: NavOptions? = null) {
    this.navigate(SearchRoute, navOptions)
}

fun NavGraphBuilder.searchRoute() {
    composable(SearchRoute) {

    }
}
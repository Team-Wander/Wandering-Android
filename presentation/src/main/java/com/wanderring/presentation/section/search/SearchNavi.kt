package com.wanderring.presentation.section.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wanderring.presentation.section.search.screen.WriteWatchRoute

const val SearchRoute = "SearchRoute"
const val WriteWatchRoute = "WriteWatchRoute"

fun NavController.navigateToSearchRoute(navOptions: NavOptions? = null) {
    this.navigate(SearchRoute, navOptions)
}

fun NavController.navigateToWriteRoute(navOptions: NavOptions? = null) {
    this.navigate(WriteWatchRoute, navOptions)
}

fun NavGraphBuilder.writeWatchRoute() {
    composable(WriteWatchRoute) {
        WriteWatchRoute()
    }
}
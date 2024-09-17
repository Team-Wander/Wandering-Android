package com.wanderring.presentation.section.my

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val MyRoute = "MyRoute"

fun NavController.navigateToMyRoute(navOptions: NavOptions? = null) {
    this.navigate(MyRoute, navOptions)
}

fun NavGraphBuilder.myRoute() {
    composable(MyRoute) {

    }
}
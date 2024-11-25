package com.wanderring.presentation.section.my

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wanderring.presentation.section.my.screen.MyRoute

const val MyRoute = "MyRoute"

fun NavController.navigateToMyRoute(navOptions: NavOptions? = null) {
    this.navigate(MyRoute, navOptions)
}

fun NavGraphBuilder.myRoute(navigateProfile: () -> Unit) {
    composable(MyRoute) {
        MyRoute(
            navigateProfile = navigateProfile
        )
    }
}
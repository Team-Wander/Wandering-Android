package com.wanderring.presentation.section.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wanderring.presentation.section.onboarding.screen.OnBoardingRoute
import com.wanderring.presentation.section.onboarding.screen.LoginRoute

const val OnBoardingRoute = "OnBoardingRoute"
const val LoginRoute = "LoginRoute"

fun NavController.navigateToOnBoardingRoute(navOptions: NavOptions? = null) {
    this.navigate(OnBoardingRoute, navOptions)
}

fun NavController.navigateToLoginRoute(navOptions: NavOptions? = null) {
    this.navigate(LoginRoute, navOptions)
}

fun NavGraphBuilder.onBoardingRoute(
    navigateToHome: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable(OnBoardingRoute) {
        OnBoardingRoute(
            navigateToHome = navigateToHome,
            navigateToBack = navigateToBack
        )
    }
}

fun NavGraphBuilder.loginRoute() {
    composable(LoginRoute) {
        LoginRoute()
    }
}
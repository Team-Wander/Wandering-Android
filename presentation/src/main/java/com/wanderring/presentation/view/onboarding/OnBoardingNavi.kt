package com.wanderring.presentation.view.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wanderring.presentation.view.onboarding.page.OnBoardingRoute

const val OnBoardingRoute = "OnBoardingRoute"
const val LoginRoute = "LoginRoute"

fun NavController.navigateToOnBoardingRoute(navOptions: NavOptions? = null) {
    this.navigate(OnBoardingRoute, navOptions)
}

fun NavGraphBuilder.onBoarding(
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
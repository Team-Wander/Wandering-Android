package com.wanderring.presentation.view.onboarding

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wanderring.presentation.view.onboarding.page.OnBoardingRoute

const val OnBoarding = "OnBoarding"

fun NavController.navigationToEnterInfo() {
    this.navigate(OnBoarding)
}

fun NavGraphBuilder.enterInfo(
    navigateToHome: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable(OnBoarding) {
        OnBoardingRoute(
            navigateToHome = navigateToHome,
            navigateToBack = navigateToBack
        )
    }
}
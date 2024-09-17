package com.wanderring.Do.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.wanderring.presentation.section.onboarding.onBoarding

@Composable
fun DoNavHost(
    startDestination: String,
    navController: NavHostController,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        onBoarding(
            navigateToBack = navController::popBackStack,
            navigateToHome = { TODO() }
        )
    }
}
package com.wanderring.Do.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.wanderring.Do.app.AppState
import com.wanderring.presentation.view.onboarding.onBoarding

@Composable
fun DoNavHost(
    appState: AppState,
    startDestination: String,
) {
    val navController = appState.navController

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
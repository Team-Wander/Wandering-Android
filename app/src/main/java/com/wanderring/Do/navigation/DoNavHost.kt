package com.wanderring.Do.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.wanderring.presentation.section.onboarding.onBoarding

@Composable
fun DoNavHost(
    modifier: Modifier = Modifier,
    startDestination: String,
    navController: NavHostController,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        onBoarding(
            navigateToBack = navController::popBackStack,
            navigateToHome = { TODO() }
        )
    }
}
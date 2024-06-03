package com.wanderring.Do

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wanderring.presentation.view.enterInfo.enterInfo

@Composable
fun DoNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        enterInfo(
            navigateToBack = navController::popBackStack,
            navigateToHome = { TODO() }
        )
    }
}
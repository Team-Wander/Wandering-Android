package com.wanderring.presentation.utill

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.topLevelComposable(
    route: String,
    navController: NavHostController,
    screenOrder: List<String>,
    content: @Composable () -> Unit
) {
    composable(
        route,
        enterTransition = {
            val previousRoute = navController.previousBackStackEntry?.destination?.route
            val previousIndex = screenOrder.indexOf(previousRoute)
            val currentIndex = screenOrder.indexOf(route)
            if (currentIndex > previousIndex) {
                // Moving forward (right)
                slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth })
            } else {
                // Moving backward (left)
                slideInHorizontally(initialOffsetX = { fullWidth -> -fullWidth })
            }
        },
        exitTransition = {
            val previousRoute = navController.previousBackStackEntry?.destination?.route
            val previousIndex = screenOrder.indexOf(previousRoute)
            val currentIndex = screenOrder.indexOf(route)
            if (currentIndex > previousIndex) {
                // Moving Forward (right)
                slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth })
            } else {
                // Moving Backward (left)
                slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth })
            }
        }
    ) {
        content() // 해당 화면의 Composable을 호출
    }
}
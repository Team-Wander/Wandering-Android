package com.wanderring.Do.app

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.wanderring.Do.navigation.TopLevelDestination
import com.wanderring.Do.navigation.TopLevelDestination.*
import com.wanderring.presentation.view.home.navigateToHomeRoute
import com.wanderring.presentation.view.my.navigateToMyRoute
import com.wanderring.presentation.view.schedule.navigateToScheduleRoute
import com.wanderring.presentation.view.search.navigateToSearchRoute

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
): AppState {
    return remember(navController) {
        AppState(navController = navController)
    }
}

@Stable
class AppState(val navController: NavHostController) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val isTopLevelDestination: Boolean
        @Composable get() = TopLevelDestination.values()
            .any { currentDestination?.route == it.destinationName }

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            // todo
            else -> null
        }


    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().toList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        Log.d("Navigation", "Navigation: ${topLevelDestination.name}")

        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true

            restoreState = true
        }

        when (topLevelDestination) {
            Home -> navController.navigateToHomeRoute(topLevelNavOptions)
            Search -> navController.navigateToSearchRoute(topLevelNavOptions)
            Schedule -> navController.navigateToScheduleRoute(topLevelNavOptions)
            My -> navController.navigateToMyRoute(topLevelNavOptions)
        }
    }
}
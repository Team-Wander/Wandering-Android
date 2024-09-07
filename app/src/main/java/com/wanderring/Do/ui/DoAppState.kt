package com.wanderring.Do.ui

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

@Composable
fun rememberDoAppState(
    navController: NavHostController = rememberNavController(),
): DoAppState {
    return remember(navController) {
        DoAppState(navController = navController)
    }
}

@Stable
class DoAppState(val navController: NavHostController) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

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
            TopLevelDestination.Home -> TODO()
            TopLevelDestination.Search -> TODO()
            TopLevelDestination.Schedule -> TODO()
            TopLevelDestination.MY -> TODO()
        }
    }
}
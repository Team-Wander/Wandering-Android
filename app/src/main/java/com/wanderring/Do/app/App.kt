package com.wanderring.Do.app

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wanderring.Do.navigation.DoNavBar
import com.wanderring.Do.navigation.DoNavHost
import com.wanderring.presentation.component.FloatButton
import com.wanderring.presentation.section.home.HomeRoute
import com.wanderring.presentation.component.DoMainTopBar
import com.wanderring.presentation.component.modifier.clickableSingle.clickableSingle
import com.wanderring.presentation.section.my.MyRoute
import com.wanderring.presentation.section.my.navigateToMyRoute
import com.wanderring.presentation.section.search.navigateToSearchRoute

@Composable
fun App(appState: AppState) {
    val navController = appState.navController
    val currentDestination = appState.currentDestination?.route
    val isTopLevelDestination = appState.isTopLevelDestination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            if (
                currentDestination == MyRoute
                || currentDestination == HomeRoute
            /* || currentDestination == AlarmRoute */
            ) {
                DoMainTopBar(
                    logoOnClick = { /* todo */ },
                    searchOnClick = { navController.navigateToSearchRoute() },
                    bellOnClick = { /* todo navController.navigateToAlarm() */ },
                    profileOnClick = {
                        if (currentDestination != MyRoute)
                            navController.navigateToMyRoute()
                        else Unit
                    },
                )
            }
        },
        bottomBar = {
            if (isTopLevelDestination) {
                DoNavBar(
                    currentDestination = currentDestination.orEmpty(),
                    topLevelDestinations = appState.topLevelDestinations,
                    navigateToTopLevelDestination = appState::navigateToTopLevelDestination,
                )
            }
        },
        floatingActionButton = {
            if (currentDestination == HomeRoute) {
                FloatButton(
                    modifier = Modifier.clickableSingle(
                        onClick = { /*
                     todo  navController.navigateToWrite
                    */
                        }
                    )
                )
            }
        }
    ) { paddingValues ->
        DoNavHost(
            modifier = Modifier.padding(paddingValues),
            startDestination = appState.startDestination,
            navController = appState.navController,
            navigateToTopLevelDestination = appState::navigateToTopLevelDestination
        )
    }
}
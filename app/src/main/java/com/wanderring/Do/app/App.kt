package com.wanderring.Do.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wanderring.Do.navigation.DoNavBar
import com.wanderring.Do.navigation.DoNavHost

@Composable
fun App(appState: AppState) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            if (appState.isTopLevelDestination) {
                DoNavBar(
                    currentDestination = appState.currentDestination!!.route!!,
                    topLevelDestinations = appState.topLevelDestinations,
                    navigateToTopLevelDestination = appState::navigateToTopLevelDestination,
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            DoNavHost(
                startDestination = appState.startDestination,
                navController = appState.navController,
                navigateToTopLevelDestination = appState::navigateToTopLevelDestination
            )
        }
    }
}
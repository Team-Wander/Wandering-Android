package com.wanderring.Do.ui

import androidx.compose.runtime.Composable
import com.wanderring.Do.navigation.DoNavHost

@Composable
fun App(appState: AppState) {

    DoNavHost(
        startDestination = "",
        appState = appState,
    )
}
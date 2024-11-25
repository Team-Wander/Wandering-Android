package com.wanderring.Do.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.wanderring.presentation.section.home.homeRoute
import com.wanderring.presentation.section.home.writeRoute
import com.wanderring.presentation.section.my.myRoute
import com.wanderring.presentation.section.onboarding.onBoarding
import com.wanderring.presentation.section.schedule.scheduleRoute
import com.wanderring.presentation.section.search.searchRoute
import com.wanderring.presentation.section.search.writeWatchRoute

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
            navigateToHome = { navigateToTopLevelDestination(TopLevelDestination.Home) }
        )
        homeRoute()
        writeRoute()
        searchRoute()
        writeWatchRoute()
        myRoute()
        scheduleRoute()
    }
}
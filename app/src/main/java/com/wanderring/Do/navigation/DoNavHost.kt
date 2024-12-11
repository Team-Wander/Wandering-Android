package com.wanderring.Do.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.wanderring.presentation.section.home.HomeRoute
import com.wanderring.presentation.section.home.screen.HomeRoute
import com.wanderring.presentation.section.home.writeRoute
import com.wanderring.presentation.section.my.MyRoute
import com.wanderring.presentation.section.my.screen.MyRoute
import com.wanderring.presentation.section.onboarding.onBoarding
import com.wanderring.presentation.section.schedule.ScheduleRoute
import com.wanderring.presentation.section.schedule.scheduleRoute
import com.wanderring.presentation.section.search.SearchRoute
import com.wanderring.presentation.section.search.screen.SearchRoute
import com.wanderring.presentation.section.search.writeWatchRoute
import com.wanderring.presentation.utill.BottomSheetType
import com.wanderring.presentation.utill.topLevelComposable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DoNavHost(
    modifier: Modifier = Modifier,
    startDestination: String,
    currentDestination: String,
    navController: NavHostController,
    bottomSheetState: ModalBottomSheetState,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    updateBottomSheetType: (BottomSheetType) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        onBoarding(
            navigateToBack = navController::popBackStack,
            navigateToHome = { navigateToTopLevelDestination(TopLevelDestination.TopLevelHomeRoute) }
        )
        topLevelComposable(
            route = HomeRoute,
            currentDestination = currentDestination,
            content = {
                HomeRoute()
            },
        )
        topLevelComposable(
            route = SearchRoute,
            currentDestination = currentDestination,
            content = {
                SearchRoute()
            },
        )
        topLevelComposable(
            route = ScheduleRoute,
            currentDestination = currentDestination,
            content = {
                TODO()
            },
        )
        topLevelComposable(
            route = MyRoute,
            currentDestination = currentDestination,
            content = {
                MyRoute(
                    navigateProfile = { TODO() },
                    bottomSheetState = bottomSheetState,
                    updateBottomSheetType = updateBottomSheetType,
                )
            },
        )
        writeRoute()
        writeWatchRoute(
            navigateToBackStack = navController::popBackStack,
            bottomSheetState = bottomSheetState,
            updateBottomSheetType = updateBottomSheetType,
        )
        scheduleRoute()
    }
}
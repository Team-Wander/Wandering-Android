package com.wanderring.Do.app

import android.util.Log
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wanderring.Do.navigation.DoNavBar
import com.wanderring.Do.navigation.DoNavHost
import com.wanderring.presentation.component.DoMainTopBar
import com.wanderring.presentation.component.FloatButton
import com.wanderring.presentation.component.modifier.clickableSingle.clickableSingle
import com.wanderring.presentation.section.home.HomeRoute
import com.wanderring.presentation.section.my.MyRoute
import com.wanderring.presentation.section.my.navigateToMyRoute
import com.wanderring.presentation.section.search.navigateToSearchRoute
import com.wanderring.presentation.section.search.navigateToWriteRoute
import com.wanderring.presentation.utill.BottomSheetType

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App(appState: AppState) {
    val navController = appState.navController
    val currentDestination = appState.currentDestination?.route ?: HomeRoute
    val isTopLevelDestination = appState.isTopLevelDestination
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val showTopBar = currentDestination in setOf(MyRoute, HomeRoute /*, AlarmRoute */)
    val appBottomSheetType = remember { mutableStateOf<BottomSheetType>(BottomSheetType.None) }
    Log.d("appState",appState.toString())
    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxSize(),
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        sheetContent = { appBottomSheetType.value.content() }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            topBar = {
                if (showTopBar) {
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
                        currentDestination = currentDestination,
                        topLevelDestinations = appState.topLevelDestinations,
                        navigateToTopLevelDestination = appState::navigateToTopLevelDestination,
                    )
                }
            },
            floatingActionButton = {
                if (currentDestination == HomeRoute) {
                    FloatButton(
                        modifier = Modifier.clickableSingle(
                            onClick = navController::navigateToWriteRoute
                        )
                    )
                }
            }
        ) { paddingValues ->
            DoNavHost(
                modifier = Modifier.padding(paddingValues),
                startDestination = appState.startDestination,
                navController = appState.navController,
                navigateToTopLevelDestination = appState::navigateToTopLevelDestination,
                currentDestination = currentDestination,
                bottomSheetState = bottomSheetState,
                updateBottomSheetType = { bottomSheetType ->
                    appBottomSheetType.value = bottomSheetType
                },
            )
        }
    }
}
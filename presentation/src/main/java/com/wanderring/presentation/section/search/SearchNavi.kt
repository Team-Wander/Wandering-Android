package com.wanderring.presentation.section.search

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wanderring.presentation.section.search.screen.WriteWatchRoute
import com.wanderring.presentation.utill.BottomSheetType

const val SearchRoute = "SearchRoute"
const val WriteWatchRoute = "WriteWatchRoute"

fun NavController.navigateToSearchRoute(navOptions: NavOptions? = null) {
    this.navigate(SearchRoute, navOptions)
}

fun NavController.navigateToWriteRoute(navOptions: NavOptions? = null) {
    this.navigate(WriteWatchRoute, navOptions)
}

@OptIn(ExperimentalMaterialApi::class)
fun NavGraphBuilder.writeWatchRoute(
    bottomSheetState: ModalBottomSheetState,
    updateBottomSheetType: (BottomSheetType) -> Unit,
    navigateToBackStack: () -> Unit,
) {
    composable(WriteWatchRoute) {
        WriteWatchRoute(
            navigateToBackStack = navigateToBackStack,
            bottomSheetState = bottomSheetState,
            updateBottomSheetType = updateBottomSheetType,
        )
    }
}
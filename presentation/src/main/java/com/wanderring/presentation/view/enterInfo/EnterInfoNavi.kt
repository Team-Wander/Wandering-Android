package com.wanderring.presentation.view.enterInfo

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.wanderring.presentation.view.enterInfo.page.EnterSchoolRoute

const val EnterInfo = "Enter_Info"

fun NavController.navigationToEnterInfo() {
    this.navigate(EnterInfo)
}

fun NavGraphBuilder.enterInfo(
    navigateToHome: () -> Unit,
    navigateToBack: () -> Unit,
) {
    composable(EnterInfo) {
        EnterSchoolRoute(
            navigateToHome = navigateToHome,
            navigateToBack = navigateToBack
        )
    }
}
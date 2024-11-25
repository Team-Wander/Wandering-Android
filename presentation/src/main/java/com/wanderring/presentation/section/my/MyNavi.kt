package com.wanderring.presentation.section.my

import androidx.navigation.NavController
import androidx.navigation.NavOptions

const val MyRoute = "MyRoute"

fun NavController.navigateToMyRoute(navOptions: NavOptions? = null) {
    this.navigate(MyRoute, navOptions)
}
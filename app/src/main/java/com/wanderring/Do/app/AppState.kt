package com.wanderring.Do.app

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
import com.wanderring.Do.navigation.TopLevelDestination.Home
import com.wanderring.Do.navigation.TopLevelDestination.My
import com.wanderring.Do.navigation.TopLevelDestination.Schedule
import com.wanderring.Do.navigation.TopLevelDestination.Search
import com.wanderring.data.utill.isExpire
import com.wanderring.domain.model.repository.UserDataRepository
import com.wanderring.presentation.view.home.HomeRoute
import com.wanderring.presentation.view.home.navigateToHomeRoute
import com.wanderring.presentation.view.my.navigateToMyRoute
import com.wanderring.presentation.view.onboarding.LoginRoute
import com.wanderring.presentation.view.onboarding.OnBoardingRoute
import com.wanderring.presentation.view.schedule.navigateToScheduleRoute
import com.wanderring.presentation.view.search.navigateToSearchRoute

// Compose에서 상태를 유지하기 위한 AppState 객체를 생성하는 함수
@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    userDataRepository: UserDataRepository,
): AppState {
    return remember(
        navController,
        userDataRepository
    ) {
        AppState(
            navController = navController,
            userDataRepository = userDataRepository
        )
    }
}

// 앱의 네비게이션 상태를 관리하고, 최상위 목적지로의 이동을 구현한 클래스
@Stable
class AppState(
    val navController: NavHostController,
    val userDataRepository: UserDataRepository,
) {
    // 앱의 온보딩 과정이 끝났는지 여부
    private val isOnBoardingFinished = userDataRepository.getIsOnBoardingFinished()

    val startDestination = if (isOnBoardingFinished) {
        HomeRoute
    } else if (userDataRepository.getRefreshTime().isExpire()) {
        LoginRoute
    } else {
        OnBoardingRoute
    }

    // 현재 네비게이션 백스택의 최상위 항목의 목적지
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    // 현재 목적지가 최상위 목적지 중 하나인지 여부
    val isTopLevelDestination: Boolean
        @Composable get() = TopLevelDestination.values()
            .any { currentDestination?.route == it.destinationName }

    // 모든 최상위 목적지의 리스트
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    // 최상위 목적지로 네비게이션
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        Log.d("Navigation", "Navigating to: ${topLevelDestination.name}")

        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            Home -> navController.navigateToHomeRoute(topLevelNavOptions)
            Search -> navController.navigateToSearchRoute(topLevelNavOptions)
            Schedule -> navController.navigateToScheduleRoute(topLevelNavOptions)
            My -> navController.navigateToMyRoute(topLevelNavOptions)
        }
    }
}
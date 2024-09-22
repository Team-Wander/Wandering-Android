package com.wanderring.presentation.section.home.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wanderring.presentation.component.FloatButton
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.section.home.component.DoTopBar
import com.wanderring.presentation.section.home.component.DoWalkListItem
import com.wanderring.presentation.section.home.component.FilterBar
import com.wanderring.presentation.section.home.component.IntroCard
import com.wanderring.presentation.section.home.viewModel.HomeScreenIntent
import com.wanderring.presentation.section.home.viewModel.HomeScreenState
import com.wanderring.presentation.section.home.viewModel.HomeSideEffect
import com.wanderring.presentation.section.home.viewModel.HomeViewModel
import com.wanderring.presentation.utill.DoPreview
import kotlinx.collections.immutable.immutableListOf
import kotlin.reflect.KFunction1

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val state by homeViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        homeViewModel.sideEffect.collect { effect ->
            when (effect) {
                is HomeSideEffect.NavigateToAlarm -> TODO()
                is HomeSideEffect.NavigateToMy -> TODO()
                is HomeSideEffect.NavigateToSearch -> TODO()
                is HomeSideEffect.NavigateToWrite -> TODO()
            }
        }
    }

    HomeScreen(
        modifier = modifier,
        state = state,
        handleIntent = homeViewModel::handleIntent,
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeScreenState,
    handleIntent: (HomeScreenIntent) -> Unit,
) {
    val scrollState = rememberScrollState()

    Scaffold(
        floatingActionButton = {
            FloatButton(
                modifier = Modifier.clickableSingle(
                    onClick = {
                        handleIntent(HomeScreenIntent.NavigateToWrite)
                    }
                )
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.Top),
            modifier = modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 18.dp)
                .verticalScroll(scrollState),
        ) {
            IntroCard(modifier = Modifier.fillMaxWidth())
            FilterBar(
                modifier = Modifier.fillMaxWidth(),
                location = state.location,
                filterOnClick = { handleIntent(HomeScreenIntent.NavigateToSearch) },
            )
            state.seekList.forEach {
                DoWalkListItem(state = it)
            }
        }
    }
}

@DoPreview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        handleIntent = { _ -> },
        state = HomeScreenState.getInitialState()
    )
}
package com.wanderring.presentation.view.compostion

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wanderring.presentation.component.DoNavBar
import kotlinx.coroutines.launch

@Composable
fun TopLevelViewRoute(modifier: Modifier = Modifier) {
    TopLevelView(modifier = modifier)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopLevelView(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState { 4 }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            DoNavBar(
                currentItem = pagerState.currentPage,
                navigateToHome = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(0)
                    }
                },
                navigateToSearch = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(1)
                    }
                },
                navigateToTimeSchedule = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(2)
                    }
                },
                navigateToMy = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(3)
                    }
                },
            )
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState
            ) { page ->
                when (page) {
                    0 -> {}
                    1 -> {}
                    2 -> {}
                    3 -> {}
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    TopLevelViewRoute()
}
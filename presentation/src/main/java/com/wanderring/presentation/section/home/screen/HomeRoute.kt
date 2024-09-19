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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.FloatButton
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.section.home.component.DoTopBar
import com.wanderring.presentation.section.home.component.DoWalkListItem
import com.wanderring.presentation.section.home.component.DoWalkListItemState
import com.wanderring.presentation.section.home.component.FilterBar
import com.wanderring.presentation.section.home.component.IntroCard
import com.wanderring.presentation.utill.DoPreview
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.immutableListOf

@Composable
fun HomeRoute(modifier: Modifier = Modifier) {
    HomeScreen(
        modifier = modifier,
        seekList = immutableListOf(), // TODO: 리스트 연결
        logoOnClick = { /* TODO() */ },
        searchOnClick = { /* TODO() */ },
        bellOnClick = { /* TODO() */ },
        profileOnClick = { /* TODO() */ },
        filterOnClick = { /* TODO() */ },
        navigateToWriteRoute = { /* TODO() */ },
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    seekList: ImmutableList<DoWalkListItemState>,
    logoOnClick: () -> Unit,
    searchOnClick: () -> Unit,
    bellOnClick: () -> Unit,
    profileOnClick: () -> Unit,
    filterOnClick: () -> Unit,
    navigateToWriteRoute: () -> Unit,
) {
    val scrollState = rememberScrollState()

    Scaffold(
        floatingActionButton = {
            FloatButton(modifier = Modifier.clickableSingle(onClick = navigateToWriteRoute))
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 18.dp),
        ) {
            DoTopBar(
                logoOnClick = logoOnClick,
                searchOnClick = searchOnClick,
                bellOnClick = bellOnClick,
                profileOnClick = profileOnClick,
            )
            Column(
                modifier = Modifier.verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.Top),
            ) {
                IntroCard(modifier = Modifier.fillMaxWidth())
                FilterBar(
                    modifier = Modifier.fillMaxWidth(),
                    location = "", // TODO: location 연결
                    filterOnClick = filterOnClick,
                )
                seekList.forEach {
                    DoWalkListItem(state = it)
                }
            }
        }
    }
}

@DoPreview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        seekList = immutableListOf(),
        logoOnClick = { },
        searchOnClick = { },
        bellOnClick = { },
        profileOnClick = { },
        filterOnClick = { },
        navigateToWriteRoute = { },
    )
}
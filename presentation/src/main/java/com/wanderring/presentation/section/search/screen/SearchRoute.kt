package com.wanderring.presentation.section.search.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wanderring.presentation.component.ChevronRightIcon
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.section.home.component.DoWalkListItem
import com.wanderring.presentation.section.search.viewModel.SearchScreenIntent
import com.wanderring.presentation.section.search.viewModel.SearchScreenState
import com.wanderring.presentation.section.search.viewModel.SearchSideEffect
import com.wanderring.presentation.section.search.viewModel.SearchViewModel
import com.wanderring.presentation.utill.DoPreview

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
    searchViewModel: SearchViewModel = hiltViewModel(),
) {
    val state by searchViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        searchViewModel.sideEffect.collect { effect ->
            when (effect) {
                SearchSideEffect.NavigateToBackStack -> TODO()
                SearchSideEffect.NavigateToSeekWritingDetail -> TODO()
            }
        }
    }

    SearchScreen(
        modifier = modifier,
        state = state,
        handleIntent = searchViewModel::handleIntent
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    state: SearchScreenState,
    handleIntent: (SearchScreenIntent) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ChevronRightIcon()
            DoTextField(
                value = state.searchTextState,
                onValueChange = { handleIntent(SearchScreenIntent.SetSearchTextState) }
            )
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            items(state.seekList) {
                DoWalkListItem(state = it)
            }
        }
    }
}

@DoPreview
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        state = SearchScreenState.getInitialState(),
        handleIntent = {},
    )
}
package com.wanderring.presentation.section.search.viewModel

import DoViewModel
import com.wanderring.presentation.section.home.component.DoWalkListItemState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.immutableListOf
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(

) : DoViewModel<SearchScreenIntent, SearchScreenState, SearchSideEffect>(SearchScreenState.getInitialState()) {

    override fun handleIntent(intent: SearchScreenIntent) {
        when (intent) {
            SearchScreenIntent.LoadSearchResult -> loadSearchResult()
            is SearchScreenIntent.SetSearchTextState -> setSearchTextState(intent.state)
            SearchScreenIntent.NavigateToBackStack -> SearchSideEffect.NavigateToBackStack
            SearchScreenIntent.NavigateToSeekWritingDetail -> SearchSideEffect.NavigateToSeekWritingDetail
        }
    }

    private fun loadSearchResult() {
        // TODO:
    }

    private fun setSearchTextState(textState: String) {
        // TODO:
    }
}

sealed class SearchScreenIntent {
    data object NavigateToSeekWritingDetail : SearchScreenIntent()
    data object LoadSearchResult : SearchScreenIntent()
    data class SetSearchTextState(val state: String) : SearchScreenIntent()
    data object NavigateToBackStack : SearchScreenIntent()
}

data class SearchScreenState(
    val searchTextState: String,
    val seekList: ImmutableList<DoWalkListItemState>,
) {
    companion object {
        // State의 초기값을 넣어주기위해 필수로 구현해야하는 함수
        fun getInitialState() = SearchScreenState(
            searchTextState = "",
            seekList = immutableListOf(),
        )
    }
}

sealed class SearchSideEffect {
    data object NavigateToSeekWritingDetail : SearchSideEffect()
    data object NavigateToBackStack : SearchSideEffect()
}
package com.wanderring.presentation.section.home.viewModel

import DoViewModel
import com.wanderring.presentation.section.home.component.DoWalkListItemState
import com.wanderring.presentation.section.home.viewModel.HomeScreenIntent.LoadCurrentAlarmCount
import com.wanderring.presentation.section.home.viewModel.HomeScreenIntent.LoadLocation
import com.wanderring.presentation.section.home.viewModel.HomeScreenIntent.LoadSeekList
import com.wanderring.presentation.section.home.viewModel.HomeScreenIntent.NavigateToSearch
import com.wanderring.presentation.section.home.viewModel.HomeScreenIntent.NavigateToWrite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.immutableListOf
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : DoViewModel<HomeScreenIntent, HomeScreenState, HomeSideEffect>(HomeScreenState.getInitialState()) {
    override fun handleIntent(intent: HomeScreenIntent) {
        when (intent) {
            LoadCurrentAlarmCount -> loadCurrentAlarmCount()
            LoadLocation -> loadLocation()
            LoadSeekList -> loadSeekList()
            NavigateToSearch -> postSideEffect(HomeSideEffect.NavigateToSearch)
            NavigateToWrite -> postSideEffect(HomeSideEffect.NavigateToWrite)
        }
    }

    private fun loadLocation() {
        setState { copy(location = "") }
    }

    private fun loadSeekList() {
        setState { copy(seekList = immutableListOf()) }
    }

    private fun loadCurrentAlarmCount() {
        setState { copy(currentAlarmCount = 0) }
    }
}

sealed class HomeScreenIntent {
    data object LoadSeekList : HomeScreenIntent()
    data object LoadLocation : HomeScreenIntent()
    data object LoadCurrentAlarmCount : HomeScreenIntent()
    data object NavigateToWrite : HomeScreenIntent()
    data object NavigateToSearch : HomeScreenIntent()
}

data class HomeScreenState(
    val location: String,
    val seekList: ImmutableList<DoWalkListItemState>,
    val currentAlarmCount: Int,
) {
    companion object {
        // State의 초기값을 넣어주기위해 필수로 구현해야하는 함수
        fun getInitialState() = HomeScreenState(
            location = "",
            seekList = immutableListOf(),
            currentAlarmCount = 0,
        )
    }
}

sealed class HomeSideEffect {
    data object NavigateToWrite : HomeSideEffect()
    data object NavigateToSearch : HomeSideEffect()
}
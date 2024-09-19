package com.wanderring.presentation.section.home.viewModel

import DoViewModel
import com.wanderring.presentation.section.home.component.DoWalkListItemState
import com.wanderring.presentation.section.home.viewModel.HomeScreenIntent.*
import com.wanderring.presentation.section.home.viewModel.HomeScreenState.Companion.getInitialState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.immutableListOf
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() :
    DoViewModel<HomeScreenIntent, HomeScreenState, HomeSideEffect>() {

    override fun initialState(): HomeScreenState = getInitialState()

    override fun handleIntent(intent: HomeScreenIntent) {
        when (intent) {
            LoadCurrentAlarmCount -> loadCurrentAlarmCount()
            LoadLocation -> loadLocation()
            LoadSeekList -> loadSeekList()
            NavigateToAlarm -> postSideEffect(HomeSideEffect.NavigateToAlarm)
            NavigateToMy -> postSideEffect(HomeSideEffect.NavigateToMy)
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
    data object NavigateToAlarm : HomeScreenIntent()
    data object NavigateToMy : HomeScreenIntent()
}

data class HomeScreenState(
    val location: String,
    val seekList: ImmutableList<DoWalkListItemState>,
    val currentAlarmCount: Int,
) {
    companion object {
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
    data object NavigateToAlarm : HomeSideEffect()
    data object NavigateToMy : HomeSideEffect()
}
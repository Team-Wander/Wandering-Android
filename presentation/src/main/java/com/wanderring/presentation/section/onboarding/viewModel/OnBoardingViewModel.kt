package com.wanderring.presentation.section.onboarding.viewModel

import androidx.lifecycle.viewModelScope
import com.wanderring.domain.model.address.JusoModel
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.domain.repository.AddressRepository
import com.wanderring.presentation.utill.DoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val addressRepository: AddressRepository,
) : DoViewModel<OnBoardingScreenIntent, OnBoardingScreenState, OnBoardingSideEffect>(
    OnBoardingScreenState.getInitialState()
) {
    override fun handleIntent(intent: OnBoardingScreenIntent) {
        when (intent) {
            OnBoardingScreenIntent.PostInfo -> postInfo()
            OnBoardingScreenIntent.NavigateToBack -> postSideEffect(OnBoardingSideEffect.NavigateToBack)
            is OnBoardingScreenIntent.UpdateSchool -> updateSchool(intent.school)
            is OnBoardingScreenIntent.UpdateGrade -> updateGrade(intent.grade)
            is OnBoardingScreenIntent.UpdateSpot -> updateSpot(intent.spot)
            is OnBoardingScreenIntent.UpdateSearchText -> updateSearchTextState(intent.searchText)
            is OnBoardingScreenIntent.UpdateSearchLocation -> searchLocation(intent.searchText)
        }
    }

    private fun updateSchool(inputSchool: String) = setState { copy(school = inputSchool) }
    private fun updateGrade(inputGrade: Grade) = setState { copy(grade = inputGrade) }
    private fun updateSpot(inputSpot: String) =
        setState {
            copy(
                searchTextState = inputSpot,
                spot = inputSpot,
                searchResult = persistentListOf()
            )
        }


    private fun updateSearchTextState(searchTextState: String) =
        setState { copy(searchTextState = searchTextState) }

    private fun searchLocation(searchTextState: String) = viewModelScope.launch {
        addressRepository.getAddress(
            currentPage = 1,
            countPerPage = 5,
            keyword = searchTextState
        ).collect {
            setState { copy(searchResult = it.toImmutableList()) }
        }
    }

    private fun postInfo() {
        // TODO: 통신 구현
        postSideEffect(OnBoardingSideEffect.NavigateToHome)
    }
}

sealed class OnBoardingScreenIntent {
    data class UpdateSchool(val school: String) : OnBoardingScreenIntent()
    data class UpdateGrade(val grade: Grade) : OnBoardingScreenIntent()
    data class UpdateSpot(val spot: String) : OnBoardingScreenIntent()
    data class UpdateSearchText(val searchText: String) : OnBoardingScreenIntent()
    data class UpdateSearchLocation(val searchText: String) : OnBoardingScreenIntent()
    data object PostInfo : OnBoardingScreenIntent()
    data object NavigateToBack : OnBoardingScreenIntent()
}

data class OnBoardingScreenState(
    val school: String,
    val grade: Grade,
    val spot: String,
    val searchTextState: String,
    val searchResult: ImmutableList<JusoModel>,
) {
    companion object {
        // State의 초기값을 넣어주기위해 필수로 구현해야하는 함수
        fun getInitialState() = OnBoardingScreenState(
            school = "",
            grade = Grade.NONE,
            spot = "",
            searchTextState = "",
            searchResult = persistentListOf(),
        )
    }
}

sealed class OnBoardingSideEffect {
    data object NavigateToHome : OnBoardingSideEffect()
    data object NavigateToBack : OnBoardingSideEffect()
}
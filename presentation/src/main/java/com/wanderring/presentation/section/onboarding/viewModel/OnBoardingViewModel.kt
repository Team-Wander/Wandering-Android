package com.wanderring.presentation.section.onboarding.viewModel

import com.wanderring.domain.model.enumType.Grade
import com.wanderring.presentation.utill.DoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(

) : DoViewModel<OnBoardingScreenIntent, OnBoardingScreenState, OnBoardingSideEffect>(
    OnBoardingScreenState.getInitialState()
) {
    override fun handleIntent(intent: OnBoardingScreenIntent) {
        when (intent) {
            OnBoardingScreenIntent.PostInfo -> postInfo()
            is OnBoardingScreenIntent.UpdateSchool -> updateSchool(intent.school)
            is OnBoardingScreenIntent.UpdateGrade -> updateGrade(intent.grade)
            is OnBoardingScreenIntent.UpdateSpot -> updateSpot(intent.spot)
        }
    }

    private fun updateSchool(school: String) = setState { copy(school = school) }
    private fun updateGrade(grade: Grade) = setState { copy(grade = grade) }
    private fun updateSpot(spot: String) = setState { copy(spot = spot) }

    private fun postInfo() {
        // TODO: 통신 구현
        postSideEffect(OnBoardingSideEffect.NavigateToHome)
    }
}

sealed class OnBoardingScreenIntent {
    data class UpdateSchool(val school: String) : OnBoardingScreenIntent()
    data class UpdateGrade(val grade: Grade) : OnBoardingScreenIntent()
    data class UpdateSpot(val spot: String) : OnBoardingScreenIntent()
    data object PostInfo : OnBoardingScreenIntent()
}

data class OnBoardingScreenState(
    val school: String,
    val grade: Grade,
    val spot: String,
) {
    companion object {
        // State의 초기값을 넣어주기위해 필수로 구현해야하는 함수
        fun getInitialState() = OnBoardingScreenState(
            school = "",
            grade = Grade.NONE,
            spot = "",
        )
    }
}

sealed class OnBoardingSideEffect {
    data object NavigateToHome : OnBoardingSideEffect()
}
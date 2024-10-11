package com.wanderring.presentation.section.my.viewModel

import com.wanderring.presentation.section.my.component.AlamListItemState
import com.wanderring.presentation.utill.DoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.immutableListOf
import javax.inject.Inject

@HiltViewModel
class AlamViewModel @Inject constructor(

) : DoViewModel<AlamScreenIntent, AlamScreenState, AlamSideEffect>(AlamScreenState.getInitialState()) {
    override fun handleIntent(intent: AlamScreenIntent) {
        when (intent) {
            AlamScreenIntent.LoadAlamList -> loadAlamList()
            AlamScreenIntent.NavigateToBackStack -> postSideEffect(AlamSideEffect.NavigateToBackStack)
        }
    }

    private fun loadAlamList() {
        // TODO: 통신 구현
        setState {
            copy(
                totalAlamList = totalAlamList,
                successAlamList = successAlamList,
                failAlamList = failAlamList,
            )
        }
    }
}

sealed class AlamScreenIntent {
    data object LoadAlamList : AlamScreenIntent()
    data object NavigateToBackStack : AlamScreenIntent()
}

data class AlamScreenState(
    val totalAlamList: ImmutableList<AlamListItemState>,
    val successAlamList: ImmutableList<AlamListItemState>,
    val failAlamList: ImmutableList<AlamListItemState>,
) {
    companion object {
        // State의 초기값을 넣어주기위해 필수로 구현해야하는 함수
        fun getInitialState() = AlamScreenState(
            totalAlamList = immutableListOf(),
            successAlamList = immutableListOf(),
            failAlamList = immutableListOf(),
        )
    }
}

sealed class AlamSideEffect {
    data object NavigateToBackStack : AlamSideEffect()
}
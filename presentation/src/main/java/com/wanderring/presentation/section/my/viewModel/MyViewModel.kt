package com.wanderring.presentation.section.my.viewModel

import com.wanderring.presentation.section.home.component.DoWalkListItemState
import com.wanderring.presentation.utill.DoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.immutableListOf
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(

) : DoViewModel<MyIntent, MyState, MySideEffect>(MyState.getInitialState()) {
    override fun handleIntent(intent: MyIntent) {
        when (intent) {
            MyIntent.NavigateToProfile -> postSideEffect(MySideEffect.NavigateProfile)
            MyIntent.LoadWriteList -> loadWriteList()
            MyIntent.LoadReservationList -> loadReservationList()
        }
    }

    private fun loadWriteList() {
        // TODO: 통신 구현
        setState {
            copy(write = write)
        }
    }

    private fun loadReservationList() {
        // TODO: 통신 구현
        setState {
            copy(reservation = reservation)
        }
    }
}

sealed class MyIntent {
    data object LoadWriteList : MyIntent()
    data object LoadReservationList : MyIntent()
    data object NavigateToProfile : MyIntent()
}

data class MyState(
    val name: String,
    val schoolGrade: String,
    val write: ImmutableList<DoWalkListItemState>,
    val reservation: ImmutableList<DoWalkListItemState>,
) {
    companion object {
        // State의 초기값을 넣어주기위해 필수로 구현해야하는 함수
        fun getInitialState() = MyState(
            name = "",
            schoolGrade = "",
            write = immutableListOf(),
            reservation = immutableListOf(),
        )
    }
}

sealed class MySideEffect {
    data object NavigateProfile : MySideEffect()
}
package com.wanderring.presentation.section.home.viewModel

import com.wanderring.presentation.utill.DoViewModel
import androidx.lifecycle.viewModelScope
import com.wanderring.domain.model.enumType.Gender
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.domain.model.enumType.Tag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.immutableSetOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(

) : DoViewModel<WriteScreenIntent, WriteScreenState, WriteSideEffect>(WriteScreenState.getInitialState()) {
    override fun handleIntent(intent: WriteScreenIntent) {
        when (intent) {
            is WriteScreenIntent.SetTitleTextState -> setState { copy(titleTextState = intent.state) }
            is WriteScreenIntent.SetMeetLocationTextState -> setState { copy(meetLocationTextState = intent.state) }
            is WriteScreenIntent.SetContentTextState -> setState { copy(contentTextState = intent.state) }
            is WriteScreenIntent.SetTagListState -> setState { copy(tagListState = intent.setState) }
            is WriteScreenIntent.SetGradeListState -> setState { copy(gradeListLState = intent.setState) }
            is WriteScreenIntent.SetGenderTextState -> setState { copy(genderListState = intent.setState) }
            is WriteScreenIntent.SetInstagramIdTextState -> setState { copy(instagramId = intent.state) }
            is WriteScreenIntent.SetDiscordIdTextState -> setState { copy(disCordId = intent.state) }
            is WriteScreenIntent.SetKakaotalkIdTextState -> setState { copy(kakaotalkId = intent.state) }
            is WriteScreenIntent.SetEmailIdTextState -> setState { copy(emailId = intent.state) }
            WriteScreenIntent.NavigateToBackStack -> postSideEffect(WriteSideEffect.NavigateToBackStack)
            WriteScreenIntent.SendWriteData -> sendWriteData()
        }
    }

    private fun sendWriteData() = viewModelScope.launch {
        // TODO: 통신 연결
        postSideEffect(WriteSideEffect.NavigateToHome)
    }
}

sealed class WriteScreenIntent {
    data class SetTitleTextState(val state: String) : WriteScreenIntent()
    data class SetMeetLocationTextState(val state: String) : WriteScreenIntent()
    data class SetContentTextState(val state: String) : WriteScreenIntent()
    data class SetTagListState(val setState: ImmutableSet<Tag>) : WriteScreenIntent()
    data class SetGradeListState(val setState: ImmutableSet<Grade>) : WriteScreenIntent()
    data class SetGenderTextState(val setState: ImmutableSet<Gender>) : WriteScreenIntent()
    data class SetInstagramIdTextState(val state: String) : WriteScreenIntent()
    data class SetDiscordIdTextState(val state: String) : WriteScreenIntent()
    data class SetKakaotalkIdTextState(val state: String) : WriteScreenIntent()
    data class SetEmailIdTextState(val state: String) : WriteScreenIntent()
    data object NavigateToBackStack : WriteScreenIntent()
    data object SendWriteData : WriteScreenIntent()
}

data class WriteScreenState(
    val titleTextState: String,
    val meetLocationTextState: String,
    val contentTextState: String,
    val tagListState: ImmutableSet<Tag>,
    val gradeListLState: ImmutableSet<Grade>,
    val genderListState: ImmutableSet<Gender>,
    val instagramId: String,
    val disCordId: String,
    val kakaotalkId: String,
    val emailId: String,
) {
    companion object {
        // State의 초기값을 넣어주기위해 필수로 구현해야하는 함수
        fun getInitialState() = WriteScreenState(
            titleTextState = "",
            meetLocationTextState = "",
            contentTextState = "",
            tagListState = immutableSetOf(),
            gradeListLState = immutableSetOf(),
            genderListState = immutableSetOf(),
            instagramId = "",
            disCordId = "",
            kakaotalkId = "",
            emailId = "",
        )
    }
}

sealed class WriteSideEffect {
    data object NavigateToBackStack : WriteSideEffect()
    data object NavigateToHome : WriteSideEffect()
}
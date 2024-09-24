package com.wanderring.presentation.section.home.viewModel

import DoViewModel
import androidx.lifecycle.viewModelScope
import com.wanderring.domain.model.enumType.Gender
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.domain.model.enumType.Tag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.immutableListOf
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
            is WriteScreenIntent.SetTagListState -> setState { copy(tagListState = intent.listState) }
            is WriteScreenIntent.SetGradeListState -> setState { copy(gradeListLState = intent.listState) }
            is WriteScreenIntent.SetGenderTextState -> setState { copy(genderListState = intent.listState) }
            WriteScreenIntent.SetIsEnableInstagram -> setState { copy(isEnableInstagram = !state.value.isEnableInstagram) }
            WriteScreenIntent.SetIsEnableDisCord -> setState { copy(isEnableDisCord = !state.value.isEnableDisCord) }
            WriteScreenIntent.SetIsEnableKakaotalk -> setState { copy(isEnableKakaotalk = !state.value.isEnableKakaotalk) }
            WriteScreenIntent.SetIsEnableEmail -> setState { copy(isEnableEmail = !state.value.isEnableEmail) }
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
    data class SetTagListState(val listState: ImmutableList<Tag>) : WriteScreenIntent()
    data class SetGradeListState(val listState: ImmutableList<Grade>) : WriteScreenIntent()
    data class SetGenderTextState(val listState: ImmutableList<Gender>) : WriteScreenIntent()
    data object SetIsEnableInstagram : WriteScreenIntent()
    data object SetIsEnableDisCord : WriteScreenIntent()
    data object SetIsEnableKakaotalk : WriteScreenIntent()
    data object SetIsEnableEmail : WriteScreenIntent()
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
    val tagListState: ImmutableList<Tag>,
    val gradeListLState: ImmutableList<Grade>,
    val genderListState: ImmutableList<Gender>,
    val isEnableInstagram: Boolean,
    val isEnableDisCord: Boolean,
    val isEnableKakaotalk: Boolean,
    val isEnableEmail: Boolean,
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
            tagListState = immutableListOf(),
            gradeListLState = immutableListOf(),
            genderListState = immutableListOf(),
            isEnableInstagram = false,
            isEnableDisCord = false,
            isEnableKakaotalk = false,
            isEnableEmail = false,
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
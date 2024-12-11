package com.wanderring.presentation.section.search.viewModel

import com.wanderring.domain.model.enumType.Gender
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.domain.model.enumType.Tag
import com.wanderring.presentation.utill.DoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WriteWatchViewModel @Inject constructor(

) : DoViewModel<WriteWatchIntent, WriteWatchScreenState, WriteWatchSideEffect>(WriteWatchScreenState.getInitialState()) {

    override fun handleIntent(intent: WriteWatchIntent) {
        when (intent) {
            WriteWatchIntent.LoadAllData -> TODO()
            WriteWatchIntent.NavigateToBackStack -> postSideEffect(WriteWatchSideEffect.NavigateToBackStack)
            is WriteWatchIntent.SendReport -> TODO()
            WriteWatchIntent.HideBottomSheet -> postSideEffect(WriteWatchSideEffect.ShowBottomSheet)
            WriteWatchIntent.ShowBottomSheet -> postSideEffect(WriteWatchSideEffect.HideBottomSheet)
        }
    }
}

sealed class WriteWatchIntent {
    data object LoadAllData : WriteWatchIntent()
    data class SendReport(val body: ReportBody) : WriteWatchIntent()
    data object NavigateToBackStack : WriteWatchIntent()
    data object ShowBottomSheet : WriteWatchIntent()
    data object HideBottomSheet : WriteWatchIntent()
}

data class WriteWatchScreenState(
    val id: Long,
    val author: String,
    val authorSchool: String,
    val authorGrade: Grade,
    val authorGender: Gender,
    val authorProfile: String,
    val title: String,
    val content: String,
    val date: String,
    val maximum: Int,
    val spot: String,
    val contact: ImmutableList<String>,
    val gender: ImmutableList<Gender>,
    val tag: ImmutableList<Tag>,
    val grade: ImmutableList<Grade>,
) {
    companion object {
        // State의 초기값을 넣어주기위해 필수로 구현해야하는 함수
        fun getInitialState() = WriteWatchScreenState(
            id = 0L,
            author = "",
            authorSchool = "",
            authorGrade = Grade.NONE,
            authorGender = Gender.NONE,
            authorProfile = "",
            title = "",
            content = "",
            date = "",
            maximum = 1,
            spot = "",
            checkBoxState = 0,
            contact = persistentListOf(),
            gender = persistentListOf(),
            tag = persistentListOf(),
            grade = persistentListOf(),
        )
    }
}

data class ReportBody(
    val reason: Reason,
    val content: String // 신고 사유
)

enum class Reason(
    val description: String,
    val enumName: String,
) {
    PERSONAL_INFO_DISCLOSURE(
        description = "개인정보노출",
        enumName = "Personal_Info_Disclosure",
    ), // 개인 정보 노출
    SAME_CONTENT(
        description = "같은내용 반복작성",
        enumName = "Same_Content",
    ), // 같은 내용 반복 작성
    ABUSIVE_ATTACKS(
        description = "욕설/인신공격",
        enumName = "Abusive_Attacks",
    ), // 욕설, 인신 공격
    PROMOTIONAL_COMMERCIAL(
        description = "홍보성/상업적",
        enumName = "Promotional_Commercial",
    ), // 홍보, 상업적
    OBSCENE_SENSATIONALISM(
        description = "음란/선정성",
        enumName = "Obscene_Sensationalism",
    ), // 음란, 선정성
    ETC(
        description = "기타",
        enumName = "ETC",
    ) // 기타
}


sealed class WriteWatchSideEffect {
    data object NavigateToBackStack : WriteWatchSideEffect()
    data object HideBottomSheet : WriteWatchSideEffect()
    data object ShowBottomSheet : WriteWatchSideEffect()
}
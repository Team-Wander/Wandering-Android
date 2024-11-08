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
            WriteWatchIntent.NavigateToBackStack -> TODO()
            is WriteWatchIntent.SendReport -> TODO()
        }
    }
}
data class ReportBody(
    val reason: Reason,
    val content: String // 신고 사유
)

enum class Reason {
    Personal_Info_Disclosure, // 개인 정보 노출
    Same_Content,             // 같은 내용 반복 작성
    Abusive_Attacks,          // 욕설, 인신 공격
    Obscene_Sensationalism,    // 음란, 선정성
    Promotional_Commercial,    // 홍보, 상업적
    ETC                        // 기타
}

sealed class WriteWatchIntent {
    data object LoadAllData : WriteWatchIntent()
    data class SendReport(val body: ReportBody) : WriteWatchIntent()
    data object NavigateToBackStack : WriteWatchIntent()
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
    val contact: List<String>,
    val spot: String,
    val gender: List<Gender>,
    val tag: List<Tag>,
    val grade: List<Grade>
) {
    companion object {
        // State의 초기값을 넣어주기위해 필수로 구현해야하는 함수
        fun getInitialState() = WriteWatchScreenState(
            id = 0L,
            author = "",
            authorSchool = "",
            authorGrade = Grade.ONE,
            authorGender = Gender.NONE,
            authorProfile = "",
            title = "",
            content = "",
            date = "",
            maximum = 1,
            contact = listOf("", "", "", ""),
            spot = "",
            gender = listOf(Gender.NONE),
            tag = listOf(),
            grade = listOf(Grade.NOTHING)
        )
    }
}

sealed class WriteWatchSideEffect {
    data object NavigateToBackStack : WriteWatchSideEffect()
}
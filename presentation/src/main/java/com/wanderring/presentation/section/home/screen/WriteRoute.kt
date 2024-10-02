package com.wanderring.presentation.section.home.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wanderring.domain.model.enumType.Gender
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.domain.model.enumType.Tag
import com.wanderring.presentation.component.ChevronRightIcon
import com.wanderring.presentation.component.DoBasicTopAppBar
import com.wanderring.presentation.component.DoCategoryButton
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.SearchIcon
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.section.home.component.ContactCard
import com.wanderring.presentation.section.home.component.SeekTagForm
import com.wanderring.presentation.section.home.component.WriteTextFieldForm
import com.wanderring.presentation.section.home.viewModel.WriteScreenIntent
import com.wanderring.presentation.section.home.viewModel.WriteScreenState
import com.wanderring.presentation.section.home.viewModel.WriteSideEffect
import com.wanderring.presentation.section.home.viewModel.WriteViewModel
import com.wanderring.presentation.utill.DoPreview
import kotlinx.collections.immutable.immutableSetOf
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableSet

@Composable
fun WriteRoute(
    modifier: Modifier = Modifier,
    writeViewModel: WriteViewModel = hiltViewModel(),
) {
    val writeScreenState by writeViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        writeViewModel.sideEffect.collect {
            when (it) {
                WriteSideEffect.NavigateToBackStack -> TODO()
                WriteSideEffect.NavigateToHome -> TODO()
            }
        }
    }

    WriteScreen(
        modifier = modifier,
        writeScreenState = writeScreenState,
        handleIntent = writeViewModel::handleIntent
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WriteScreen(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    writeScreenState: WriteScreenState,
    handleIntent: (WriteScreenIntent) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(40.dp, Alignment.Top),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
    ) {
        DoBasicTopAppBar(
            startIcon = { ChevronRightIcon() },
            middleText = "글쓰기",
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(40.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize(),
        ) {
            WriteTextFieldForm(
                title = "제목",
                currentTextLength = writeScreenState.titleTextState.length,
                textLengthLimit = 30
            ) {
                DoTextField(
                    value = writeScreenState.titleTextState,
                    placeholder = "제목을 입력해 주세요",
                    outlineColor = DoColor.GRAY200,
                ) {
                    handleIntent(WriteScreenIntent.SetTitleTextState(it))
                }
            }
            WriteTextFieldForm(title = "약속장소") {
                DoTextField(
                    value = writeScreenState.meetLocationTextState,
                    placeholder = "약속장소를 입력해주세요",
                    outlineColor = DoColor.GRAY200,
                    trailingIcon = { SearchIcon() },
                ) {
                    handleIntent(WriteScreenIntent.SetMeetLocationTextState(it))
                }
            }
            WriteTextFieldForm(
                title = "내용",
                currentTextLength = writeScreenState.contentTextState.length,
                textLengthLimit = 300
            ) {
                DoTextField(
                    value = writeScreenState.contentTextState,
                    placeholder = "내용을 입력해 주세요",
                    outlineColor = DoColor.GRAY200,
                ) {
                    handleIntent(WriteScreenIntent.SetContentTextState(it))
                }
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Row {
                    Text(
                        text = "태그",
                        style = DoTypography.m2,
                        fontWeight = FontWeight(400),
                        color = DoColor.Black,
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "*",
                        style = DoTypography.m2,
                        fontWeight = FontWeight(400),
                        color = DoColor.MAIN,
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "최대 2개까지 설정할 수 있어요",
                    style = DoTypography.lable,
                    fontWeight = FontWeight(400),
                    color = DoColor.GRAY500,
                )
                Spacer(modifier = Modifier.height(6.dp))
                FlowRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Tag.entries.forEach { tag ->
                        val isSelected = writeScreenState.tagListState.contains(tag)
                        DoCategoryButton(
                            tag = tag.description,
                            isSelected = isSelected
                        ) {
                            val updatedTagList = if (isSelected) {
                                writeScreenState.tagListState.filterNot { it == tag }
                            } else {
                                if (writeScreenState.tagListState.size < 2) {
                                    writeScreenState.tagListState + tag
                                } else {
                                    writeScreenState.tagListState
                                }
                            }
                            handleIntent(WriteScreenIntent.SetTagListState(updatedTagList.toImmutableSet()))
                        }
                    }
                }
            }
            SeekTagForm(
                title = "학년",
                content = {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        persistentListOf(
                            Grade.ONE,
                            Grade.TWO,
                            Grade.THREE,
                            Grade.FOUR,
                            Grade.FIVE,
                            Grade.SIX,
                            Grade.ALL
                        ).forEach { grade ->
                            val isSelected = writeScreenState.gradeListLState.contains(grade)
                            DoCategoryButton(
                                tag = grade.description,
                                isSelected = isSelected
                            ) {
                                val updatedTagList = if (isSelected) {
                                    writeScreenState.gradeListLState.filterNot { it == grade }
                                } else {
                                    if (writeScreenState.gradeListLState.size < 2) {
                                        writeScreenState.gradeListLState + grade
                                    } else {
                                        writeScreenState.gradeListLState
                                    }
                                }
                                handleIntent(WriteScreenIntent.SetGradeListState(updatedTagList.toImmutableSet()))
                            }
                        }
                    }
                }
            )
            SeekTagForm(
                title = "성별",
                content = {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Gender.entries.forEach { gender ->
                            val isSelected = writeScreenState.genderListState.contains(gender)
                            DoCategoryButton(
                                tag = gender.description,
                                isSelected = isSelected
                            ) {
                                val updatedTagList = if (isSelected) {
                                    writeScreenState.genderListState.filterNot { it == gender }
                                } else {
                                    if (writeScreenState.genderListState.size < 2) {
                                        writeScreenState.genderListState + gender
                                    } else {
                                        writeScreenState.genderListState
                                    }
                                }
                                handleIntent(WriteScreenIntent.SetGenderTextState(updatedTagList.toImmutableSet()))
                            }
                        }
                    }
                }
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row {
                        Text(
                            text = "연락처",
                            style = DoTypography.m2,
                            fontWeight = FontWeight(400),
                            color = DoColor.Black,
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "*",
                            style = DoTypography.m2,
                            fontWeight = FontWeight(400),
                            color = DoColor.MAIN,
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "(선택) ",
                            style = DoTypography.lable,
                            fontWeight = FontWeight(400),
                            color = DoColor.GRAY500,
                        )
                    }
                }
                Column(verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.Top)) {
                    ContactCard(
                        type = "인스타그램",
                        content = {
                            DoTextField(
                                value = writeScreenState.instagramId,
                                modifier = Modifier.background(DoColor.GRAY100),
                                outlineColor = DoColor.GRAY100,
                                placeholder = "인스타그램 사용자 이름을 입력해 주세요",
                            ) {
                                handleIntent(WriteScreenIntent.SetInstagramIdTextState(it))
                            }
                        }
                    )
                    ContactCard(
                        type = "디스코드",
                        content = {
                            DoTextField(
                                value = writeScreenState.disCordId,
                                modifier = Modifier.background(DoColor.GRAY100),
                                outlineColor = DoColor.GRAY100,
                                placeholder = "인스타그램 사용자 이름을 입력해 주세요",
                            ) {
                                handleIntent(WriteScreenIntent.SetDiscordIdTextState(it))
                            }
                        }
                    )
                    ContactCard(
                        type = "카카오톡",
                        content = {
                            DoTextField(
                                value = writeScreenState.kakaotalkId,
                                modifier = Modifier.background(DoColor.GRAY100),
                                outlineColor = DoColor.GRAY100,
                                placeholder = "인스타그램 사용자 이름을 입력해 주세요",
                            ) {
                                handleIntent(WriteScreenIntent.SetKakaotalkIdTextState(it))
                            }
                        }
                    )
                    ContactCard(
                        type = "이메일",
                        content = {
                            DoTextField(
                                value = writeScreenState.emailId,
                                modifier = Modifier.background(DoColor.GRAY100),
                                outlineColor = DoColor.GRAY100,
                                placeholder = "인스타그램 사용자 이름을 입력해 주세요",
                            ) {
                                handleIntent(WriteScreenIntent.SetEmailIdTextState(it))
                            }
                        }
                    )
                }
            }
        }
    }
}


@DoPreview
@Composable
fun WriteScreenPreview() {
    WriteScreen(
        writeScreenState = WriteScreenState.getInitialState()
            .copy(tagListState = immutableSetOf(Tag.CHAT, Tag.WALK)),
        handleIntent = { _ -> },
    )
}
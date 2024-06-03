package com.wanderring.presentation.view.enterInfo.page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.domain.model.enum.Grade
import com.wanderring.presentation.component.DoButton
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.GradeSelectionItem
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.view.enterInfo.component.InfoBox
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EnterSchoolRoute(
    modifier: Modifier = Modifier,
    navigateToBack: () -> Unit,
    navigateToHome: () -> Unit,
) {
    val schoolState = remember { mutableStateOf("") }
    val gradeState = remember { mutableStateOf(Grade.NOTHING) }
    val locationState = remember { mutableStateOf("") }
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()

    HorizontalPager(
        userScrollEnabled = false,
        state = pagerState
    ) { page ->
        when (page) {
            0 -> {
                EnterSchoolPage(
                    modifier = modifier,
                    schoolState = schoolState,
                    navigateToBack = navigateToBack,
                    navigateToGradePage = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    }
                )
            }

            1 -> {
                EnterGradePage(
                    modifier = modifier,
                    gradeState = gradeState,
                    navigateToBack = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(0)
                        }
                    },
                    navigateToLocationPage = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(2)
                        }
                    }
                )
            }

            2 -> {
                EnterLocationPage(
                    modifier = modifier,
                    locationState = locationState,
                    navigateToBack = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    },
                    navigateToHome = navigateToHome
                )
            }
        }
    }
}

@Preview
@Composable
private fun EnterSchoolPagePreview() {
    EnterSchoolPage(
        schoolState = remember { mutableStateOf("") },
        navigateToBack = {},
        navigateToGradePage = {}
    )
}

@Composable
fun EnterSchoolPage(
    modifier: Modifier = Modifier,
    schoolState: MutableState<String>,
    navigateToBack: () -> Unit,
    navigateToGradePage: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(DoColor.WHITE)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 70.dp, bottom = 71.dp)
    ) {
        InfoBox(
            modifier = modifier.fillMaxWidth(),
            title = "학교를 알려주세요",
            content = "현재 재학중인 학교를 입력해주세요",
            navigateToBack = navigateToBack,
            contentComposable = {
                DoTextField(
                    value = schoolState,
                    placeholder = "학교를 알려주세요"
                )
            }
        )
        DoButton(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.0789f),
            text = "완료",
            onClick = navigateToGradePage
        )
    }
}

@Preview
@Composable
private fun EnterGradePagePreview() {
    EnterGradePage(
        gradeState = remember { mutableStateOf(Grade.TWO) },
        navigateToBack = {},
        navigateToLocationPage = {}
    )
}
@Composable
fun EnterGradePage(
    modifier: Modifier = Modifier,
    gradeState: MutableState<Grade>,
    navigateToBack: () -> Unit,
    navigateToLocationPage: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(DoColor.WHITE)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 70.dp, bottom = 71.dp)
    ) {
        InfoBox(
            modifier = modifier.fillMaxWidth(),
            title = "학년을 알려주세요",
            content = "현재 학년을 알려주세요",
            navigateToBack = navigateToBack,
            innerSpacerValue = 0.0334f,
            contentComposable = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        listOf(
                            Grade.ONE,
                            Grade.TWO,
                            Grade.THREE,
                            Grade.FOUR
                        ).forEach { grade ->
                            GradeSelectionItem(
                                grade = grade,
                                isSelected = grade == gradeState.value,
                                onClick = { gradeState.value = grade }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.fillMaxHeight(0.03034f))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        listOf(
                            Grade.FIVE,
                            Grade.SIX
                        ).forEach { grade ->
                            GradeSelectionItem(
                                grade = grade,
                                isSelected = grade == gradeState.value,
                                onClick = { gradeState.value = grade }
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .width(67.dp)
                                .height(40.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .width(67.dp)
                                .height(40.dp)
                        )
                    }
                }
            }
        )
        DoButton(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.0789f),
            text = "완료",
            onClick = navigateToLocationPage
        )
    }
}

@Preview
@Composable
private fun EnterLocationPagePreview() {
    EnterLocationPage(
        locationState = remember { mutableStateOf("") },
        navigateToBack = {},
        navigateToHome = {}
    )
}

@Composable
fun EnterLocationPage(
    modifier: Modifier = Modifier,
    locationState: MutableState<String>,
    navigateToBack: () -> Unit,
    navigateToHome: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(DoColor.WHITE)
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 70.dp, bottom = 71.dp)
    ) {
        InfoBox(
            modifier = modifier.fillMaxWidth(),
            title = "위치를 알려주세요",
            content = "내가 서비스를 이용할 위치를 입력해 주세요",
            navigateToBack = navigateToBack,
            contentComposable = {
                DoTextField(
                    value = locationState,
                    placeholder = "위치를 알려주세요"
                )
            }
        )
        DoButton(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.0789f),
            text = "완료",
            onClick = navigateToHome
        )
    }
}
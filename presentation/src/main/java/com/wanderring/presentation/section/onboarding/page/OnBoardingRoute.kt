package com.wanderring.presentation.section.onboarding.page

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
import androidx.compose.ui.unit.dp
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.presentation.component.DoButton
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.GradeSelectionButton
import com.wanderring.presentation.component.SearchIcon
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.utill.DoPreview
import com.wanderring.presentation.section.onboarding.component.InfoBox
import kotlinx.coroutines.launch
import okhttp3.internal.immutableListOf

@Composable
fun OnBoardingRoute(
    modifier: Modifier = Modifier,
    navigateToBack: () -> Unit,
    navigateToHome: () -> Unit,
) {
    OnBoardingScreen(
        modifier = modifier,
        navigateToBack = navigateToBack,
        navigateToHome = navigateToHome,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen( // OnBoarding 화면들을 하나로 묶은 screen
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
                    schoolState = schoolState.value,
                    onSchoolValueChange = { schoolState.value = it },
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
                    locationState = locationState.value,
                    onLocationValueChange = { locationState.value = it },
                    navigateToBack = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    },
                    navigateToHome = navigateToHome,
                )
            }
        }
    }
}

@DoPreview
@Composable
private fun EnterSchoolPagePreview() {
    EnterSchoolPage(
        schoolState = "",
        navigateToBack = {},
        navigateToGradePage = {},
        onSchoolValueChange = { _ -> }
    )
}

@Composable
fun EnterSchoolPage(
    modifier: Modifier = Modifier,
    schoolState: String,
    onSchoolValueChange: (String) -> Unit,
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
                    placeholder = "학교를 알려주세요",
                    onValueChange = onSchoolValueChange
                )
            }
        )
        DoButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            text = "완료",
            onClick = navigateToGradePage
        )
    }
}

@DoPreview
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
            contentComposable = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        immutableListOf(
                            Grade.ONE,
                            Grade.TWO,
                            Grade.THREE,
                            Grade.FOUR
                        ).forEach { grade ->
                            GradeSelectionButton(
                                modifier = Modifier.padding(
                                    vertical = 8.dp,
                                    horizontal = 16.dp
                                ),
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
                        immutableListOf(
                            Grade.FIVE,
                            Grade.SIX
                        ).forEach { grade ->
                            GradeSelectionButton(
                                modifier = Modifier.padding(
                                    vertical = 8.dp,
                                    horizontal = 16.dp
                                ),
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
                .padding(vertical = 14.dp),
            text = "완료",
            onClick = navigateToLocationPage
        )
    }
}

@DoPreview
@Composable
private fun EnterLocationPagePreview() {
    EnterLocationPage(
        locationState = "",
        navigateToBack = {},
        navigateToHome = {},
        onLocationValueChange = { _ -> },
    )
}

@Composable
fun EnterLocationPage(
    modifier: Modifier = Modifier,
    locationState: String,
    onLocationValueChange: (String) -> Unit,
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
                    placeholder = "위치를 알려주세요",
                    onValueChange = onLocationValueChange,
                    trailingIcon = { SearchIcon() }
                )
            }
        )
        DoButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            text = "완료",
            onClick = navigateToHome
        )
    }
}
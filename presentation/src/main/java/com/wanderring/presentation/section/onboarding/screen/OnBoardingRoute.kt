package com.wanderring.presentation.section.onboarding.screen

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.presentation.component.DoButton
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.GradeSelectionButton
import com.wanderring.presentation.component.SearchIcon
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.section.onboarding.component.InfoBox
import com.wanderring.presentation.section.onboarding.viewModel.OnBoardingScreenIntent
import com.wanderring.presentation.section.onboarding.viewModel.OnBoardingScreenState
import com.wanderring.presentation.section.onboarding.viewModel.OnBoardingSideEffect
import com.wanderring.presentation.section.onboarding.viewModel.OnBoardingViewModel
import com.wanderring.presentation.utill.DoPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import okhttp3.internal.immutableListOf

@Composable
fun OnBoardingRoute(
    modifier: Modifier = Modifier,
    viewModel: OnBoardingViewModel = hiltViewModel(),
    navigateToBack: () -> Unit,
    navigateToHome: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect {
            when (it) {
                OnBoardingSideEffect.NavigateToHome -> navigateToHome()
            }
        }
    }

    OnBoardingScreen(
        modifier = modifier,
        state = state,
        onSchoolChange = { viewModel.handleIntent(OnBoardingScreenIntent.UpdateSchool(it)) },
        onGradeChange = { viewModel.handleIntent(OnBoardingScreenIntent.UpdateGrade(it)) },
        onSpotChange = { viewModel.handleIntent(OnBoardingScreenIntent.UpdateSpot(it)) },
        onSearchTextChange = { viewModel.handleIntent(OnBoardingScreenIntent.UpdateSearchText(it)) },
        searchLocation = { viewModel.handleIntent(OnBoardingScreenIntent.SearchLocation(it)) },
        onSubmit = { viewModel.handleIntent(OnBoardingScreenIntent.PostInfo) },
        navigateToBack = navigateToBack,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    // OnBoarding 화면들을 하나로 묶은 screen
    modifier: Modifier = Modifier,
    state: OnBoardingScreenState,
    onSchoolChange: (String) -> Unit,
    onGradeChange: (Grade) -> Unit,
    onSpotChange: (String) -> Unit,
    onSearchTextChange: (String) -> Unit,
    searchLocation: (String) -> Unit,
    onSubmit: () -> Unit,
    navigateToBack: () -> Unit,
) {
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
                    schoolState = state.school,
                    onSchoolValueChange = onSchoolChange,
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
                    gradeState = state.grade,
                    onGradeValueChange = onGradeChange,
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
                    locationState = state.searchTextState,
                    onSearchTextChange = onSearchTextChange,
                    searchLocation = searchLocation,
                    onSpotChange = onSpotChange,
                    navigateToBack = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(1)
                        }
                    },
                    onSubmit = onSubmit,
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
                    modifier = Modifier.padding(12.dp),
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
        gradeState = Grade.TWO,
        navigateToBack = {},
        navigateToLocationPage = {},
        onGradeValueChange = {}
    )
}

@Composable
fun EnterGradePage(
    modifier: Modifier = Modifier,
    gradeState: Grade,
    onGradeValueChange: (Grade) -> Unit,
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
                                isSelected = grade == gradeState,
                                onClick = { onGradeValueChange(grade) }
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
                                isSelected = grade == gradeState,
                                onClick = { onGradeValueChange(grade) }
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
        onSearchTextChange = { _ -> },
        searchLocation = { _ -> },
        onSubmit = {},
        navigateToBack = {},
        onSpotChange = { }
    )
}

@Composable
fun EnterLocationPage(
    modifier: Modifier = Modifier,
    locationState: String,
    onSearchTextChange: (String) -> Unit,
    searchLocation: (String) -> Unit,
    onSubmit: () -> Unit,
    navigateToBack: () -> Unit,
    onSpotChange: (String) -> Unit,
) {
    LaunchedEffect(locationState) {
        snapshotFlow { locationState }
            .filter { it.isNotEmpty() && it.length >= 2 }
            .debounce(500L)
            .collectLatest { debouncedText ->
                searchLocation(debouncedText)
            }
    }

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
                    modifier = Modifier.padding(12.dp),
                    value = locationState,
                    placeholder = "위치를 알려주세요",
                    onValueChange = onSearchTextChange,
                    trailingIcon = { SearchIcon() }
                )
            }
        )
        DoButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            text = "완료",
            onClick = onSubmit
        )
    }
}
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


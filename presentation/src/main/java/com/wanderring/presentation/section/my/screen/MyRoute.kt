package com.wanderring.presentation.section.my.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.wanderring.domain.model.enumType.Gender
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.domain.model.enumType.Tag
import com.wanderring.presentation.section.home.component.DoWalkListItem
import com.wanderring.presentation.section.home.component.DoWalkListItemState
import com.wanderring.presentation.section.my.viewModel.MyIntent
import com.wanderring.presentation.section.my.viewModel.MySideEffect
import com.wanderring.presentation.section.my.viewModel.MyState
import com.wanderring.presentation.section.my.viewModel.MyViewModel
import com.wanderring.presentation.section.onboarding.component.ProfileCard
import com.wanderring.presentation.utill.BottomSheetType
import com.wanderring.presentation.utill.DoPreview
import kotlinx.collections.immutable.immutableListOf
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRoute(
    modifier: Modifier = Modifier,
    myViewModel: MyViewModel = hiltViewModel(),
    bottomSheetState: ModalBottomSheetState,
    updateBottomSheetType: (BottomSheetType) -> Unit,
) {
    val myState by myViewModel.state.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(lifecycle) {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            myViewModel.sideEffect.collect { effect ->
                when (effect) {
                    is MySideEffect.HideBottomSheet -> {
                        coroutineScope.launch { bottomSheetState.hide() }
                    }

                    is MySideEffect.ShowBottomSheet -> {
                        updateBottomSheetType(
                            BottomSheetType.MyPageOption(
                                cancelOnClick = { myViewModel.handleIntent(MyIntent.HideBottomSheet) },
                                profileChangeOnClick = { /* TODO: 프로필 변경 */ },
                                logoutOnClick = { /* TODO: 로그아웃 로직 연결 */ },
                            )
                        )
                        coroutineScope.launch {
                            bottomSheetState.show()
                        }
                    }
                }
            }
        }
    }


    MyScreen(
        modifier = modifier,
        myState = myState,
        handleIntent = myViewModel::handleIntent
    )
}

@Composable
fun MyScreen(
    modifier: Modifier = Modifier,
    myState: MyState,
    handleIntent: (MyIntent) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        ProfileCard(
            modifier = Modifier.fillMaxWidth(),
            name = myState.name,
            schoolGrade = myState.schoolGrade,
            optionOnClick = { handleIntent(MyIntent.ShowBottomSheet) },
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(18.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth(),
        ) {
            items(myState.reservation) {
                DoWalkListItem(
                    modifier = Modifier.fillMaxWidth(),
                    state = it,
                )
            }
            items(myState.write) {
                DoWalkListItem(
                    modifier = Modifier.fillMaxWidth(),
                    state = it,
                )
            }
        }
    }
}


@DoPreview
@Composable
fun MyScreenPreview() {
    MyScreen(
        myState = MyState(
            name = "김진원",
            schoolGrade = "광주소프트웨어마이스터고등학교 1학년",
            reservation = immutableListOf(
                DoWalkListItemState(
                    genderTag = Gender.NONE,
                    gradeTag = Grade.TWO,
                    recruiterGrade = "광주소프트웨어마이스터고등학교 1학년",
                    recruiterGender = "여자",
                    intro = "같이 산책할 하실 분 구해요",
                    typeTag = immutableListOf(Tag.GO_OUT, Tag.GO_OUT),
                    recruiterName = "한제형",
                )
            ),
            write = immutableListOf(
                DoWalkListItemState(
                    genderTag = Gender.NONE,
                    gradeTag = Grade.TWO,
                    recruiterGrade = "광주소프트웨어마이스터고등학교 1학년",
                    recruiterGender = "여자",
                    intro = "같이 산책할 하실 분 구해요",
                    typeTag = immutableListOf(Tag.GO_OUT, Tag.GO_OUT),
                    recruiterName = "한제형",
                )
            )
        ),
        handleIntent = { _ -> })
}
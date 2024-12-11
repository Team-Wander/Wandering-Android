package com.wanderring.presentation.section.search.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.wanderring.domain.model.enumType.Gender
import com.wanderring.domain.model.enumType.Grade
import com.wanderring.domain.model.enumType.Tag
import com.wanderring.presentation.R
import com.wanderring.presentation.component.CheckIcon
import com.wanderring.presentation.component.ChevronRightIcon
import com.wanderring.presentation.component.DoBasicTopAppBar
import com.wanderring.presentation.component.DoButton
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.ProfileIcon
import com.wanderring.presentation.component.ReportIcon
import com.wanderring.presentation.component.XIcon
import com.wanderring.presentation.component.modifier.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.section.home.component.SeekGrayTag
import com.wanderring.presentation.section.home.component.SeekGreenTag
import com.wanderring.presentation.section.search.viewModel.Reason
import com.wanderring.presentation.section.search.viewModel.WriteWatchIntent
import com.wanderring.presentation.section.search.viewModel.WriteWatchScreenState
import com.wanderring.presentation.section.search.viewModel.WriteWatchSideEffect
import com.wanderring.presentation.section.search.viewModel.WriteWatchViewModel
import com.wanderring.presentation.utill.DoPreview
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WriteWatchRoute(
    modifier: Modifier = Modifier,
    viewModel: WriteWatchViewModel = hiltViewModel(),
    bottomSheetState: ModalBottomSheetState,
    updateBottomSheetType: (BottomSheetType) -> Unit,
    navigateToBackStack: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(lifecycle) {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.sideEffect.collect {
                when (it) {
                    WriteWatchSideEffect.NavigateToBackStack -> TODO()
                    WriteWatchSideEffect.ShowBottomSheet -> {
                        coroutineScope.launch { sheetState.hide() }
                    }

                    WriteWatchSideEffect.HideBottomSheet -> {
                        coroutineScope.launch { sheetState.show() }
                    }
                }
            }
        }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    WriteWatchScreen(
        modifier = modifier,
        state = state,
        sheetState = sheetState,
        handleIntent = viewModel::handleIntent,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WriteWatchScreen(
    modifier: Modifier = Modifier,
    state: WriteWatchScreenState,
    sheetState: ModalBottomSheetState,
    handleIntent: (WriteWatchIntent) -> Unit,
) {
    val reportReason = remember {
        mutableStateOf("")
    }
    val checkBoxStateList = remember {
        mutableIntStateOf(0)
    }
    ModalBottomSheetLayout(
        modifier = Modifier.fillMaxSize(),
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        sheetContent = {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Bottom),
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .background(
                        color = DoColor.WHITE,
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
                    .padding(horizontal = 30.dp, vertical = 20.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "신고사유",
                        style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 30.sp,
                            fontFamily = FontFamily(Font(R.font.pretendard)),
                            fontWeight = FontWeight(700),
                            color = DoColor.Black,
                        )
                    )
                    XIcon(
                        modifier = Modifier.clickableSingle {
                            handleIntent(WriteWatchIntent.HideBottomSheet)
                        }
                    )
                }
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                            horizontalAlignment = Alignment.Start,
                        ) {
                            CheckBoxComponent(
                                text = Reason.entries[1].description,
                                isSelected = checkBoxStateList.intValue == 1,
                                onClick = {
                                    checkBoxStateList.intValue =
                                        if (checkBoxStateList.intValue == 1) 0 else 1
                                },
                            )
                            CheckBoxComponent(
                                text = Reason.entries[3].description,
                                isSelected = checkBoxStateList.intValue == 3,
                                onClick = {
                                    checkBoxStateList.intValue =
                                        if (checkBoxStateList.intValue == 3) 0 else 3
                                },
                            )
                            CheckBoxComponent(
                                text = Reason.entries[5].description,
                                isSelected = checkBoxStateList.intValue == 5,
                                onClick = {
                                    checkBoxStateList.intValue =
                                        if (checkBoxStateList.intValue == 5) 0 else 5
                                },
                            )
                            CheckBoxComponent(
                                text = Reason.entries[6].description,
                                isSelected = checkBoxStateList.intValue == 6,
                                onClick = {
                                    checkBoxStateList.intValue =
                                        if (checkBoxStateList.intValue == 6) 0 else 6
                                },
                            )
                        }
                        Column(
                            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                            horizontalAlignment = Alignment.Start,
                        ) {
                            CheckBoxComponent(
                                text = Reason.entries[2].description,
                                isSelected = checkBoxStateList.intValue == 2,
                                onClick = {
                                    checkBoxStateList.intValue =
                                        if (checkBoxStateList.intValue == 2) 0 else 2
                                },
                            )
                            CheckBoxComponent(
                                text = Reason.entries[4].description,
                                isSelected = checkBoxStateList.intValue == 4,
                                onClick = {
                                    checkBoxStateList.intValue =
                                        if (checkBoxStateList.intValue == 4) 0 else 4
                                },
                            )
                        }
                    }
                    if (checkBoxStateList.intValue == 6) {
                        Spacer(modifier = Modifier.height(24.dp))
                        DoTextField(
                            value = reportReason.value,
                            onValueChange = { reportReason.value = it },
                            modifier = Modifier
                                .background(
                                    color = DoColor.GRAY200,
                                    shape = RoundedCornerShape(size = 8.dp),
                                )
                                .padding(
                                    vertical = 12.dp,
                                    horizontal = 16.dp,
                                ),
                            useOutLine = false,
                            placeholder = "신고 사유를 적어주세요",
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    DoButton(
                        modifier = Modifier.padding(
                            horizontal = 20.dp,
                            vertical = 10.dp,
                        ),
                        text = "취소",
                        color = DoColor.RED,
                        onClick = {},
                    )
                    DoButton(
                        modifier = Modifier.padding(
                            horizontal = 20.dp,
                            vertical = 10.dp,
                        ),
                        text = "확인",
                        color = DoColor.MAIN,
                        onClick = {},

                        )
                }
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(vertical = 22.dp, horizontal = 16.dp),
        ) {
            DoBasicTopAppBar(
                middleText = "글 보기",
                startIcon = {
                    ChevronRightIcon(modifier = Modifier.clickable {
                        handleIntent(WriteWatchIntent.NavigateToBackStack)
                    })
                })
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize(),
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(22.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ) {
                    with(state) {
                        ProfileCard(
                            author = author,
                            authorSchool = authorSchool,
                            authorGrade = authorGrade,
                            authorGender = authorGender,
                            authorProfile = authorProfile,
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(14.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            text = state.title,
                            style = DoTypography.m2,
                            fontWeight = FontWeight(600),
                            color = DoColor.Black,
                        )
                        Text(
                            text = state.content,
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 25.2.sp,
                                fontFamily = FontFamily(Font(R.font.pretendard)),
                                fontWeight = FontWeight(400),
                                color = DoColor.GRAY900,
                            )
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        state.contact.forEach {
                            Text(
                                text = it,
                                style = DoTypography.m3,
                                fontWeight = FontWeight(400),
                                color = DoColor.Black,
                            )
                        }
                    }
                    if (state.gender.isNotEmpty()) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                            verticalAlignment = Alignment.Top,
                        ) {
                            state.gender.forEach {
                                SeekGreenTag(text = it.description)
                            }
                        }
                    }
                    if (state.grade.isNotEmpty()) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                            verticalAlignment = Alignment.Top,
                        ) {
                            state.grade.forEach {
                                SeekGrayTag(text = it.descriptionWithHash)
                            }
                        }
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(
                            text = state.date,
                            style = DoTypography.lable,
                            fontWeight = FontWeight(400),
                            color = DoColor.GRAY400,
                        )
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    12.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.Top,
                            ) {
                                state.tag.forEach {
                                    SeekGrayTag(text = it.descriptionWithHash)
                                }
                            }
                            ReportIcon(
                                modifier = Modifier.clickableSingle {
                                    handleIntent(WriteWatchIntent.ShowBottomSheet)
                                }
                            )
                        }
                    }
                }
                DoButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 14.dp),
                    text = "완료",
                    onClick = {
                        handleIntent(WriteWatchIntent.NavigateToBackStack)
                    },
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@DoPreview
@Composable
fun WriteWatchScreenPreview() {
    WriteWatchScreen(
        state = WriteWatchScreenState(
            id = 12L, author = "한재형",
            authorSchool = "광주소프트웨어마이스터고등학교",
            authorGrade = Grade.ONE,
            authorGender = Gender.WOMEN,
            authorProfile = "",
            content = "토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람토요일에 호수공원 산책할 사람",
            title = "같이 산책 하실 분 구해요",
            contact = listOf(
                "카톡 : wjdtjffl55",
                "디스코드 : hye_2417",
                "인스타그램 : hye_2417",
            ),
            date = "2023년 5월 1일",
            gender = listOf(
                Gender.WOMEN,
                Gender.MAN
            ),
            grade = listOf(),
            maximum = 12,
            spot = "",
            tag = listOf(Tag.GO_OUT, Tag.WALK)
        ),
        handleIntent = {},
        sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded)
    )
}

@Composable
private fun ProfileCard(
    modifier: Modifier = Modifier,
    author: String,
    authorSchool: String,
    authorGrade: Grade,
    authorGender: Gender,
    authorProfile: String,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.background(DoColor.WHITE)
    ) {
        ProfileIcon(
            modifier = Modifier.size(50.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = author,
                style = DoTypography.lable,
                fontWeight = FontWeight(600),
                color = DoColor.GRAY600,
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "$authorSchool ${authorGrade.description}",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard)),
                        fontWeight = FontWeight(400),
                        color = DoColor.GRAY500,
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.ellipse),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
                Text(
                    text = authorGender.description,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard)),
                        fontWeight = FontWeight(400),
                        color = DoColor.GRAY500,
                    )
                )
            }
        }
    }
}

@DoPreview
@Composable
fun ProfileCardPreview() {
    ProfileCard(
        author = "한재형",
        authorSchool = "광주소프트웨어마이스터고등학교",
        authorGrade = Grade.ONE,
        authorGender = Gender.WOMEN,
        authorProfile = "",
    )
}

@Composable
fun CheckBoxComponent(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickableSingle(onClick = onClick),
    ) {
        CheckIcon(isSelected = isSelected)
        Text(
            text = text,
            style = DoTypography.m3,
            fontWeight = FontWeight(400),
            color = DoColor.Black,
            textAlign = TextAlign.Right,
        )
    }
}

@DoPreview
@Composable
fun CheckBoxComponentPreveiw() {
    CheckBoxComponent(
        text = "기타",
        isSelected = false,
        onClick = {},
    )
}

@Composable
fun ReportBottomSheet(
    modifier: Modifier = Modifier,
    checkBoxState: Int,
    reportReason: String,
    updateCheckBoxState: (Int) -> Unit,
    updateReportReason: (String) -> Unit,
    onConfirmClick: () -> Unit,
    onCancelClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Bottom),
        horizontalAlignment = Alignment.End,
        modifier = modifier
            .background(
                color = DoColor.WHITE,
                shape = RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .padding(horizontal = 30.dp, vertical = 20.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "신고사유",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 30.sp,
                    fontFamily = FontFamily(Font(R.font.pretendard)),
                    fontWeight = FontWeight(700),
                    color = DoColor.Black,
                )
            )
            XIcon(
                modifier = Modifier.clickableSingle(onClick = onCancelClick)
            )
        }
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ) {
                    CheckBoxComponent(
                        text = Reason.entries[1].description,
                        isSelected = checkBoxState == 1,
                        onClick = {
                            updateCheckBoxState(if (checkBoxState == 1) 0 else 1)
                        },
                    )
                    CheckBoxComponent(
                        text = Reason.entries[3].description,
                        isSelected = checkBoxState == 3,
                        onClick = {
                            updateCheckBoxState(if (checkBoxState == 3) 0 else 3)
                        },
                    )
                    CheckBoxComponent(
                        text = Reason.entries[5].description,
                        isSelected = checkBoxState == 5,
                        onClick = {
                            updateCheckBoxState(if (checkBoxState == 5) 0 else 5)
                        },
                    )
                    CheckBoxComponent(
                        text = Reason.entries[6].description,
                        isSelected = checkBoxState == 6,
                        onClick = {
                            updateCheckBoxState(if (checkBoxState == 6) 0 else 6)
                        },
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ) {
                    CheckBoxComponent(
                        text = Reason.entries[2].description,
                        isSelected = checkBoxState == 2,
                        onClick = {
                            updateCheckBoxState(if (checkBoxState == 2) 0 else 2)
                        },
                    )
                    CheckBoxComponent(
                        text = Reason.entries[4].description,
                        isSelected = checkBoxState == 4,
                        onClick = {
                            updateCheckBoxState(if (checkBoxState == 4) 0 else 4)
                        },
                    )
                }
            }
            if (checkBoxState == 6) {
                Spacer(modifier = Modifier.height(24.dp))
                DoTextField(
                    value = reportReason,
                    onValueChange = updateReportReason,
                    modifier = Modifier
                        .background(
                            color = DoColor.GRAY200,
                            shape = RoundedCornerShape(size = 8.dp),
                        )
                        .padding(
                            vertical = 12.dp,
                            horizontal = 16.dp,
                        ),
                    useOutLine = false,
                    placeholder = "신고 사유를 적어주세요",
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.End),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            DoButton(
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 10.dp,
                ),
                text = "취소",
                color = DoColor.RED,
                onClick = onCancelClick,
            )
            DoButton(
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 10.dp,
                ),
                text = "확인",
                color = DoColor.MAIN,
                onClick = onConfirmClick,
            )
        }
    }
}
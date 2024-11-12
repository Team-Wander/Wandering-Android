package com.wanderring.presentation.section.search.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wanderring.presentation.R
import com.wanderring.presentation.component.ChevronRightIcon
import com.wanderring.presentation.component.DoBasicTopAppBar
import com.wanderring.presentation.component.DoButton
import com.wanderring.presentation.component.DoTextField
import com.wanderring.presentation.component.OptionIcon
import com.wanderring.presentation.component.ProfileIcon
import com.wanderring.presentation.component.ReportIcon
import com.wanderring.presentation.component.modifier.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor
import com.wanderring.presentation.component.theme.DoTypography
import com.wanderring.presentation.section.home.component.SeekGreenTag
import com.wanderring.presentation.section.search.viewModel.WriteWatchScreenState
import com.wanderring.presentation.section.search.viewModel.WriteWatchSideEffect
import com.wanderring.presentation.section.search.viewModel.WriteWatchViewModel
import com.wanderring.presentation.utill.DoPreview
import kotlinx.coroutines.launch


@Composable
fun WriteWatchRoute(
    modifier: Modifier = Modifier,
    viewModel: WriteWatchViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect {
            when (it) {
                WriteWatchSideEffect.NavigateToBackStack -> TODO()
            }
        }
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    WriteWatchScreen(modifier = modifier, state = state)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WriteWatchScreen(
    modifier: Modifier = Modifier,
    state: WriteWatchScreenState,
) {
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
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
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        // Child views.
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        // Child views.
                    }
                }
                if(TODO("기타 클릭시")){

                }
                Spacer(modifier = Modifier.height(4.dp))
                DoTextField(value = "") {

                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.End),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    DoButton(text = "취소", color = DoColor.RED, onClick = {})
                    DoButton(text = "확인", color = DoColor.MAIN, onClick = {})
                }
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(vertical = 22.dp, horizontal = 16.dp),
        ) {
            DoBasicTopAppBar(startIcon = { ChevronRightIcon(modifier = Modifier.clickable { }) })
            Column(
                verticalArrangement = Arrangement.spacedBy(22.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {
                with(state) {
                    ProfileCard(
                        author = author,
                        authorSchool = authorSchool,
                        authorGrade = authorGrade.description,
                        authorGender = authorGender.description,
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
                if (state.grade.isNotEmpty()) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                    ) {
                        state.grade.forEach {
                            SeekGreenTag(text = it.description)
                        }
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(
                        text = state.date,
                        style = DoTypography.lable,
                        fontWeight = FontWeight(400),
                        color = DoColor.GRAY400,
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(178.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                            verticalAlignment = Alignment.Top,
                        ) {
                            state.tag.forEach {
                                SeekGreenTag(text = it.descriptionWithHash)
                            }
                        }
                        ReportIcon(
                            modifier = Modifier.clickableSingle {
                                coroutineScope.launch { sheetState.show() }
                            }
                        )
                    }
                }
            }
        }
    }
}

@DoPreview
@Composable
fun WriteWatchScreenPreview() {
    WriteWatchScreen(state = WriteWatchScreenState.getInitialState())
}

@Composable
private fun ProfileCard(
    modifier: Modifier = Modifier,
    author: String,
    authorSchool: String,
    authorGrade: String,
    authorGender: String,
    authorProfile: String,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.background(DoColor.WHITE)
    ) {
        ProfileIcon()
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
                    text = "$authorSchool $authorGrade",
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
                    text = authorGender,
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
        Spacer(modifier = Modifier)
    }
}

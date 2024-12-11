package com.wanderring.presentation.utill

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.wanderring.presentation.section.my.component.AlamBottomSheetContent
import com.wanderring.presentation.section.search.screen.ReportBottomSheet

sealed class BottomSheetType {
    @Composable
    abstract fun content()

    data object None : BottomSheetType() {
        @Composable
        override fun content() {
        }
    }

    data class HomeTagFilter(val modifier: Modifier = Modifier) : BottomSheetType() {
        @Composable
        override fun content() {
        }
    }

    data class HomeLocationFilter(val modifier: Modifier = Modifier) : BottomSheetType() {
        @Composable
        override fun content() {
        }
    }

    data class WriteWatchReport(
        val modifier: Modifier = Modifier,
        val checkBoxState: Int,
        val reportReason: String,
        val updateCheckBoxState: (Int) -> Unit,
        val updateReportReason: (String) -> Unit,
        val onConfirmClick: () -> Unit,
        val onCancelClick: () -> Unit,
    ) : BottomSheetType() {
        @Composable
        override fun content() {
            ReportBottomSheet(
                checkBoxState = checkBoxState,
                reportReason = reportReason,
                updateCheckBoxState = updateCheckBoxState,
                updateReportReason = updateReportReason,
                onConfirmClick = onConfirmClick,
                onCancelClick = onCancelClick
            )
        }
    }

    data class MyWriteWatch(val modifier: Modifier = Modifier) : BottomSheetType() {
        @Composable
        override fun content() {
        }
    }

    data class MyPageOption(
        val modifier: Modifier = Modifier,
        val profileChangeOnClick: () -> Unit,
        val logoutOnClick: () -> Unit,
        val cancelOnClick: () -> Unit,
    ) : BottomSheetType() {
        @Composable
        override fun content() {
            AlamBottomSheetContent(
                modifier = modifier,
                profileChangeOnClick = profileChangeOnClick,
                logoutOnClick = logoutOnClick,
                cancelOnClick = cancelOnClick,
            )
        }
    }
}

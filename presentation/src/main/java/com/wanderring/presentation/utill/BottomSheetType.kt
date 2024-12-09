package com.wanderring.presentation.utill

import androidx.compose.runtime.Composable
import com.wanderring.presentation.section.my.component.AlamBottomSheetContent

enum class BottomSheetType(val bottomSheet: @Composable () -> Unit) {
    None(bottomSheet = {}),
    HomeTagFilter(bottomSheet = {}),
    HomeLocationFilter(bottomSheet = {}),
    WriteWatchReport(bottomSheet = {}),
    MyWriteWatch(bottomSheet = {}),
    MyPageOption(bottomSheet = {
        AlamBottomSheetContent()
    }),
}
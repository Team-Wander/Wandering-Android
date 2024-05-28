package com.wanderring.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.component.clickableSingle.clickableSingle
import com.wanderring.presentation.component.theme.DoColor

@Composable
fun DoTopBar(
    modifier: Modifier = Modifier,
    logoOnClick: () -> Unit,
    searchOnClick: () -> Unit,
    bellOnClick: () -> Unit,
    profileOnClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(DoColor.WHITE)
            .padding(10.dp)
    ) {
        LogoImage(modifier = Modifier.clickableSingle { logoOnClick() })
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(104.dp)
        ) {
            SearchIcon(modifier = Modifier.clickableSingle { searchOnClick() })
            BellIcon(modifier = Modifier.clickableSingle { bellOnClick() })
            ProfileIcon(modifier = Modifier.clickableSingle { profileOnClick() })
        }
    }
}

@Preview
@Composable
private fun Preview() {
    DoTopBar(
        modifier = Modifier.fillMaxWidth(),
        logoOnClick = {},
        searchOnClick = {},
        bellOnClick = {},
        profileOnClick = {},
    )
}
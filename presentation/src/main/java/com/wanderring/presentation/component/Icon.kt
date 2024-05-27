package com.wanderring.presentation.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.R

@Composable
fun BellIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.bell),
        contentDescription = "MindWay Main Icon",
        modifier = modifier.size(24.dp),
        tint = tint
    )
}

@Composable
fun FilterIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.filter),
        contentDescription = "MindWay Main Icon",
        modifier = modifier.size(24.dp),
        tint = tint
    )
}

@Composable
fun PluginIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.plus),
        contentDescription = "MindWay Main Icon",
        modifier = modifier.size(24.dp),
        tint = tint
    )
}

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "MindWay Main Icon",
        modifier = modifier.size(24.dp),
        tint = tint
    )
}

@Composable
fun ReportIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.report),
        contentDescription = "MindWay Main Icon",
        modifier = modifier.size(24.dp),
        tint = tint
    )
}


@Composable
fun SearchIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.search),
        contentDescription = "MindWay Main Icon",
        modifier = modifier.size(24.dp),
        tint = tint
    )
}

@Composable
fun XIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.x),
        contentDescription = "MindWay Main Icon",
        modifier = modifier.size(24.dp),
        tint = tint
    )
}
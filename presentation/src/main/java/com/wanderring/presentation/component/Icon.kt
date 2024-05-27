package com.wanderring.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.wanderring.presentation.R

@Composable
fun FloatButton(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Box(contentAlignment = Alignment.Center) {
        Icon(
            painter = painterResource(id = R.drawable.green_circle),
            contentDescription = null,
            modifier = modifier.size(60.dp),
            tint = tint
        )
        Icon(
            painter = painterResource(id = R.drawable.plus),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = tint
        )
    }
}

@Composable
fun BellIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.bell),
        contentDescription = null,
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
        contentDescription = null,
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
        contentDescription = null,
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
        contentDescription = null,
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
        contentDescription = null,
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
        contentDescription = null,
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
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = tint
    )
}
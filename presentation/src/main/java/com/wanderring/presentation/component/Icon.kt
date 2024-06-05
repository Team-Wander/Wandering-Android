package com.wanderring.presentation.component

import android.net.wifi.hotspot2.pps.HomeSp
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
import com.wanderring.presentation.component.theme.DoColor

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
fun LogoImage(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        modifier = modifier,
        tint = tint
    )
}


@Composable
fun CheckIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    isSelected: Boolean,
) {
    if (isSelected) {
        Icon(
            painter = painterResource(id = R.drawable.check),
            contentDescription = null,
            modifier = modifier.size(24.dp),
            tint = tint
        )
    } else {
        Icon(
            painter = painterResource(id = R.drawable.check),
            contentDescription = null,
            modifier = modifier.size(24.dp),
            tint = tint
        )
    }
}

@Composable
fun MapPinIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.map_pin),
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = tint
    )
}

@Composable
fun ChevronRightIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.chevron_right),
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = tint
    )
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
    isSelected: Boolean = false,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = if(isSelected) DoColor.MAIN else tint
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
    isSelected: Boolean = false,
    tint: Color = DoColor.GRAY400,
) {
    Icon(
        painter = painterResource(id = R.drawable.search),
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = if(isSelected) DoColor.MAIN else tint
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

@Composable
fun HomeIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    tint: Color = DoColor.GRAY400,
) {
    Icon(
        painter = painterResource(id = R.drawable.home),
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = if(isSelected) DoColor.MAIN else tint
    )
}

@Composable
fun TimeScheduleIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.timeschedule),
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = if(isSelected) DoColor.MAIN else tint
    )
}

@Composable
fun MyIcon(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    tint: Color = DoColor.GRAY400,
) {
    Icon(
        painter = painterResource(id = R.drawable.my),
        contentDescription = null,
        modifier = modifier.size(24.dp),
        tint = if(isSelected) DoColor.MAIN else tint
    )
}
package com.wanderring.presentation.component.modifier.clickableSingle

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed


// Jetpack Compose에서 사용할 수 있는 Modifier 확장 함수로, 연속된 클릭을 방지 + 클릭 이벤트 삭제
@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.clickableSingle(
    enabled: Boolean = true, // 클릭 가능 여부
    onClick: () -> Unit, // 클릭 시 실행할 이벤트
) = composed {
    // 이벤트 중복 처리를 방지하는 MultipleEventsCutter 객체 생성
    val multipleEventsCutter = remember { MultipleEventsCutter.get() }
    Modifier.clickable(
        enabled = enabled, // 클릭 가능 여부 전달
        onClick = { multipleEventsCutter.processEvent { onClick() } }, // 이벤트 실행 시 MultipleEventsCutter를 통해 처리
        indication = null, // 클릭 시 나타나는 효과를 제거
        interactionSource = remember { MutableInteractionSource() } // 클릭 이벤트를 없에기위해 인터랙션 소스 제공
    )
}
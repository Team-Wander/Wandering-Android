package com.wanderring.presentation.component.clickableSingle

// 클릭 이벤트가 짧은 시간 안에 여러 번 발생하는 것을 방지하기 위한 인터페이스
internal interface MultipleEventsCutter {
    // 이벤트를 처리하는 함수. 일정 시간이 지난 후에만 이벤트를 실행하도록 한다.
    fun processEvent(event: () -> Unit)

    companion object
}

// MultipleEventsCutter 인터페이스의 구현체를 반환하는 함수
internal fun MultipleEventsCutter.Companion.get(): MultipleEventsCutter = MultipleEventsCutterImpl()

// MultipleEventsCutter 인터페이스의 실제 구현 클래스
private class MultipleEventsCutterImpl : MultipleEventsCutter {
    // 마지막 이벤트가 발생한 시간을 기록하는 변수
    private var lastEventTimeMs: Long = 0

    // 클릭 이벤트가 400ms 간격으로만 실행되도록 제한하는 함수
    override fun processEvent(event: () -> Unit) {
        val now = System.currentTimeMillis()
        // 마지막 이벤트로부터 400ms 이상 경과했을 때만 이벤트를 실행
        if (now - lastEventTimeMs >= 400L) {
            event.invoke() // 이벤트 실행
            lastEventTimeMs = now // 마지막 이벤트 시간을 갱신
        }
    }
}
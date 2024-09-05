import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * 본 DoViewModel 클래스 는 mvi 를 구현 하기 위해
 * @param INTENT,
 * @param STATE,
 * @param EFFECT
 * 들의 관리를 추상화 한 추상 클래스 이다.
 *
 * Screen 에선 EFFECT 와 STATE 만 알 수 있다
 *
 * 예시 인텐트
 * ```
 * sealed class ExampleIntent {
 *     object LoadData : ExampleIntent() // 데이터를 로드하는 Intent
 *     object ClearData : ExampleIntent() // 데이터를 지우는 Intent
 * }
 * ```
 * 인탠트가 특정 함수를 실행 시킨다
 *
 * 예시 State
 * ```
 * // 상태를 나타내는 데이터 클래스
 * data class ExampleState(
 *     val data: String = "",  // 로드된 데이터
 *     val isLoading: Boolean = false  // 데이터 로드 중인지 여부
 * )
 * ```
 * 실행된 함수가 State 를 변경 시킨다
 *
 * 예시 사이드 이펙트
 * ```
 * sealed class ExampleSideEffect {
 *     object ShowLoadingError : ExampleSideEffect() // 로드 에러 메시지 출력
 *     object NavigateToDetails : ExampleSideEffect() // 디테일 화면으로 이동
 * }
 * ```
 * 실행된 함수가 사이드 이펙트를 만든다
 */

abstract class DoViewModel<INTENT : Any, STATE : Any, EFFECT : Any> : ViewModel() {
    // 상태를 관리하는 MutableStateFlow
    private val _state: MutableStateFlow<STATE> = MutableStateFlow(initialState())
    val state: StateFlow<STATE> = _state.asStateFlow()

    // SideEffect를 관리하는 MutableSharedFlow
    private val _sideEffect: MutableSharedFlow<EFFECT> = MutableSharedFlow()
    val sideEffect = _sideEffect.asSharedFlow()

    abstract fun initialState(): STATE

    // Intent 처리: 추상 메서드로 정의
    abstract fun handleIntent(intent: INTENT)

    // 상태를 업데이트하는 함수
    fun setState(reducer: STATE.() -> STATE) {
        _state.value = _state.value.reducer()
    }

    /**
     *  STATE 값을 인자로 주고 STATE 형식을 반환 한다
     *
     * 예시
     * ```
     * setState { state -> state.copy(value = state.value + 1) }
     * ```
     */

// 비동기적으로 SideEffect를 발생시키는 함수
    fun postSideEffect(effect: EFFECT) =
        viewModelScope.launch {
            _sideEffect.emit(effect)
        }
}
/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [BaseViewModel.kt] created by Ji Sungbin
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<EVENT : BaseEvent> : ViewModel() {
    private val _eventFlow = MutableSharedFlow<EVENT>()
    val eventFlow = _eventFlow.asSharedFlow()

    open fun event(event: EVENT) = viewModelScope.launch {
        _eventFlow.emit(event)
    }
}

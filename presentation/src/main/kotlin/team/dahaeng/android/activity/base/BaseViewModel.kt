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
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    private val _exceptionChannel = Channel<Throwable>()
    val exceptionFlow = _exceptionChannel.receiveAsFlow()

    open fun emitException(exception: Throwable) = viewModelScope.launch {
        _exceptionChannel.send(exception)
    }
}

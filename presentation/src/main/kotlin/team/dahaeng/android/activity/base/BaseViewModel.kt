package team.dahaeng.android.activity.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<EVENT : BaseEvent> : ViewModel() {
    private val _eventFlow = MutableSharedFlow<EVENT>()
    val eventFlow = _eventFlow.asSharedFlow()

    open fun emitEvent(event: EVENT) = viewModelScope.launch {
        _eventFlow.tryEmit(event)
    }
}

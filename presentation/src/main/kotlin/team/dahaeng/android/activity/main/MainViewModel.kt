/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [MainViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:12
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.domain.schedule.model.Schedule
import team.dahaeng.android.domain.schedule.model.SimpleAddress
import team.dahaeng.android.domain.schedule.usecase.schedule.ImportAllSchedulesUseCase

@HiltViewModel
class MainViewModel @Inject constructor(
    private val importAllSchedulesUseCase: ImportAllSchedulesUseCase,
) : BaseViewModel() {

    private val _schedules = MutableStateFlow<List<Schedule>>(emptyList())
    val schedules = _schedules.asStateFlow()

    var lastAddress: SimpleAddress? = null

    fun importAllSchedules(address: SimpleAddress) = viewModelScope.launch {
        importAllSchedulesUseCase(address = address)
            .onSuccess { schedules ->
                if (schedules.isNotEmpty()) {
                    _schedules.emit(schedules)
                }
            }
            .onFailure { exception ->
                emitException(exception)
            }
    }
}

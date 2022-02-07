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
import io.github.jisungbin.logeukes.LoggerType
import io.github.jisungbin.logeukes.logeukes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.domain.community.usecase.ImportPostsUseCase
import team.dahaeng.android.domain.schedule.model.Schedule
import team.dahaeng.android.domain.schedule.usecase.ImportScheduleUseCase
import team.dahaeng.android.domain.schedule.usecase.UploadScheduleUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val importPostsUseCase: ImportPostsUseCase,
    private val importScheduleUseCase: ImportScheduleUseCase,
    private val uploadScheduleUseCase: UploadScheduleUseCase,
) : BaseViewModel() {

    private val _posts = MutableStateFlow(DataStore.posts)
    val posts = _posts.asStateFlow()

    private val _schedules = MutableStateFlow(DataStore.schedules)
    val schedules = _schedules.asStateFlow()

    var lastLocate = ""

    fun reimportPosts() = viewModelScope.launch {
        importPostsUseCase()
            .onSuccess { posts ->
                DataStore.updatePosts(posts)
                _posts.emit(posts)
            }
            .onFailure { exception ->
                logeukes(type = LoggerType.E) { exception }
                emitException(exception)
            }
    }

    fun importSchedule(ownerId: Long) = viewModelScope.launch {
        importScheduleUseCase(ownerId)
            .onSuccess { scheduleList ->
                DataStore.updateSchedules(scheduleList)
                _schedules.emit(scheduleList)
            }
            .onFailure { exception ->
                logeukes(type = LoggerType.E) { exception }
                emitException(exception)
            }
    }

    fun addSchedule(schedule: Schedule) = viewModelScope.launch {
        uploadScheduleUseCase(schedule)
            .onFailure { exception ->
                logeukes(type = LoggerType.E) { exception }
                emitException(exception)
            }
    }
}

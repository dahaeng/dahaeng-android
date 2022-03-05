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
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.domain.schedule.model.Schedule
import team.dahaeng.android.domain.schedule.usecase.post.ImportAllPostsUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.ChangeScheduleUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.DeleteScheduleUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.ImportSchedulesFromUserUseCase
import team.dahaeng.android.domain.schedule.usecase.schedule.UploadScheduleUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val importAllPostsUseCase: ImportAllPostsUseCase,
    private val importSchedulesFromUserUseCase: ImportSchedulesFromUserUseCase,
    private val uploadScheduleUseCase: UploadScheduleUseCase,
    private val deleteScheduleUseCase: DeleteScheduleUseCase,
    private val changeScheduleUseCase: ChangeScheduleUseCase,
) : BaseViewModel() {

    private val _posts = MutableStateFlow(DataStore.posts)
    val posts = _posts.asStateFlow()

    private val _schedules = MutableStateFlow(DataStore.schedules)
    val schedules = _schedules.asStateFlow()

    var lastLocate = ""

    fun reimportPosts() = viewModelScope.launch {
        importAllPostsUseCase()
            .onSuccess { posts ->
                if (posts.isNotEmpty()) {
                    DataStore.updatePosts(posts)
                    _posts.emit(posts)
                }
            }
            .onFailure { exception ->
                logeukes(type = LoggerType.E) { exception }
                emitException(exception)
            }
    }

    fun importSchedule(ownerId: Long) = viewModelScope.launch {
        importSchedulesFromUserUseCase(ownerId)
            .onSuccess { scheduleList ->
                if (scheduleList.isNotEmpty()) {
                    DataStore.updateSchedules(scheduleList)
                    _schedules.emit(scheduleList)
                }
            }
            .onFailure { exception ->
                logeukes(type = LoggerType.E) { exception }
                emitException(exception)
            }
    }

    fun addSchedule(schedule: Schedule) = viewModelScope.launch {
        uploadScheduleUseCase(schedule)
            .onSuccess { isSuccess ->
                if (isSuccess) {
                    _schedules.update { it + schedule }
                }
            }
            .onFailure { exception ->
                logeukes(type = LoggerType.E) { exception }
                emitException(exception)
            }
    }

    fun changeSchedule(changeSchedule: Schedule) =
        viewModelScope.launch {
            changeScheduleUseCase(changeSchedule)
                .onSuccess { isSuccess ->
                    if (isSuccess) {
                        logeukes { "update!" }
                    }
                }
                .onFailure { exception ->
                    logeukes(type = LoggerType.E) { exception }
                    emitException(exception)
                }
        }

    fun deleteSchedule(schedule: Schedule) = viewModelScope.launch {
        deleteScheduleUseCase(schedule)
            .onSuccess { isSuccess ->
                if (isSuccess) {
                    _schedules.update { it - schedule }
                }
            }
            .onFailure { exception ->
                logeukes(type = LoggerType.E) { exception }
                emitException(exception)
            }
    }
}

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
import team.dahaeng.android.domain.community.model.schedule.Schedule
import team.dahaeng.android.domain.community.model.tmap.FullTextGeocodingResult
import team.dahaeng.android.domain.community.usecase.post.ImportPostsUseCase
import team.dahaeng.android.domain.community.usecase.schedule.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val importPostsUseCase: ImportPostsUseCase,
    private val importScheduleUseCase: ImportScheduleUseCase,
    private val uploadScheduleUseCase: UploadScheduleUseCase,
    private val deleteScheduleUseCase: DeleteScheduleUseCase,
    private val changeScheduleUseCase: ChangeScheduleUseCase,
    private val tourAPIUseCase: TourAPIUseCase,
    private val tMapFullTextGeocodingUseCase: TMapFullTextGeocodingUseCase,
    private val tMapReverseGeocodingUseCase: TMapReverseGeocodingUseCase,
) : BaseViewModel() {

    private val _posts = MutableStateFlow(DataStore.posts)
    val posts = _posts.asStateFlow()

    private val _schedules = MutableStateFlow(DataStore.schedules)
    val schedules = _schedules.asStateFlow()

    var lastLocate = ""

    fun getTourData() = viewModelScope.launch {
        tourAPIUseCase().onSuccess {

        }.onFailure { exception ->
            logeukes(type = LoggerType.E) { exception }
            emitException(exception)
        }
    }


    fun getTmapFullTextGeocodingData(address : String) = viewModelScope.launch {
        tMapFullTextGeocodingUseCase(address).onSuccess { fullTextGeocodingResult ->
            logeukes { fullTextGeocodingResult }
        }.onFailure { exception ->
            logeukes(type = LoggerType.E) { exception }
            emitException(exception)
        }
    }

    fun getTmapReverseGeocodingData(lat : Long, lon: Long) = viewModelScope.launch {
        tMapReverseGeocodingUseCase(lat, lon).onSuccess { reverseGeocodingResult ->
            logeukes { reverseGeocodingResult }
        }.onFailure { exception ->
            logeukes(type = LoggerType.E) { exception }
            emitException(exception)
        }
    }

    fun reimportPosts() = viewModelScope.launch {
        importPostsUseCase()
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
        importScheduleUseCase(ownerId)
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

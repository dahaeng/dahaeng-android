/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Store.kt] created by Ji Sungbin on 22. 1. 13. 오후 7:51
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import team.dahaeng.android.domain.aouth.model.User
import team.dahaeng.android.domain.schedule.model.Schedule

@Suppress("ObjectPropertyName")
object DataStore {
    lateinit var me: User

    private val _schedules = MutableStateFlow<List<Schedule>>(emptyList())
    val schedules = _schedules.asStateFlow()

    suspend fun updateSchedules(schedules: List<Schedule>) {
        _schedules.emit(schedules)
    }
}

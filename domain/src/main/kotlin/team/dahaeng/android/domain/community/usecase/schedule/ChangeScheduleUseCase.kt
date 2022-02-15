/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ChangeScheduleUseCase.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.usecase.schedule

import team.dahaeng.android.domain.community.model.schedule.Schedule
import team.dahaeng.android.domain.community.repository.FirebaseRepository

class ChangeScheduleUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(schedule: Schedule) = runCatching {
        repository.changeSchedule(schedule)
    }
}
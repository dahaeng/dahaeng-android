/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [DeleteScheduleUseCase.kt] created by Ji Sungbin on 22. 2. 7. 오후 5:26
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.usecase.schedule

import team.dahaeng.android.domain.community.model.Schedule
import team.dahaeng.android.domain.community.repository.FirebaseRepository

class DeleteScheduleUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(schedule: Schedule) = runCatching {
        repository.deleteSchedule(schedule)
    }
}

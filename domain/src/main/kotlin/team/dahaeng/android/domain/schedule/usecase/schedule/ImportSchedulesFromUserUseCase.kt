/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ImportScheduleUseCase.kt] created by Ji Sungbin on 22. 2. 7. 오후 5:25
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.usecase.schedule

import team.dahaeng.android.domain.schedule.model.SimpleAddress
import team.dahaeng.android.domain.schedule.repository.FirebaseRepository

class ImportSchedulesFromUserUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(
        address: SimpleAddress,
        userId: Long,
    ) = runCatching {
        repository.importSchedulesFromUser(
            address = address,
            userId = userId
        )
    }
}

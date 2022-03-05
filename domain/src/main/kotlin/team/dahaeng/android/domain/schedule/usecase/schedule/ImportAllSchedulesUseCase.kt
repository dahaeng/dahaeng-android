/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ImportAllSchedulesUseCase.kt] created by Ji Sungbin on 22. 3. 5. 오후 2:44
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.usecase.schedule

import team.dahaeng.android.domain.schedule.model.SimpleAddress
import team.dahaeng.android.domain.schedule.repository.FirebaseRepository

class ImportAllSchedulesUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(address: SimpleAddress) = runCatching {
        repository.importAllSchedules(address = address)
    }
}

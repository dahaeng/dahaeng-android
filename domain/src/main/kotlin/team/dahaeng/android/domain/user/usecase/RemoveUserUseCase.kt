/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [RemoveUserUseCase.kt] created by Ji Sungbin on 22. 3. 5. 오후 10:04
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.user.usecase

import team.dahaeng.android.domain.user.repository.UserRepository

class RemoveUserUseCase(private val repo: UserRepository) {
    suspend operator fun invoke(userId: Long) = runCatching {
        repo.removeUser(userId)
    }
}

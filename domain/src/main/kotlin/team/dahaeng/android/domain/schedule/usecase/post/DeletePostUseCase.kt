/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [DeletePostUseCase.kt] created by Ji Sungbin on 22. 3. 4. 오후 2:13
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.usecase.post

import team.dahaeng.android.domain.schedule.repository.FirebaseRepository

class DeletePostUseCase(private val repo: FirebaseRepository) {
    suspend operator fun invoke(postId: Long) = runCatching {
        repo.deletePost(postId)
    }
}

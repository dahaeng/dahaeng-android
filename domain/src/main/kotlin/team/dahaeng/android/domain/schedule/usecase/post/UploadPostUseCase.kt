/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [UploadPostToStorageUseCase.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.usecase.post

import team.dahaeng.android.domain.schedule.model.post.Post
import team.dahaeng.android.domain.schedule.repository.FirebaseRepository

class UploadPostUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(post: Post) = runCatching {
        repository.uploadPost(post)
    }
}
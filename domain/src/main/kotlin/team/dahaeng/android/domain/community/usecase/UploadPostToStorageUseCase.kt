/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [UploadPostToStorageUseCase.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.usecase

import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.community.repository.FirebaseRepository

class UploadPostToStorageUseCase(private val repository: FirebaseRepository) {
    operator fun invoke(post : Post) = try {
        repository.uploadPost(post)
    } catch (exception: Exception){
        // upload fail exception
    }
}
/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ImportFirebaseStorageUseCase.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.usecase

import team.dahaeng.android.domain.community.repository.FirebaseRepository
import team.dahaeng.android.domain.community.model.Post

class ImportFirebaseStorageUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(): List<Post> {
        try {
            return repository.importPost()
        } catch (exception: Exception) {
            // upload fail exception
            return listOf()
        }
    }
}
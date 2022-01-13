/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [UploadFirebaseStorageUseCase.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.usecase

import android.net.Uri
import team.dahaeng.android.domain.community.repository.FirebaseRepository

class UploadImageToStorageUseCase(private val repository: FirebaseRepository) {
    suspend operator fun invoke(uri: Uri, imgFileName: String) = runCatching {
        repository.uploadImage(uri, imgFileName)
    }
}

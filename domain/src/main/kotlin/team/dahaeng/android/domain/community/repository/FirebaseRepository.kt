/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [FirebaseRepository.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.repository

import android.net.Uri
import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.community.model.PostResult

interface FirebaseRepository {
    fun uploadImage(uri: Uri, imgFileName: String)
    fun uploadPost(post: Post)
    suspend fun importPost(): PostResult
}

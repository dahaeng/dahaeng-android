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
import team.dahaeng.android.domain.community.model.Schedule

interface FirebaseRepository {
    suspend fun uploadImage(uri: Uri, imageName: String): String?
    suspend fun uploadPost(post: Post): Boolean
    suspend fun importPosts(): List<Post>
    suspend fun importSchedules(ownerId: Long): List<Schedule>
    suspend fun uploadSchedule(schedule: Schedule): Boolean
    suspend fun deleteSchedule(schedule: Schedule): Boolean
}

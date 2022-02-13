/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [FirebaseRepository.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.repository

import team.dahaeng.android.domain.community.model.post.Photo
import team.dahaeng.android.domain.community.model.post.Post
import team.dahaeng.android.domain.community.model.schedule.Schedule

interface FirebaseRepository {
    /**
     * 포스트 업로드에 쓰일 이미지들 업로드
     */
    suspend fun uploadPhotos(photos: List<Photo>, imageName: String): String?
    suspend fun uploadPost(post: Post): Boolean
    suspend fun importPosts(): List<Post>
    suspend fun deletePost(): Boolean
    suspend fun importSchedules(ownerId: Long): List<Schedule>
    suspend fun uploadSchedule(schedule: Schedule): Boolean
    suspend fun deleteSchedule(schedule: Schedule): Boolean
}

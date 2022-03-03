/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [FirebaseRepository.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.repository

import team.dahaeng.android.domain.community.model.common.Photo
import team.dahaeng.android.domain.community.model.post.Post
import team.dahaeng.android.domain.community.model.schedule.Schedule

interface FirebaseRepository {
    /**
     * 포스트 업로드에 쓰일 이미지들 업로드
     *
     * @param photos 업로드할 이미지 리스트
     * @param parentPath Firebase Storage 에 업로드 될 collection 경로
     * @param exceptionHandler 이미지 업로드중 발생했을 때 실행될 콜백
     *
     * @return 이미지 다운로드 주소 배열
     * 중간이 업로드 실패한 이미지는 null 로 대체하여 반환
     */
    suspend fun uploadPhotos(
        photos: List<Photo>,
        parentPath: String,
        exceptionHandler: (exception: Exception) -> Unit,
    ): List<String?>

    /**
     * 포스트 업로드
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun uploadPost(post: Post)

    /**
     * 전체 포스트 조회
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun importAllPosts(): List<Post>

    /**
     * 포스트 삭제
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun deletePost(postId: Long)

    /**
     * 특정 유저의 전체 일정 조회
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun importSchedules(userId: Long): List<Schedule>

    /**
     * 스케쥴 업로드/업데이트
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun uploadSchedule(schedule: Schedule)

    /**
     * 스케쥴 삭제
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun deleteSchedule(
        userId: Long,
        scheduleId: Long,
    )
}

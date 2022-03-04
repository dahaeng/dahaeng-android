/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [FirebaseRepository.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.repository

import team.dahaeng.android.domain.schedule.model.Photo
import team.dahaeng.android.domain.schedule.model.Schedule

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
     * 특정 유저의 전체 일정 조회
     *
     * @param address 일정을 조회할 주소
     * @param userId 일정을 조회할 유저의 아이디
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun importSchedulesFromUser(
        address: String,
        userId: Long,
    ): List<Schedule>

    /**
     * 전체 일정 조회
     *
     * @param address 일정을 조회할 주소
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun importAllSchedules(address: String): List<Schedule>

    /**
     * 일정 업로드/업데이트
     *
     * @param address 일정을 저장할(저장된) 주소
     * @param schedule 작업할 일정
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun uploadSchedule(
        address: String,
        schedule: Schedule,
    )

    /**
     * 일정 삭제
     *
     * @param address 일정이 저장된 주소
     * @param userId 일정의 주인 (해당 일정을 만든 사람)
     * @param scheduleId 일정의 아이디
     *
     * @throws Exception 실패시 repository 내부에서 throw
     */
    suspend fun deleteSchedule(
        address: String,
        userId: Long,
        scheduleId: Long,
    )
}

/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginRepository.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:29
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.user.repository

import team.dahaeng.android.domain.user.model.KakaoProfile
import team.dahaeng.android.domain.user.model.User

interface UserRepository {
    /**
     * 카카오 로그인으로 카카오 프로필 요청
     *
     * @throws Exception 작업 실패시 내부에서 throw
     */
    suspend fun kakaoLogin(): KakaoProfile

    /**
     * 회원 등록 및 업데이트
     * Firestore 에 유저 프로필 ([User]) 업로드
     *
     * @throws Exception 작업 실패시 내부에서 throw
     */
    suspend fun updateUser(user: User)

    /**
     * 회원 탈퇴
     * Firestore 에서 유저 프로필 ([User]) 삭제
     *
     * @throws Exception 작업 실패시 내부에서 throw
     */
    suspend fun removeUser(user: User)
}

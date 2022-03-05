/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [KakaoProfile.kt] created by Ji Sungbin on 22. 3. 5. 오후 9:41
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.user.model

/**
 * 카카오 로그인으로 얻는 프로필 객체
 *
 * @property id 유저 UUID
 * @property nickname 유저 닉네임
 * @property profileImageSrc 프로필 사진
 * String(프로필 이미지 주소) or ColorDrawable(단일 색) 이 될 수 있음
 */
data class KakaoProfile(
    val id: Long,
    val nickname: String,
    val profileImageSrc: Any,
)

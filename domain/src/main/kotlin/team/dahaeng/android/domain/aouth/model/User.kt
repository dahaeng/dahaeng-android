/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [User.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:01
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.aouth.model

import android.graphics.drawable.ColorDrawable
import kotlin.random.Random

/**
 * 내 정보 객체
 *
 * @property id 유저 UUID
 * @property nickname 유저 닉네임
 * @property profileImageSrc 프로필 사진을 나타내기 위한 필드임
 * String(프로필 이미지 주소) or ColorDrawable(단일 색) 이 될 수 있음
 * @property likeScheduleIds 좋아요한 일정 아이디들
 * @property joinScheduleIds 참여한 일정 아이디들
 * @property bedges 휙득한 벳지 아이디들
 * @property verifyScehdules 여행 실제 진행이 인증된 일정 아이디들
 */
data class User(
    val id: Long = Random.nextLong(),
    val nickname: String = randomNickname,
    val profileImageSrc: Any = randomColorDrawable,
    val likeScheduleIds: List<Long> = emptyList(),
    val joinScheduleIds: List<Long> = emptyList(),
    val bedges: List<Int> = emptyList(),
    val verifyScehdules: List<Long> = emptyList(),
) {
    private companion object {
        val randomColorDrawable get() = ColorDrawable((Math.random() * 16777215).toInt() or (0xFF shl 24))
        val randomNickname get() = "J${Random.nextInt(1000, 10000)}"
    }
}

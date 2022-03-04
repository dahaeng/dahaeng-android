/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [VoteOption.kt] created by Ji Sungbin on 22. 3. 5. 오전 4:45
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model

/**
 * 투표 옵션 객체
 *
 * @property showName 실명 투표 여부
 * @property timeLimit 제한 시간 (단위: 분)
 */
data class VoteOption(
    val showName: Boolean = false,
    val timeLimit: Int = 0,
)

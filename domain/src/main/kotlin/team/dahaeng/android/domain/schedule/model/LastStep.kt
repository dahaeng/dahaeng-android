/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LastStep.kt] created by Ji Sungbin on 22. 3. 5. 오전 4:39
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model

/**
 * @property level 마지막으로 머무른 일정 단계
 * @property startAt [level] 단계에서 투표가 시작된 시간
 */
data class LastStep(
    val level: Int = 0,
    val startAt: Long = 0L,
)

/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [TravelPeriod.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:42
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

/**
 * 기간 객체
 *
 * 모든 값은 Date().time 형태로 가져옴
 *
 * @property from 시작 일
 * @property to 종료 일
 */
data class Period(
    val from: Long = 0L,
    val to: Long = 0L,
)

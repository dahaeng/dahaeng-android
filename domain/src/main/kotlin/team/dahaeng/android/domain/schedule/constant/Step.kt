/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Step.kt] created by Ji Sungbin on 22. 3. 5. 오후 12:55
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.constant

/**
 * 일정 생성 단계
 *
 * @property Theme 테마 설정 단계 (1번만 가능)
 * @property Price 금액 설정 단계 (한 일정별 여러개 가능)
 * @property Transportation 교통수단 설정 단계 (한 일정별 여러개 가능)
 * @property Preiod 여행 기간 설정 단계 (한 일정별 여러개 가능)
 * @property Photos 여행지 사진 설정 단계 (한 일정별 여러개 가능)
 * @property Accommodation 숙소 설정 단계 (한 일정별 여러개 가능)
 */
@Suppress("MemberVisibilityCanBePrivate")
object Step {
    const val Theme = 0
    const val Price = 1
    const val Transportation = 2
    const val Preiod = 3
    const val Photos = 4
    const val Accommodation = 5
}

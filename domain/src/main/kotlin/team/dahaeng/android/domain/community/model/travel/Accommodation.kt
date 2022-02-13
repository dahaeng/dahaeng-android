/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Accommodation.kt] created by Ji Sungbin on 22. 2. 13. 오후 4:20
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

/**
 * 숙소 객체
 *
 * @property name 숙소 이름
 * @property locate 숙소 위치
 */
data class Accommodation(
    val name: String = "",
    val locate: Locate = Locate(),
)

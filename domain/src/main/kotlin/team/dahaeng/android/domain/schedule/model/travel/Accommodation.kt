/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Accommodation.kt] created by Ji Sungbin on 22. 2. 13. 오후 4:20
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model.travel

import java.io.Serializable
import team.dahaeng.android.domain.util.constant.EmptyString

/**
 * 숙소 객체
 *
 * @property name 숙소 이름
 * @property description 숙소 설명
 * @property locate 숙소 위치
 */
data class Accommodation(
    val name: String = EmptyString,
    val description: String = EmptyString,
    val locate: Locate = Locate(),
) : Serializable

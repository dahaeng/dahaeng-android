/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Theme.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:44
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model.travel

import java.io.Serializable
import team.dahaeng.android.domain.util.constant.EmptyString

/**
 * 테마 객체
 *
 * value class 로 하게 되면 inline 되서 string type 으로 바뀜
 */
data class Theme(
    val name: String = EmptyString,
) : Serializable

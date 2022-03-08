/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Transportation.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:50
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model.travel

import java.io.Serializable
import team.dahaeng.android.domain.util.constant.EmptyString

/**
 * 교통수단 객체
 *
 * @property name 교통수단 이름
 * @property description 교통수단에 대해 자유롭게 추가 설명 기제할 필드 (버스 번호 등등)
 * @property price 교통수단 금액
 */
data class Transportation(
    val name: String = EmptyString,
    val description: String = EmptyString,
    val price: Int = 0,
) : Serializable

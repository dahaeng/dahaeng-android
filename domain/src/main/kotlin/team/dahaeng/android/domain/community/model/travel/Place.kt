/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Place.kt] created by Ji Sungbin on 22. 1. 13. 오후 7:01
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

/**
 * 장소 객체
 *
 * @property price 금액
 * @property name 장소 이름
 * @property locate 장소 위치
 */
data class Place(
    val price: Int = 0,
    val name: String = "",
    val locate: Locate = Locate(),
)

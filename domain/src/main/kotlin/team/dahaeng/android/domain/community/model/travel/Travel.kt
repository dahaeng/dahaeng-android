/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Travel.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:48
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

data class Travel(
    val totalPrice: Long = 0, // 필수, 총 가격
    val transportation: Transportation, // 교통 수단
    val period: Period = Period.NONE, // 기간
    val place: String = "", // 필수, 여행지 이름
    val photos: List<String> = emptyList(), // 여행지 사진
    val theme: Theme = Theme.NONE, // 태그
    val target: Target = Target.NONE // 추천 대상
)
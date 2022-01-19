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
    val totalPrice: Long = 0, // 총 가격
    val transportation: Transportation = Transportation.None, // 교통 수단
    val period: Period = Period.None, // 기간
    val places: List<Place> = emptyList(), // 여행지 목록
    val photos: List<String> = emptyList(), // 여행지 사진
    val theme: Theme = Theme.None, // 태그
    val target: Target = Target.None, // 추천 대상
    val rating: Float = 4.8f, // 평점, 최대 5점
    var commonAddress: String = "" // 공통 주소
)

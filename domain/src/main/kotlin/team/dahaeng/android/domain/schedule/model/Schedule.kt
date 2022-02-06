/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Schedule.kt] created by Ji Sungbin on 22. 2. 4. 오전 12:42
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model

import team.dahaeng.android.domain.community.model.travel.Period
import team.dahaeng.android.domain.community.model.travel.Place
import team.dahaeng.android.domain.community.model.travel.Theme
import team.dahaeng.android.domain.community.model.travel.Transportation
import kotlin.random.Random

data class Schedule(
    val id: Long = Random.nextLong(), // 일정 uuid
    val title: String = "",
    val theme: String = Theme.None.value, // 테마
    val totalPrice: Long = 0, // 총 가격
    val transportation: String = Transportation.None.value, // 교통 수단
    val period: Period = Period(), // 기간
    val photos: List<String> = emptyList(), // 여행지 사진
    val places: List<Place> = emptyList(), // 여행지 목록
    val accommodation: String = "", // 숙소
)

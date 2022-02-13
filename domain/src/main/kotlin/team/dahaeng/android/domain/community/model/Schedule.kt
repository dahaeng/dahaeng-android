/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Schedule.kt] created by Ji Sungbin on 22. 2. 4. 오전 12:42
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model

import team.dahaeng.android.domain.community.model.travel.Period
import team.dahaeng.android.domain.community.model.travel.Place
import team.dahaeng.android.domain.community.model.travel.Theme
import team.dahaeng.android.domain.community.model.travel.Transportation
import java.io.Serializable
import kotlin.random.Random

data class Schedule(
    var id: Long = Random.nextLong(), // 일정 uuid
    var participant: List<Long> = emptyList(), // 일정 참여자 uuid, **first element must be owner id**
    var title: String = "",
    var theme: String = Theme.None.value, // 테마
    var totalPrice: Long = 0, // 총 가격
    var transportation: String = Transportation.None.value, // 교통 수단
    var period: Period = Period(), // 기간
    var photos: List<String> = emptyList(), // 여행지 사진
    var places: List<Place> = emptyList(), // 여행지 목록
    var accommodation: String = "", // 숙소
) : Serializable {
    fun toMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "participant" to participant,
            "title" to title,
            "theme" to theme,
            "totalPrice" to totalPrice,
            "transportation" to transportation,
            "period" to period,
            "photos" to photos,
            "places" to places,
            "accommodation" to accommodation
        )
    }
}

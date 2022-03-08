/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Course.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model.travel

import java.io.Serializable

/**
 * 여행 N일차 코스 객체
 *
 * N일차에 여러가지 장소에 갈 수 있으므로 element 를 리스트로 받음
 *
 * Course 는 Map 안에 들어가서 다중 Array 가능
 *
 * @property placeWithInformation 여행 장소와 그에 해당하는 정보들
 */
data class Course(
    val placeWithInformation: List<PlaceWithInformation> = emptyList(),
) : Serializable

/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Course.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

import java.io.Serializable

/**
 * 여행 코스 객체
 *
 * N일차에 여러가지 장소에 갈 수 있으므로 element 를 리스트로 받음
 *
 * @property transportation 여행지 교통편
 * @property period 여행지에서 머물 기간
 * @property place 여행 장소
 * @property accommodation 머물 숙소
 */
data class Course(
    val transportation: Transportation = Transportation(),
    val period: Period = Period(),
    val place: Place = Place(),
    val accommodation: Accommodation = Accommodation(),
) : Serializable
